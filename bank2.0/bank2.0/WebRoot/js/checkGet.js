function checkGet() {
	var money = $("#money").val();
	var moneyRex = /^[1-9]\d*$/;
	if (!moneyRex.test(money)) {
		$("#ss").html("<img src='images/tishi.jpg' height='20'>金额只能是正整数");
		return;
	}else{
		$.get("getMoney.do", {"money" : money}, function(data) {
			if("余额不足" == data.trim()) {
				$("#ss").html("<img src='images/tishi.jpg' height='20'>" + data);
			}else {
				$("#ss").html(data);
				alert("取款成功");
				window.location.href="index.jsp";
			}
			
		});
	}
	
}


