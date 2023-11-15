package com.djz.auth.shiro;


import cn.hutool.extra.spring.SpringUtil;
import com.djz.auth.constant.Constant;
import com.djz.auth.entity.SysUser;
import com.djz.auth.entity.UserToRole;
import com.djz.auth.service.IMenuService;
import com.djz.auth.service.IRoleService;
import com.djz.auth.service.IUserService;
import com.djz.auth.service.IUserToRoleService;
import com.djz.utils.JwtUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author djz
 * @since 2022-10-21
 */
public class MyRealm extends AuthorizingRealm {
    private IUserService userService;
    private IUserToRoleService userToRoleService;
    private IMenuService menuService;
    private IRoleService roleService;
    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (userToRoleService == null) {
            this.userToRoleService =  SpringUtil.getBean(IUserToRoleService.class);
        }
        if (menuService == null) {
            this.menuService = SpringUtil.getBean(IMenuService.class);
        }
        if (roleService == null) {
            this.roleService = SpringUtil.getBean(IRoleService.class);
        }

        String userNo = JwtUtil.getUserNo(principals.toString());
        SysUser user = userService.getById(userNo);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if(null != user){
            UserToRole userToRole = userToRoleService.selectByUserNo(user.getId());

        /*
        Role role = roleService.selectOne(new EntityWrapper<Role>().eq("role_code", userToRole.getRoleCode()));
        //添加控制角色级别的权限
        Set<String> roleNameSet = new HashSet<>();
        roleNameSet.add(role.getRoleName());
        simpleAuthorizationInfo.addRoles(roleNameSet);
        */
            //控制菜单级别按钮  类中用@RequiresPermissions("user:list") 对应数据库中code字段来控制controller
//            ArrayList<String> pers = new ArrayList<>();
//            List<Menu> menuList = menuService.findMenuByRoleCode(userToRole.getRoleCode());
//            for (Menu per : menuList) {
//                if (!ComUtil.isEmpty(per.getCode())) {
//                    pers.add(String.valueOf(per.getCode()));
//                }
//            }
//            Set<String> permission = new HashSet<>(pers);
//            simpleAuthorizationInfo.addStringPermissions(permission);
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        if (userService == null) {
            this.userService = SpringUtil.getBean(IUserService.class);
        }
        String token = (String) auth.getCredentials();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(Constant.METHOD_URL_SET.contains(request.getRequestURI())){
            request.setAttribute("currentUser", SysUser.builder().build());
            return new SimpleAuthenticationInfo(token, token, this.getName());
        }
        // 解密获得username，用于和数据库进行对比
        String userNo = JwtUtil.getUserNo(token);
        if (userNo == null) {
            throw new AuthenticationException("token invalid");
        }
        SysUser userBean = userService.getById(userNo);
        if (userBean == null) {
            throw new AuthenticationException("User didn't existed!");
        }
        if (! JwtUtil.verify(token, userNo, userBean.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }
        return new SimpleAuthenticationInfo(token, token, this.getName());
    }
}
