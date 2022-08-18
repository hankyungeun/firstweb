<%@ page import="kr.ac.sku.service.MemberService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    MemberService service  = new MemberService();
    int resultValue = service.checkMember(id, password);

    if(resultValue == 1) {
        //아이디 없는 사용자
        response.sendRedirect("memberJoinForm.jsp");
    } else if (resultValue == 2) {
        //비밀번호 틀린 사용자
        response.sendRedirect("loginForm.jsp");
    } else {
        //아이디, 비번 맞는 사용자
        //상태유지해주면 된다
        Cookie cookie = new Cookie("login",id);
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
        response.sendRedirect("memberList");
    }

%>
