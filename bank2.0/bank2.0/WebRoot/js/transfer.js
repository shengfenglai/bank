function transfer() {
	var username = $("#username").val();
	var money = $("#money").val();
	var moneyRex = /^[1-9]\d*$/;
	if(!moneyRex.test(money)) {
		$("#transfer").html("<img src='images/tishi.jpg' height='20'>金额只能是正整数");
		return;
	}else {
		$.post("transfer.do",{"username":username,"money":money},function(data){
			if(data !== null && data !== ""){
				$("#transfer").html("<img src='images/tishi.jpg' height='20'>" + data);
			} else {
				$("#tranForm").get(0).submit();
				alert("转账成功");
				window.location.href="index.jsp";
			}
		});
		
	}
}


