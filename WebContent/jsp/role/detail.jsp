<%@ page import="org.domain.Role,org.domain.Permission,java.util.Collection" %>
<form class="form-horizontal">
	<%
	Role role= (Role)request.getAttribute("role");
	%>
<!-- Role Name Display -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="roleName">Role Name : </label>
		<div class="col-sm-8"><label class="form-control labelborder" id="roleName">
			<%= role.getRoleName()%></label>
		</div>
	</div>
	<!-- Permissions attached with Role are:  -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="roleName">Permissions attached with Role are : </label>
		
	</div>
	<%
		Collection<Permission> permList =role.getPermissionList();
		int i=1;
		for(Permission perm : permList){
	%>
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="roleName"><%= i++ %> </label>
		<div class="col-sm-8"><label class="form-control labelborder" id="permName">
			<%= perm.getPermissionName()%></label>
		</div>
	</div>
	<%
		}
	%>
	<div class="col-sm-offset-8 col-sm-4"><a class="btn btn-default" onClick="getRoleList()">Back</a></div>
</form>