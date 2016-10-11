<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Custom Theme">
	<!-- END META -->
	<!-- BEGIN SHORTCUT ICON -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/img/favicon.ico">
	<!-- END SHORTCUT ICON -->
<title>Cynara - LOGIN</title>
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
	<a href="i18nL?locale=zn_CH"><IMG alt="" src="${pageContext.request.contextPath}/images/img/cn.png" width="20px" height="20px" /></a>
	<a href="i18nL?locale=en_US"><IMG alt="" src="${pageContext.request.contextPath}/images/img/us.png" width="20px" height="20px" /></a>
</DIV>
	<!-- BEGIN SECTION -->
	<div class="container">
		<form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
			<h2 class="form-signin-heading">
				<fmt:message key="i18n.signinnow" />
			</h2>
			<!-- LOGIN WRAPPER  -->
			<div class="login-wrap">
				<input type="text" name="username" class="form-control" placeholder=<fmt:message key="i18n.usercode"/>></input>
				<input type="password" name="password" class="form-control" placeholder=<fmt:message key="i18n.password"/>></input>
				<DIV>
					<input type="text"  name="randomcode" placeholder=<fmt:message key="i18n.validatecode"/> style="width:75% ;font-size: 12px;padding: 10px;border: 1px solid #eaeaea;font-family: 'Open Sans', sans-serif;"/>
					<IMG alt="validateCode" src="${pageContext.request.contextPath}/ValidateCode" style="" /> 
				</DIV>
				<label class="checkbox"> 
				<input type="checkbox" name="rememberMe" ><fmt:message key="i18n.rememberMe" /> 
					<span class="pull-right">
						<a data-toggle="modal" href="#myModal"><fmt:message key="i18n.forgotpassword"/> </a>
					</span>
				</label>
				<button class="btn btn-lg btn-login btn-block" type="submit">
					<fmt:message key="i18n.submit" />
				</button>
				<div class="registration">
					<fmt:message key="i18n.Don'thaveanaccountyet" />
					<%-- 注册 --%>
					<a class="" href="${pageContext.request.contextPath}/register"><fmt:message key="i18n.Createanaccount" /></a>
				</div>
			</div>
		</form>
			<!-- END LOGIN WRAPPER -->
			<!-- MODAL -->
			<div id="myModal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">
								<fmt:message key="i18n.forgotpassword" />
							</h4>
						</div>
						<form action="123" method="post">
							<div class="modal-body">
								<p>
									<fmt:message key="i18n.Enteryoure-mailaddressbelowtoresetyourpassword" />
								</p>
								<input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
								<DIV>
									<input type="text"  name="validatecode" placeholder=<fmt:message key="i18n.validatecode"/> style="width:100px ;font-size: 12px;padding: 10px;border: 1px solid #eaeaea;font-family: 'Open Sans', sans-serif;margin-top: 10PX"/>
									<IMG alt="validateCode" src="${pageContext.request.contextPath}/ValidateCode" style="" /> 
								</DIV>
							</div>
							<div class="modal-footer">
								<button data-dismiss="modal" class="btn btn-default"
									type="button">
									<fmt:message key="i18n.Cancel" />
								</button>
								<button class="btn btn-success" type="button">
									<fmt:message key="i18n.submit" />
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- END MODAL -->
	</div>
	<!-- END SECTION -->
	<!-- BEGIN JS -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<!-- BASIC JQUERY LIB. JS -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- BOOTSTRAP JS -->
<%@ include file="/WEB-INF/views/public/footer.jspf"%>
