<%@ page import="org.domain.Permission,org.domain.Role,java.util.*" %>
<div id="test"></div>
<form class="form-horizontal">
	<% Object userStatus=session.getAttribute("status");
		String userName="";
		if(userStatus!=null) {
			userName=request.getParameter("userName");
		}
		session.removeAttribute("status");
	%>
	
	<!-- Take User name -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="userName">User Name:</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="userName" name="userName" placeholder="User Name" 
			value="<%= userName%>">
		</div>
	</div>
	<!-- Choose Roles from Role List  -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="permList">Choose Roles :</label>
	
	<%
		@SuppressWarnings("unchecked")
		ArrayList<Role> listRole = (ArrayList<Role>)request.getAttribute("listRole");
		String rId;
		for(Role role : listRole) {
			rId = ""+role.getRoleId();
	%>
		<div class="col-sm-8">
			<input type="checkbox" class="chk1" name="permission" value="<%= rId%>"> <%= role.getRoleName() %>
		</div>
	
	<%
		}
	%>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-4 col-sm-2">
			<button type="button" class="btn btn-default" id="create-user">Submit</button>
		</div>
		<div class="col-sm-offset-1 col-sm-2">
			<a class="btn btn-default" onClick="getUserList()">Back</a>
		</div>
	</div>
		
	

</form>