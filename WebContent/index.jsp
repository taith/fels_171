<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<a href="<s:url value="/user/findByUserId"/>1">Show</a>
<sec:authorize access="isAnonymous()">
	<a href="<s:url value="/signup"/>">Sign Up</a>
	<a href="<s:url value="/login"/>">Login</a>
</sec:authorize>
