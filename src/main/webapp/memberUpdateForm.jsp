<%@ page import="kr.ac.sku.dto.MemberDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="kr.ac.sku.service.MemberService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //DB에서 id에 해당하는 정보를 얻어온다.
    MemberService service = new MemberService();
    MemberDTO member = service.getMember(request.getParameter("id"));
%>
<h1>회원정보수정</h1>
<form action="memberUpdate" method="post">
    아이디 : <input type="text" name="id" value="<%=member.getId()%>" readonly="readonly"><br>
    이름 : <input type="text" name="name" value="<%=member.getName()%>"><br>
    비밀번호 : <input type="password" name="password" value="<%=member.getPassword()%>"><br>
    이메일 : <input type="email" name="email" value="<%=member.getEmail()%>"><br>
    <input type="submit" value="회원정보수정">
    <input type="reset" value="취소">
</form>
</body>
</html>
