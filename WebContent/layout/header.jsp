<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	${pageContext.request.userPrincipal.name}
	<a href="<s:url value="/j_spring_security_logout"/>">Logout</a>
</sec:authorize>
<hr/>
