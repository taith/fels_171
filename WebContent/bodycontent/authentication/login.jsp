<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
      <font color="red">
        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>. <br/><br/>
        Invalid email or password! Please retry!
      </font>
</c:if>
<!-- Form lognin -->
<div class="container">
	<h3>Login</h3>
   	<s:form class="form-horizontal" name="loginForm" method="POST" action="/j_spring_security_check" namespace="/">
	    <div class="form-group">
	        <label for="username" class="col-md-3 control-label">Email*</label>
	        <div class="col-md-9">
	            <input type="email" class="form-control" id="email" name="email"
	                placeholder="Email" required="required">
	        </div>
	    </div>
	    <br>
	    <br>
	    <div class="form-group">
	        <label for="password" class="col-md-3 control-label">Password*</label>
	        <div class="col-md-9">
	            <input type="password" class="form-control" id="password" name="password"
	                placeholder="Password" required="required" pattern=".{3,16}"> <input
	                type="checkbox" value="yes" name="_spring_security_remember_me" />
	            Remember me
	        </div>
	    </div>
	    <br>
	    <br>
	    <div class="form-group">
	        <div class="col-sm-offset-3 col-md-9">
	            <button type="submit" class="btn btn-primary btn-block">Log in</button>
	        </div>
	    </div>
	</s:form>
</div>
