<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	
<a href="<s:url value="/user/findByUserId"/>1">Show</a>
<a href="<s:url value="/user/findByUsername"/>">Find by name</a>
<a href="<s:url value="/user/signup"/>">Sign Up</a>

<sec:authorize access="isAuthenticated()">
	${pageContext.request.userPrincipal.name}
	<a href="j_spring_security_logout">Logout</a>
</sec:authorize>
<sec:authorize access="isAnonymous()">
	<a href="<s:url value="/login"/>">Login</a>
</sec:authorize>
	

