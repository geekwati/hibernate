<%@ page import="org.domain.Permission" %>
<form class="form-horizontal">
	<%
	Permission perm= (Permission)request.getAttribute("perm");
	%>
<!-- Permission Name Display -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="permName">Permission Name : </label>
		<div class="col-sm-8"><label class="form-control labelborder" id="permName">
			<%= perm.getPermissionName()%></label>
		</div>
	</div>
	<div class="col-sm-offset-8 col-sm-4"><a class="btn btn-default" onClick="getPermissionList()">Back</a></div>
</form>