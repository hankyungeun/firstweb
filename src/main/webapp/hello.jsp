
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first jsp</title>
</head>
<body>
<%
int count = Integer.parseInt(request.getParameter("count"));
for(int i = 0; i < count; i++){ %>
<h1>안녕 <%=request.getParameter("name") %></h1>

<%} %>
</body>
</html>