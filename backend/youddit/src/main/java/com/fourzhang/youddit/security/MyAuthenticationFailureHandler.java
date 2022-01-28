package com.fourzhang.youddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.alibaba.fastjson.JSON;
import com.fourzhang.youddit.data.Result;
import com.fourzhang.youddit.data.ResultCode;
import com.fourzhang.youddit.data.ResultTool;


@Configuration
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		Result<Integer> result = null;
		String name = request.getParameter("name");
        String password = request.getParameter("password");
        String res = bCryptPasswordEncoder.encode(password);
        System.out.printf("%s: %s\n", name, password);
        System.out.printf("%s: %s\n", name, res);
		if (exception instanceof BadCredentialsException) {
            // password error
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (exception instanceof InternalAuthenticationServiceException) {
            // no such user
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }else{
            // other errors
            result = ResultTool.fail(ResultCode.COMMON_FAIL);
        }
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(JSON.toJSONString(result));
	}

}
