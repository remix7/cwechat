<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="description" content="">
<meta name="author" content="Custom Theme">
	<!-- END META -->
	<!-- BEGIN SHORTCUT ICON -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/img/favicon.ico">
	<!-- END SHORTCUT ICON -->
<title>Cynara - REGISTER</title>
<!-- BEGIN STYLESHEET-->
<link
	href="${pageContext.request.contextPath}/styles/css/bootstrap.min.css"
	rel="stylesheet">
	<!-- BOOTSTRAP CSS -->
<link
	href="${pageContext.request.contextPath}/styles/css/bootstrap-reset.css"
	rel="stylesheet">
	<!-- BOOTSTRAP CSS -->
<link
	href="${pageContext.request.contextPath}/styles/assets/font-awesome/css/font-awesome.css"
	rel="stylesheet">
	<!-- FONT AWESOME ICON CSS -->
<link href="${pageContext.request.contextPath}/styles/css/style.css"
	rel="stylesheet">
	<!-- THEME BASIC CSS -->
<link
	href="${pageContext.request.contextPath}/styles/css/style-responsive.css"
	rel="stylesheet">
	<!-- THEME RESPONSIVE CSS -->
	<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/js/html5shiv.js">
</script>
<script src="${pageContext.request.contextPath}/js/respond.min.js">
</script>
<![endif]-->
	<!-- END STYLESHEET-->
</head>
<body class="login-screen">
<DIV align="right" style="margin-top: 3px;margin-right: 5%">
	<a href="i18nR?locale=zn_CH"><IMG alt="" src="${pageContext.request.contextPath}/images/img/cn.png" width="20px" height="20px"/></a>
	<a href="i18nR?locale=en_US"><IMG alt="" src="${pageContext.request.contextPath}/images/img/us.png" width="20px" height="20px" /></a>
</DIV>
	<!-- BEGIN SECTION -->
	<div class="container">
		<form class="form-signin" action="${pageContext.request.contextPath}/register" method="post">
			<h2 class="form-signin-heading">
				<fmt:message key="i18n.registernow" />
			</h2>
			${error}
			<!-- LOGIN WRAPPER  -->
			<div class="login-wrap">
				<input type="text" name="username" class="form-control" value="${user.username}" placeholder=<fmt:message key="i18n.username"/>></input><H6 align="right" style="font-size: 1;color: red;">${username}</H6>
				<input type="text" name="usercode" class="form-control" value="${user.usercode }" placeholder=<fmt:message key="i18n.usercode"/>></input><H6 align="right" style="font-size: 1;color: red;">${usercode}</H6>
				<input type="password" name="password" class="form-control"  placeholder=<fmt:message key="i18n.password"/>></input><H6 align="right" style="font-size: 1;color: red;">${password}</H6>
				<input type="text" name="phone" value="${user.phone }" class="form-control" placeholder=<fmt:message key="i18n.phone"/>></input><H6 align="right" style="font-size: 1;color: red;">${phone}</H6>
				<input type="text" name="email" value="${user.email }" class="form-control" placeholder=<fmt:message key="i18n.email"/>></input><H6 align="right" style="font-size: 1;color: red;">${email}</H6>
				<DIV>
					<input type="text"  name="randomcode" placeholder=<fmt:message key="i18n.validatecode"/> style="width:75% ;font-size: 12px;padding: 10px;border: 1px solid #eaeaea;font-family: 'Open Sans', sans-serif;"/>
					<IMG alt="validateCode" src="${pageContext.request.contextPath}/ValidateCode" style="" /> 
					<s:if test="${randomCode!=null}">
					<H6 align="right" style="font-size: 1;color: red;"><fmt:message key="i18n.Validatecodeerror"/> </H6>
					</s:if>
				</DIV>
				<button class="btn btn-lg btn-login btn-block" type="submit">
					<fmt:message key="i18n.submit" />
				</button>
				<div class="registration">
					<fmt:message key="i18n.haveanaccountyet" />
					<%-- 登录 --%>
					<a class="" href="${pageContext.request.contextPath}/login"><fmt:message key="i18n.login" /></a>
				</div>
			</div>
		</form>
			<!-- END LOGIN WRAPPER -->
	</div>
	<!-- END SECTION -->
	<!-- BEGIN JS -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<!-- BASIC JQUERY LIB. JS -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
