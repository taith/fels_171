<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	
	  <div class="dropdown">
    <button class="btn dropdown-toggle" type="button" data-toggle="dropdown">
    	${pageContext.request.userPrincipal.name}
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="<s:url value="/user/editprofile"/>">Edit profile</a></li>
      <li role="separator" class="divider"></li>
      <li><a href="<s:url value="/j_spring_security_logout"/>">Logout</a></li>
    </ul>
  </div>
</sec:authorize>
<hr/>
