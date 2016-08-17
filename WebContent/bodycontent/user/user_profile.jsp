<%@taglib prefix="s" uri="/struts-tags"%>
<h1>Here are yours profile</h1>
<%
	Object obj = request.getSession().getAttribute("email");
	out.print("Get from session: "+obj);
%>
<br/>
<img src="../<s:property value="user.avatar"/>" style="width: 100px;height:auto;"/><br/>
Join in :<s:property value="user.created_at"/><br/>
Name: ${user.name}<br/>
<a href="editprofile">Edit Profile</a>
