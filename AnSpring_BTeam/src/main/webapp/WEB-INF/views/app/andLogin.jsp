<%@page import="com.google.gson.Gson"%>
<%@page import="com.bteam.app.dto.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Gson gson = new Gson();
String json = gson.toJson((UserVO) request.getAttribute("dto"));

out.println(json);
%>