var flag;
function find(data){
	var a = {
			"id":data
	}
	
	$.ajax({
		type:"post",
		url:"users/Page",
		data:a,
		async:false,
		success:function(data){
			if(data.code == 0){
				showData(data.results);
				flag = data.count;
				$(".gengxin").click(upt); 
				$(".shanchu").click(del);
			}else{
				console.log("分页失败");
			}
		},
		error:function(){
			console.log("分页失败");
		}
	});
	function showData(data){
		var table = $("#table1");
		table.empty();
		table.append("<tr><th>账 户</th><th>公 司</th><th>电 话</th><th>电 话</th>"+
					"<th>地 址</th><th>省 份</th><th>邮 编</th><th>电 话</th>"+
					"<th>传 真</th><th>姓 名</th><th>密 码</th><th>问 题</th><th>回 答</th><th>笔 记</th>"+
					"<th>创建时间</th><th>更 新</th><th>删 除</th></tr>");
		for(var i = 0; i <data.length;i++){
			str = `<tr>
					<td>${data[i].caccount}</td><td>${data[i].ccompany}</td>
					<td>${data[i].cmobile}</td><td>${data[i].cmobile1111}</td>
					<td>${data[i].caddress}</td><td>${data[i].cprovince}</td>
					<td>${data[i].czip}</td><td>${data[i].ctel}</td>
					<td>${data[i].cfax}</td><td>${data[i].cname}</td>
					<td>${data[i].cpassword}</td><td>${data[i].cquestion}</td>
					<td>${data[i].canswer}</td><td>${data[i].cnote}</td><td>${data[i].createtime}</td>
					<td><input type="button" value="更新" class = "gengxin" code="${data[i].cid}"/></td>
					<td><input type="button" value="删除" class = "shanchu" code="${data[i].cid}"/></td>
					</tr>`;
		table.append(str);
		}
		
	}
}
$(function(){
/* 		var timer = setTimeout(function(){
			$("#current1").text(flag);
		},100);
		if(flag != undefined){
			clearInterval(timer);
		}  */
	$("#pagination1").pagination({
		currentPage: 1,
		totalPage: flag,
		callback: function(current) {
			$("#current1").text(current);
			find(current);
		}
	});
});
find();

function del(){
	var Cid =  $(this).attr("code");
	console.log(Cid);
	var Cid2 = {
			"id":Cid
	}
	$.ajax({
		type:"post",
		url: "users/deleteUser",
		data: Cid2,
		async:true,
		success:function(data){
			if(data.code == 0){
				alert("删除成功");
				window.location.reload();
			}else{
				alert("删除失败");
			}
		},
		error:function(){
			alert("操作失败");
		}
		
	});
	
}

function upt(){
	$("#update").css("display","block");
	var Cid = $(this).attr("code");
	console.log(Cid);
	var Cid2 = {
		"id":Cid,
	}
	
	$.ajax({
		type:"post",
		url:"users/editUser",
		data:Cid2,
		async:true,
		success:function(data){
			if(data.results == null){
				alert("找不到");
			}else{
				if(data.code == 0){
					showData(data.results);
				}else{
					alert("未能获取商品信息！");
				}
			}
		},
		error:function(){
			console.log("出错了");
		}
		
	});
	
	function showData(data){
		$("#CID").val(data.cid);
		$("#account").val(data.caccount);
		$("#company").val(data.ccompany);
		$("#mobile").val(data.cmobile);
		$("#mobile1111").val(data.cmobile1111);
		$("#address").val(data.caddress);
		$("#province").val(data.cprovince);
		$("#zip").val(data.czip);
		$("#tel").val(data.ctel);
		$("#fax").val(data.cfax);
		$("#name").val(data.cname);
		$("#password").val(data.cpassword);
		$("#question").val(data.cquestion);
		$("#answer").val(data.canswer);
		$("#note").val(data.cnote);
	}
}

function update(){
	var data = {
			"CID":$("#CID").val(),
			"Caccount":$("#account").val(),
			"Ccompany":$("#company").val(),
			"Cmobile":$("#mobile").val(),
			"Cmobile1111":$("#mobile1111").val(),
			"Caddress":$("#address").val(),
			"Cprovince":$("#province").val(),
			"Czip":$("#zip").val(),
			"Ctel":$("#tel").val(),
			"Cfax":$("#fax").val(),
			"Cname":$("#name").val(),
			"Cpassword":$("#password").val(),
			"Cquestion":$("#question").val(),
			"Canswer":$("#answer").val(),
			"Cnote":$("#note").val()
	}
	$.ajax({
		type:"post",
		url:"users/update",
		data: data,
		cache:true,
		async:true,
		success:function(data){
			if(data.code == 0){
				alert("更新成功");
				window.location.reload();
			}
		},
		error:function(){
			consolr.log("更新失败");
		}
		
	});
}

function checkForm(){
	var content = $("#page1").val();
	var data = {
			"account":content,
	}
	$.ajax({
		type:"post",
		url:"users/search",
		data:data,
		async:true,
		success:function(data){
				showdata(data.results);
				$(".gengxin").click(upt); 
				$(".shanchu").click(del);
		},
		error:function(){
			console.log("出错了");
		}
	});
}
	function showdata(data){
		var table = $("#table2");
		table.empty();
		table.append("<tr><th>账 户</th><th>公 司</th><th>电 话</th><th>电 话</th>"+
				"<th>地 址</th><th>省 份</th><th>邮 编</th><th>电 话</th>"+
				"<th>传 真</th><th>姓 名</th><th>密 码</th><th>问 题</th><th>回 答</th><th>笔 记</th>"+
				"<th>创建时间</th><th>更 新</th><th>删 除</th></tr>");
		for(var i = 0; i < data.length;i++){
			str = `<tr>
					<td>${data[i].caccount}</td><td>${data[i].ccompany}</td>
					<td>${data[i].cmobile}</td><td>${data[i].cmobile1111}</td>
					<td>${data[i].caddress}</td><td>${data[i].cprovince}</td>
					<td>${data[i].czip}</td><td>${data[i].ctel}</td>
					<td>${data[i].cfax}</td><td>${data[i].cname}</td>
					<td>${data[i].cpassword}</td><td>${data[i].cquestion}</td>
					<td>${data[i].canswer}</td><td>${data[i].cnote}</td><td>${data[i].createtime}</td>
					<td><input type="button" value="更新" class = "gengxin" code="${data[i].cid}"/></td>
					<td><input type="button" value="删除" class = "shanchu" code="${data[i].cid}"/></td>
				</tr>`;
		table.append(str);
		}
	}
	
	function checkForm2(){
		var content = $("#datetime").val();
		var data = {
				"time":content,
		}
		$.ajax({
			type:"post",
			url:"users/datetime",
			data:data,
			async:true,
			success:function(data){
				if(data.code == 0){
				showdata(data.results);
				$(".gengxin").click(upt); 
				$(".shanchu").click(del);
				}else{
					console.log("出错了");
				}
			},
			error:function(){
				console.log("有问题");
			}
		});
	}
