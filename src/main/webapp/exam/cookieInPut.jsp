<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//디폴드X, 이름, 값을 받는 쿠키
    Cookie cookie = new Cookie("ssss","carami");
    cookie.setPath("/");
    cookie.setMaxAge(-1);                 //쿠키 유지시간 (-1)-> 브라우저가 유지될 때 까지

    response.addCookie(cookie);               //클라이언트에 쿠키 넘기기(쿠키저장)
%>
