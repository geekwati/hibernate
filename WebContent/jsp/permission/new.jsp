<div id="test"></div>
<form class="form-horizontal">
	<% Object permStatus=session.getAttribute("status");
		String permName="";
		if(permStatus!=null) {
			permName=request.getParameter("permName");
		}
		session.removeAttribute("status");
	%>
	
	<!-- Take Permission name -->
	<div class="form-group">
		<label  class="control-label col-sm-2 col-sm-offset-1"  for="permName">Permission Name:</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="permName" name="permName" placeholder="Permission Name" 
			value="<%= permName%>">
		</div>
	</div>
	<div class="form-group"> 
		<div class="col-sm-offset-4 col-sm-2">
			<button type="button" class="btn btn-default" id="create-perm">Submit</button>
		</div>
		<div class="col-sm-offset-1 col-sm-2">
			<a class="btn btn-default" onClick="getPermissionList()">Back</a>
		</div>
	</div>
		
	

</form>