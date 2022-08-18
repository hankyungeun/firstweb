<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    //쿠키 얻어오기
    //쿠키 배열(여러개 들어 있다)은 서버가 만듦
    Cookie[] cookies = request.getCookies();
    //세션은 하나 쿠키를 뒤져서 세션을 찾고, 있으면 return, 없으면 생성

%>
<table>
    <tr>
        <th>쿠키이름</th>
        <th>쿠키 값</th>
        <th>쿠키 삭제</th>

    </tr>
    <% if(cookies != null){
        for(Cookie cookie : cookies){%>
    <tr>
        <td><%=cookie.getName() %></td>
        <td><%=cookie.getValue() %></td>
        <td><a href="cookieDel.jsp?cookieName=<%=cookie.getName() %>">쿠키 삭제</a></td>
    </tr>
    <%}} %>
    </table>
</body>
</html>