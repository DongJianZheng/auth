package com.djz.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.djz.auth.entity.InfoToUser;
import com.djz.auth.mapper.InfoToUserMapper;
import com.djz.auth.service.IInfoToUserService;
import org.springframework.stereotype.Service;


/**
 * @author djz
 */
@Service
public class InfoToUserServiceImpl extends ServiceImpl<InfoToUserMapper, InfoToUser> implements IInfoToUserService {

}
