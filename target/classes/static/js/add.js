function checkForm() {
			//校验账户
			var avalue = document.getElementById("account").value;
			if (avalue == "") {
				//给出错误提示信息
				alert("此项不能为空！");
				return false;
			} 
			//校验公司
			var cvalue = document.getElementById("company").value;
			if (cvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}
			//检验电话
			var mvalue = document.getElementById("mobile").value;
			if (mvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}
			//检验电话
			// document.getElementById("mobile2").value
			// $("#mobile2").val()
			var value = document.getElementById("mobile2").value;
			if (value == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}
			//检验地址
			var dvalue = document.getElementById("address").value;
			if (avalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}
			//检验省份
			var pvalue = document.getElementById("province").value;
			if (pvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验邮编 
			var zvalue = document.getElementById("zip").value;
			if (zvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验电话
			var tvalue = document.getElementById("tel").value;
			if (tvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验传真
			/* var fvalue = document.getElementById("fax").value;
			if (!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(fValue)) {
				alert("邮箱格式不正确!");
				return false;
			} */

			//检验姓名
			var nvalue = document.getElementById("name").value;
			if (nvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验密码
			var pvalue = document.getElementById("password").value;
			if (pvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验问题
			var qvalue = document.getElementById("question").value;
			if (qvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验回答
			var anvalue = document.getElementById("answer").value;
			if (anvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}

			//检验笔记
			var nvalue = document.getElementById("note").value;
			if (nvalue == "") {
				//给出错误提示信息
				alert("此项不能为空！")
				return false;
			}
			
			var data = {
					"Caccount":$("#account").val(),
					"Ccompany":$("#company").val(),
					"Cmobile":$("#mobile").val(),
					"Cmobile1111":$("#mobile2").val(),
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
				url:"users/addUser",
				data:data,
				cache:true,
				async:true,
				success:function(data){
					if(data.code == 0){
						alert("插入成功");
						location.href = "Page.html";
					}
					
				},
				error:function(){
					console.log(e);
				}
				
			});
			
		}