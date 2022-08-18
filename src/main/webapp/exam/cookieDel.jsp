<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //같은 이름의 쿠키가 생성되면 기존의 쿠키는 없어짐
    //삭제 -> 쿠키 이름을 받아와서 값을 없애준다
    String cookieName = request.getParameter("cookieName");
    Cookie cookie = new Cookie(cookieName,"");
    cookie.setPath("/");
    cookie.setMaxAge(0);

    response.addCookie(cookie);
    response.sendRedirect("showCookie.jsp");
%>
