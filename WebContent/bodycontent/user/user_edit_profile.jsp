<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function myFunction(e) {
		document.getElementById("demo1").style.display = "none";
		document.getElementById("demo2").style.display = "none";
		document.getElementById("demo3").style.display = "none";
		document.getElementById("demo" + e).style.display = "block";
	}
</script>

<button onclick="myFunction(1)">Update avatar</button>
<div id="demo1" style="display: none">
	<s:form action="updateavatar" method="post" enctype="multipart/	-data">
		<label for="username" class="col-md-1 control-label">Image*</label>
		<s:file name="userImage" />
		<s:submit value="Upload" align="center" />
	</s:form>
</div>
<br />
<button onclick="myFunction(2)">Change name</button>
<div id="demo2" style="display: none">
	<s:form action="changename" method="post">
		<label for="username" class="col-md-1 control-label">New name*</label>
		<s:textfield name="newName" placeholder="New name"></s:textfield>
		<s:submit value="Change"></s:submit>
	</s:form>
</div>
<br />
<button onclick="myFunction(3)">Change password</button>
<s:actionerror />
<div id="demo3" style="display: none">
	<form action="changepassword" method="post">
		<div class="form-group">
			<label for="username">Current password*</label>
			<input type="password" name="password" placeholder="Password"></input>
		</div>
		<div class="form-group">
			<label for="username">New password*</label>
			<input type="password" name="newPassword" placeholder="New password"></input>
		</div>
		<div class="form-group">
			<label for="username">Confirm new password*</label>
			<input type="password" name="confirmPassword" placeholder="Confirm password"></input>
		</div>
		<div class="form-group">
			<input type="submit" value="Change"></input>
		</div>
	</form>
</div>
