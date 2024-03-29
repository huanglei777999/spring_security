package com.hl.springsecurity.controller;

import com.hl.springsecurity.model.LoginDetail;
import com.hl.springsecurity.model.ResultMap;
import com.hl.springsecurity.model.TokenDetail;
import com.hl.springsecurity.model.vo.Data;
import com.hl.springsecurity.model.vo.RequestLoginUser;
import com.hl.springsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @version V1.0.0
 * @Description 登陆接口
 */
@RestController
public class LoginController {

    private final LoginService loginService;

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultMap login(@Valid RequestLoginUser requestLoginUser, BindingResult bindingResult){
        // 检查有没有输入用户名密码和格式对不对
        if (bindingResult.hasErrors()){
            return new ResultMap().fail("400").message("缺少参数或者参数格式不对").data("");
        }

        LoginDetail loginDetail = loginService.getLoginDetail(requestLoginUser.getUsername());
        ResultMap ifLoginFail = checkAccount(requestLoginUser, loginDetail);
        if (ifLoginFail != null){
            return ifLoginFail;
        }

        return new ResultMap().success().message("").data(new Data().addObj(tokenHeader, loginService.generateToken((TokenDetail) loginDetail)));
    }

    private ResultMap checkAccount(RequestLoginUser requestLoginUser, LoginDetail loginDetail){
        if (loginDetail == null){
            return new ResultMap().fail("434").message("账号不存在！").data("");
        }else {
            if (loginDetail.enable() == false){
                return new ResultMap().fail("452").message("账号在黑名单中").data("");
            }
            if (!loginDetail.getPassword().equals(requestLoginUser.getPassword())){
                return new ResultMap().fail("438").message("密码错误！").data("");
            }
        }
        return null;
    }

    @PostMapping("/auth")
    public ResultMap auth(){
        return new ResultMap().success().message("欢迎您的到来!");
    }

}
