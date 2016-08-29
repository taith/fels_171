<%@ taglib prefix="s" uri="/struts-tags"%>

<font color=""><s:actionerror /></font>
<h2>Imput User Info</h2>
<div>
	<form action="new" method="post">
		<div class="form-group">
			<label for="username" class="col-md-3 control-label">Email*</label>
			<div class="col-md-9">
				<input type="email" class="form-control" id="email"
					name="user.email" placeholder="Email" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-md-3 control-label">Name*</label>
			<div class="col-md-9">
				<input type="text" class="form-control" id="name" name="user.name"
					placeholder="Name" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-3 control-label">Password*</label>
			<div class="col-md-9">
				<input type="password" class="form-control" id="password"
					name="user.password" placeholder="Password" required="required"
					pattern=".{3,16}">
			</div>
		</div>
		<div class="form-group">
			<div class="col-md-7">
				<input type="submit" value="Add"></input> <input type="reset"
					value="Reset"></input>
			</div>
		</div>
	</form>
</div>
