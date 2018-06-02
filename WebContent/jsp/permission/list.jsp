<%@ page import="org.domain.Permission,java.util.*" %>
	<div class="col-sm-offset-9 col-sm-4"><a class="btn btn-default" onClick="newPermission()">New</a></div>
	<table  class="table table-hover table-striped">
		<tbody>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<Permission> list = (ArrayList<Permission>)request.getAttribute("list");
				String pId;
				for(Permission perm : list) {
					pId = ""+perm.getPermissionId();
			%>
					<tr class= "show-list" > 
						
						<td class="col-sm-4"><%= perm.getPermissionName()%></td>
						<td class="col-sm-4 "><a data-permid="<%= pId %>" class="btn btn-default show-perm">View</a></td>
						<!-- <td class="col-sm-4"><a>Update</a></td> -->
					</tr>
			<% 
				}	
			%>
		</tbody>
	</table>
