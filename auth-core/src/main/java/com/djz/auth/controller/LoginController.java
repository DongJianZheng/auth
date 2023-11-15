package com.djz.auth.controller;


import com.djz.auth.annotation.AccessLimit;
import com.djz.auth.annotation.Pass;
import com.djz.auth.service.IUserService;
import com.djz.auth.vo.LoginRequestVO;
import com.djz.response.ResultBean;
import com.djz.response.ResultHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *  登录接口
 * @author djz
 */
@RestController
public class LoginController {

    @Resource
    private IUserService userService;

    /**
     * 5秒产生一个令牌,放入容量为0.3的令牌桶
     * @param loginRequestVO 登录请求对象
     * @return ResultBean
     */
    @PostMapping("/login")
    @Pass
    @AccessLimit(perSecond=0.3,timeOut = 5000)
    public ResultBean login(@RequestBody @Valid LoginRequestVO loginRequestVO) {
        return ResultHandler.ok(userService.checkMobileAndPasswd(loginRequestVO));
    }
}
