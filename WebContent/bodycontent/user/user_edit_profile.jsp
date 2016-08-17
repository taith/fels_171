<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function myFunction(e) {
		document.getElementById("demo" + e).style.display = "block";
	}
</script>

<button onclick="myFunction(1)">Update avatar</button>
<div id="demo1" style="display: none">
	<s:form action="updateavatar" method="post"
		enctype="multipart/	-data">
		<s:file name="userImage" label="Image" />
		<s:submit value="Upload" align="center" />
	</s:form>
</div>
<br />
<button onclick="myFunction(2)">Change name</button>
<div id="demo2" style="display: none">
	<s:form action="changename" method="post">
		<s:textfield name="newName" label="New name"></s:textfield>
		<s:submit value="Change"></s:submit>
	</s:form>
</div>
<br />
<button onclick="myFunction(3)">Change password</button>
<s:actionerror/>
<div id="demo3" style="display: none">
	<s:form action="changepassword" method="post">
		<s:password name="password" label="Current password"></s:password>
		<s:password name="newPassword" label="New password"></s:password>
		<s:password name="confirmPassword" label="Confirm new password"></s:password>
		<s:submit value="Change"></s:submit>
	</s:form>
</div>
