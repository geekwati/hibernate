<%@ page import="org.domain.UserDetail,java.util.*" %>
	<div class="col-sm-offset-9 col-sm-4"><a class="btn btn-default new-user" >New</a></div>
	<table  class="table table-hover table-striped">
		<tbody>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<UserDetail> list = (ArrayList<UserDetail>)request.getAttribute("list");
				String uId;
				for(UserDetail user : list) {
					uId = ""+user.getUserId();
			%>
					<tr class= "show-list" > 
						
						<td class="col-sm-4"><%= user.getUserName()%></td>
						<td class="col-sm-4 "><a data-userid="<%= uId %>" class="btn btn-default show-user">View</a></td>
						<!-- <td class="col-sm-4"><a>Update</a></td> -->
					</tr>
			<% 
				}	
			%>
		</tbody>
	</table>
