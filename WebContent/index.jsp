<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserProfileWebApp</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">

<script src="js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/index.js"></script>

</head>
<body class="well">
<div class="row">

		<!-- Menu Bar -->
		<div class="col-sm-2">
			
			<ul class="nav nav-pills nav-stacked">
				<li id="user" class=""><a id="users"><strong>Users</strong></a></li>
				<li id="role" class=""><a id="roles" ><strong>Roles</strong></a></li>
				<li id="permission" class=""><a id="permissions"><strong>Permissions</strong></a></li>

			</ul>
		</div>

		<!-- List -->
		<div class="col-sm-10" style="background-color:white;height:480px	;overflow-y: scroll;border-left: 2px solid grey;">
			<div id="list">
			<% Object status=session.getAttribute("status");

				if(status!=null) {
			%>
					<strong><%= (String)status %></strong>
					
			<% 
				session.removeAttribute("status");
				} %>
				<p>hello   developer</p>
			</div>

		</div>
	</div>
</body>
</html>