<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String username="";
	String password="";
	request.setCharacterEncoding("utf-8");//防止中文乱码 
	response.setCharacterEncoding("utf-8");
	response.setHeader("iso-8859-1","utf-8");
	username=request.getParameter("username");
	password=request.getParameter("password");
	if("Marry".equals(username)&&"123".equals(password))
	{
		session.setAttribute("username",username);
		response.sendRedirect("index.jsp");
	}
	else
	{
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
%>