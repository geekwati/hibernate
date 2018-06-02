<%@ page import="org.domain.Permission,java.util.*" %>
<div id="test"></div>
<form class="form-horizontal">
	<% Object roleStatus=session.getAttribute("status");
		String roleName="";
		if(roleStatus!=null) {
			roleName=request.getParameter("roleName");
		}
		session.removeAttribute("status");
	%>
	
	<!-- Take Role name -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="roleName">Role Name:</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="roleName" name="roleName" placeholder="Role Name" 
			value="<%= roleName%>">
		</div>
	</div>
	<!-- Choose Permissions from Permission List  -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="permList">Choose Permissions :</label>
	
	<%
		@SuppressWarnings("unchecked")
		ArrayList<Permission> listPerm = (ArrayList<Permission>)request.getAttribute("listPerm");
		String pId;
		for(Permission perm : listPerm) {
			pId = ""+perm.getPermissionId();
	%>
		<div class="col-sm-8">
			<input type="checkbox" class="chk" name="permission" value="<%= pId%>"> <%= perm.getPermissionName() %>
		</div>
	
	<%
		}
	%>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-4 col-sm-2">
			<button type="button" class="btn btn-default" id="create-role">Submit</button>
		</div>
		<div class="col-sm-offset-1 col-sm-2">
			<a class="btn btn-default" onClick="getRoleList()">Back</a>
		</div>
	</div>
		
	

</form>