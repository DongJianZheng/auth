package com.djz.auth.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djz.auth.entity.Role;
import com.djz.auth.mapper.RoleMapper;
import com.djz.auth.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 * @author djz
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {



}
