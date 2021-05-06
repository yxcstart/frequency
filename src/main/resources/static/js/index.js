$(function(){
	$("#publishBtn").click(publish);
});

function publish() {
	$("#publishModal").modal("hide");

	// 获取参数
	var width=$("#width").val();
	var height=$("#height").val();
	var thick=$("#thick").val();
	var elasticModulus=$("#elasticModulus").val();
	var poissonRatio=$("#poissonRatio").val();
	var upper=$("#upper").val();
	var lower=$("#lower").val();
	// 发送异步请求
	$.post(
		CONTEXT_PATH+"/add",
		{"width":width,"height":height,"thick":thick,"elasticModulus":elasticModulus,
			"poissonRatio":poissonRatio,"upper":upper,"lower":lower},
		function (data) {
			data=$.parseJSON(data);
			// 在提示框中显示返回的消息
			$("#hintBody").text(data.msg);
			// 显示提示框
			$("#hintModal").modal("show");
			// 2秒后，自动隐藏提示框
			setTimeout(function(){
				$("#hintModal").modal("hide");
				// 刷新页面
				if (data.code==0){
					window.location.reload();
				}
			}, 2000);
		}
	);
}