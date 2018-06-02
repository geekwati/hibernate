<%@ page import="org.domain.Role,java.util.*" %>
	<div class="col-sm-offset-9 col-sm-4"><a class="btn btn-default new-role" >New</a></div>
	<table  class="table table-hover table-striped">
		<tbody>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<Role> list = (ArrayList<Role>)request.getAttribute("list");
				String rId;
				for(Role role : list) {
					rId = ""+role.getRoleId();
			%>
					<tr class= "show-list" > 
						
						<td class="col-sm-4"><%= role.getRoleName()%></td>
						<td class="col-sm-4 "><a data-roleid="<%= rId %>" class="btn btn-default show-role">View</a></td>
						<!-- <td class="col-sm-4"><a>Update</a></td> -->
					</tr>
			<% 
				}	
			%>
		</tbody>
	</table>
