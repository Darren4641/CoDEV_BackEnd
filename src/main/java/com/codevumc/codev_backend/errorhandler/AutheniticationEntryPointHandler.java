package com.codevumc.codev_backend.errorhandler;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AutheniticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String exception = (String) request.getAttribute("exception");
        ErrorCode errorCode;

        if(exception == null) {
            errorCode = ErrorCode.UNAUTHORIZEDException;
            setResponse(response, errorCode);
            return;
        }

        if(exception.equals("ForbiddenException")) {
            errorCode = ErrorCode.ForbiddenException;
            setResponse(response, errorCode);
            return;
        }

        //토큰이 만료된 경우
        if(exception.equals("ExpiredJwtException")) {
            errorCode = ErrorCode.ExpiredJwtException;
            setResponse(response, errorCode);
            return;
        }

        //아이디 비밀번호가 다를 경우
        if(exception.equals("UsernameOrPasswordNotFoundException")) {
            errorCode = ErrorCode.UsernameOrPasswordNotFoundException;
            setResponse(response, errorCode);
        }

    }

    private void setResponse(HttpServletResponse response, ErrorCode errorCode) throws IOException, JSONException {
        JSONObject json = new JSONObject();
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        json.put("code", errorCode.getCode());
        json.put("message", errorCode.getMessage());
        response.getWriter().print(json);

    }
}
;