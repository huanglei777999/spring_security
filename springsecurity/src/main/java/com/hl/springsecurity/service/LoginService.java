package com.hl.springsecurity.service;


import com.hl.springsecurity.model.LoginDetail;
import com.hl.springsecurity.model.TokenDetail;

/**
 * @version V1.0.0
 * @Description
 */
public interface LoginService {

    LoginDetail getLoginDetail(String username);

    String generateToken(TokenDetail tokenDetail);

}
