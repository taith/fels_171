<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="page-header">
	${pageContext.request.userPrincipal.name} You are Admin<br>
</div>

<a href="<s:url value="/admin/user"/>">Manage User</a>
