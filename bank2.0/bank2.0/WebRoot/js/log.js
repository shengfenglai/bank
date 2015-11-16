function login() {
	var username = $("#username").val();
	var password  = $("#password").val();
	$.get("login.do",{"username":username,"password":password},function(data){
		if(data !== null && data !== ""){
			$("#login").html("<img src='images/tishi.jpg' height='20'>" + data);
		}else {
			$("#logForm").get(0).submit();
			window.location.href="index.jsp";
		}
	});
}


