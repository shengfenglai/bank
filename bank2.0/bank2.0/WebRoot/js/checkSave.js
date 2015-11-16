var flag1 = false;
function check(){
	if(flag1==false){
		$("#ss").html("<img src='images/tishi.jpg' height='20'>金额必须是正整数且不为空");
	} else {
		$("#saveForm").get(0).submit();
		alert("存款成功");
	}
}
function checkSave() {
	var money = $("#money").val();
	var moneyRex = /^[1-9]\d*$/ ;
	if(!moneyRex.test(money) ){
		$("#ss").html("<img src='images/tishi.jpg' height='20'>金额必须是正整数 ");
		flag1 = false;
	} else{
		flag1 = true;
	}
}