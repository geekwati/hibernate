<%@ page import="org.domain.Role,org.domain.Permission,org.domain.UserDetail,java.util.Collection,java.util.ArrayList" %>
<form class="form-horizontal">
	<%
	UserDetail user = (UserDetail)request.getAttribute("user");
	%>
<!-- User Name Display -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="userName">User Name : </label>
		<div class="col-sm-8"><label class="form-control labelborder" id="userName">
			<%= user.getUserName()%></label>
		</div>
	</div>
	<!-- Roles attached with User are:  -->
	<div class="form-group">
		<label  class="control-label col-sm-offset-1"  for="roleName">Roles attached with User are : </label>
		
	</div>
	<%	Collection<Permission> permList = new ArrayList<Permission>();
		Collection<Role> roleList =user.getRoleList();
		int i=1;
		for(Role role : roleList){
	%>
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="roleName"><%= i++ %> </label>
		<div class="col-sm-8"><label class="form-control labelborder" id="roleName">
			<%= role.getRoleName()%></label>
		</div>
	</div>
	<%
		permList.addAll(role.getPermissionList());
		}
	%>
	<!-- Permissions attached with Role are:  -->
	<div class="form-group">
		<label  class="control-label col-sm-offset-1"  for="roleName">Permissions attached with User's Role are : </label>
		
	</div>
	 <%
		//Collection<Permission> permList =role.getPermissionList();
		int j=1;
		for(Permission perm : permList){
	%>
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="permName"><%= j++ %> </label>
		<div class="col-sm-8"><label class="form-control labelborder" id="permName">
			<%= perm.getPermissionName()%></label>
		</div>
	</div>
	<%
		}
	%> 
	
	
	<div class="col-sm-offset-8 col-sm-4"><a class="btn btn-default" onClick="getUserList()">Back</a></div>
</form>