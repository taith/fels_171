<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="page-header">
	Welcome : ${pageContext.request.userPrincipal.name}
</div>

<a href="user/profile">Profile</a>
<a href="<s:url value="/word/list"/>">Word list</a>
