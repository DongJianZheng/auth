package com.djz.auth.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djz.auth.constant.Constant;
import com.djz.auth.entity.InfoToUser;
import com.djz.auth.entity.Menu;
import com.djz.auth.entity.SysUser;
import com.djz.auth.entity.UserToRole;
import com.djz.auth.mapper.SystemUserMapper;
import com.djz.auth.service.IInfoToUserService;
import com.djz.auth.service.IMenuService;
import com.djz.auth.service.IUserService;
import com.djz.auth.service.IUserToRoleService;
import com.djz.auth.vo.LoginRequestVO;
import com.djz.exception.BusinessException;
import com.djz.utils.AssertUtils;
import com.djz.utils.JWTUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务实现类
 * @author djz
 */
@Service
public class UserServiceImpl extends ServiceImpl<SystemUserMapper, SysUser> implements IUserService {

    @Resource
    private IInfoToUserService infoToUserService;


    @Resource
    private IUserToRoleService userToRoleService;

    @Resource
    private IMenuService menuService;


    @Override
    public Map<String, Object> checkMobileAndPasswd(LoginRequestVO loginRequestVO) {
        LambdaQueryWrapper<InfoToUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(InfoToUser::getIdentityInfo, loginRequestVO.getIdentity());
        InfoToUser infoToUser = infoToUserService.getOne(lambdaQueryWrapper);

        AssertUtils.notNull(infoToUser, "用户信息");

        LambdaQueryWrapper<SysUser> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(SysUser::getId, infoToUser.getUserNo());
        userQueryWrapper.eq(SysUser::getStatus, 1);

        SysUser user = this.getOne(userQueryWrapper);
        if (ObjectUtil.isEmpty(user) || !user.getPassword().equals(loginRequestVO.getPassword())) {
            throw new BusinessException("用户或密码不对！");
        }

        return this.getLoginUserAndMenuInfo(user);
    }
    @Override
    public Map<String, Object> getLoginUserAndMenuInfo(SysUser user) {
        Map<String, Object> result = new HashMap<>(3);
        UserToRole userToRole = userToRoleService.selectByUserNo(user.getId());
        user.setToken(JWTUtil.sign(user.getId(), user.getPassword()));
        result.put("user",user);
        List<Menu> buttonList = new ArrayList<>();
        List<Menu> retMenuList = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(userToRole)) {
            //根据角色主键查询启用的菜单权限
            List<Menu> menuList = menuService.findMenuByRoleCode(userToRole.getRoleCode());
            retMenuList = menuService.treeMenuList(Constant.ROOT_MENU, menuList);
            for (Menu buttonMenu : menuList) {
                if(buttonMenu.getMenuType() == Constant.TYPE_BUTTON){
                    buttonList.add(buttonMenu);
                }
            }
        }
        result.put("menuList",retMenuList);
        result.put("buttonList",buttonList);
        return result;
    }
}
