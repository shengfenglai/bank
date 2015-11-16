var flag1=false;
var flag2=false;
function register() {
	if(flag1 == false && flag2 == false) {
		$("#ss").html("<img src='images/tishi.jpg' height='20'>用户名必须在6-12位之间");
		$("#ss1").html("<img src='images/tishi.jpg' height='20'>密码必须是一个六位数 ");
	} else {
		$("#regForm").get(0).submit();
	}
}
function checkUsername() {
	var username = $("#username").val();
	if(username.length < 6 || username.length > 12) {
		$("#ss").html("<img src='images/tishi.jpg' height='20'>用户名必须在6-12位之间");
		flag1 = false;
	} else {
		$.get("checkUsername.do",{"username":username},callback);
		function callback(data) {
			if("用户名已存在"==data.trim()) {
				$("#ss").html("<img src='images/tishi.jpg' height='20'>"+data);
				$("#username").val("");
				flag1 = false;
			} else {
				$("#ss").html("<img src='images/tishi.jpg' height='20'>"+data);
				flag1 = true;
			}
		}
	}
}



function checkPassword() {
	var password = $("#password").val();
	var pwdRex = /^\d+$/ ;
	if(password.length == 6 && pwdRex.test(password)) {
		$("#ss1").html("<img src='images/tishi.jpg' height='20'>密码符合规范 ");
		flag2 = true;
	} else {
		$("#ss1").html("<img src='images/tishi.jpg' height='20'>密码必须是一个六位数 ");
		flag2 = false;
	}
}



