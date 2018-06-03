$(document).on('click', '.new-user', function () {
	$.get("newUser",function(responseText) {  
	
	$("#list").html(responseText); 
}).fail(function(){
	console.log("error");
	
});
});


$(document).on('click', "#create-user",function(){
	var checkIds = $(".chk1:checked").map(function() {
	    return this.value;
	  }).toArray();
	  
	$.post("createUser", {
		userName: $("#userName").val(),
		checkedIds:checkIds
	}, "json")
	.done(function(responseText) { 
				console.log("status code hel="+ responseText)  ;
				console.log("status code hel="+ typeof responseText)  ;
				if(JSON.parse(responseText).success=="true"){
					console.log("Success");
					getUserList();
				} else { 
					console.log("Error");
					var message =`<div id='errormsg' class='col-sm-offset-3 alert alert-danger alert-dismissible'>
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					${JSON.parse(responseText).status}</div>`;
					$("#test").html(message); 
				} 
	}).fail(function(){
				console.log("error");
		});
});

$(document).on('click', '#users', function () {
	getUserList()
});

function getUserList(){
	$("#user").addClass("active");
	$("#role").removeClass("active");
	$("#permission").removeClass("active");
$.get("getUserList",function(responseText) {  
	
	$("#list").html(responseText); 
}).fail(function(){
	console.log("error");
	
});	
}

$(document).on('click', '.show-user', function () {
	console.log($(this).attr('data-userid'));
	$.post("showUser",{
		uId:$(this).attr('data-userid'),
		
	},
	function(responseText) {   
		$("#list").html(responseText); 
	}).fail(function(){
		console.log("error");
    });
});
//////////////////////////





$(document).on('click', '.new-role', function () {
	$.get("newRole",function(responseText) {  
	
	$("#list").html(responseText); 
}).fail(function(){
	console.log("error");
	
});
});


$(document).on('click', "#create-role",function(){
	var checkIds = $(".chk:checked").map(function() {
	    return this.value;
	  }).toArray();
	  
	$.post("createRole", {
		roleName: $("#roleName").val(),
		checkedIds:checkIds
	}, "json")
	.done(function(responseText) { 
				console.log("status code hel="+ responseText)  ;
				console.log("status code hel="+ typeof responseText)  ;
				if(JSON.parse(responseText).success=="true"){
					console.log("Success");
					getRoleList();
				} else { 
					console.log("Error");
					var message =`<div id='errormsg' class='col-sm-offset-3 alert alert-danger alert-dismissible'>
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					${JSON.parse(responseText).status}</div>`;
					$("#test").html(message); 
				} 
	}).fail(function(){
				console.log("error");
		});
});

$(document).on('click', '#roles', function () {
	getRoleList()
});

function getRoleList(){
	$("#role").addClass("active");
	$("#user").removeClass("active");
	$("#permission").removeClass("active");
$.get("getRoleList",function(responseText) {  
	
	$("#list").html(responseText); 
}).fail(function(){
	console.log("error");
	
});	
}

$(document).on('click', '.show-role', function () {
	console.log($(this).attr('data-roleid'));
	$.post("showRole",{
		rId:$(this).attr('data-roleid'),
		
	},
	function(responseText) {   
		$("#list").html(responseText); 
	}).fail(function(){
		console.log("error");
    });
});



$(document).on('click', '#permissions', function () {
	getPermissionList()
});

function getPermissionList(){
	$("#permission").addClass("active");
	$("#role").removeClass("active");
	$("#user").removeClass("active");

$.get("getPermissionList",function(responseText) {  
	
	$("#list").html(responseText); 
}).fail(function(){
	console.log("error");
	
});	
}

function newPermission(){
	$("#list").load('jsp/permission/new.jsp');
}

$(document).on('click', "#create-perm",function(){
		$.post("createPermission", {
			permName: $("#permName").val(),
		}, "json")
		.done(function(responseText) { 
					console.log("status code hel="+ responseText)  ;
					console.log("status code hel="+ typeof responseText)  ;
					if(JSON.parse(responseText).success=="true"){
						console.log("Success");
						getPermissionList();
					} else { 
						console.log("Error");
						var message =`<div id='errormsg' class='col-sm-offset-3 alert alert-danger alert-dismissible'>
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						${JSON.parse(responseText).status}</div>`;
						$("#test").html(message); 
					} 
		}).fail(function(){
					console.log("error");
			});
});

$(document).on('click', '.show-perm', function () {
	console.log($(this).attr('data-permid'));
	$.post("showPermission",{
		pId:$(this).attr('data-permid'),
		
	},
	function(responseText) {   
		$("#list").html(responseText); 
	}).fail(function(){
		console.log("error");
    });
});