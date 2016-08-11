<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>
	Welcome : ${pageContext.request.userPrincipal.name}<br>
	<a href="j_spring_security_logout">Logout</a>
</h2>
