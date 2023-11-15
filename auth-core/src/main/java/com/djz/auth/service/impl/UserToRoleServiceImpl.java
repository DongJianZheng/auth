package com.djz.auth.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djz.auth.entity.UserToRole;
import com.djz.auth.mapper.UserToRoleMapper;
import com.djz.auth.service.IUserToRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 * @author djz
 */
@Service
public class UserToRoleServiceImpl extends ServiceImpl<UserToRoleMapper, UserToRole> implements IUserToRoleService {

    @Override
//    @Cacheable(value = "UserToRole",keyGenerator="wiselyKeyGenerator")
    public UserToRole selectByUserNo(String userNo) {
        LambdaQueryWrapper<UserToRole> ew = new LambdaQueryWrapper<>();
        ew.eq(UserToRole::getUserNo, userNo);
        List<UserToRole> userToRoleList = this.list(ew);
        return CollUtil.isEmpty(userToRoleList)? null: userToRoleList.get(0);
    }
}
