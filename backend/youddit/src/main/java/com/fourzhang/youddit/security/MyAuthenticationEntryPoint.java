package com.fourzhang.youddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.alibaba.fastjson.JSON;
import com.fourzhang.youddit.data.Result;
import com.fourzhang.youddit.data.ResultCode;
import com.fourzhang.youddit.data.ResultTool;

@Configuration
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		Result<Integer> result = ResultTool.fail(ResultCode.USER_NOT_LOGIN);
		response.setContentType("text/json;charset=utf-8");
		response.getWriter().write(JSON.toJSONString(result));
	}

}
