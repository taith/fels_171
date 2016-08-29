<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<s:url value="/"/>">Framgia
				E-Learning</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<s:url value="/"/>">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				<sec:authorize access="isAnonymous()">
					<li><a href="<s:url value="/signup"/>">Signup</a></li>
					<li><a href="<s:url value="/login"/>">Login</a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">${pageContext.request.userPrincipal.name}<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="<s:url value="/user/editprofile"/>">Edit
									profile</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="<s:url value="/j_spring_security_logout"/>">Logout</a></li>
						</ul></li>
				</sec:authorize>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>
<div class="clear-fix" style="padding-bottom: 30px;"></div>
