checkForm()
function checkForm(){
		var time = $("#province").val();
		var data = {
				"type":time,
		}
		$.ajax({
			type:"post",
			url:"users/groupbysend",
			async:true,
			cache:true,
			data:data,
			success:function(data){
				if(data.code == 0){
					console.log(data.list);
					console.log(data.others);
					console.log(data.array1);
					console.log(data.array2);
					a(data.list);
					b(data.list2);
					c(data.others,data.list3);
					d(data.array1,data.array2); 
				}else{
					console.log("fail");
				}
			},
			error:function(){
				console.log("出错了");
			}
		});
		/* 统计图一 */
	function a(list){
		var dom = document.getElementById("container");
		var myChart = echarts.init(dom);
		var app = {};
	   	var ID = new Array();
		var COMPANY = new Array();
         $.each(list,function(key,value){
            ID[key] = this.id;      //如果是其他标签 用 html();
			COMPANY[key] = this.company;
         });
		option = null;
		option = {
			title : {
	            text: '发送总数top10',
	            x:'center',
	            y:'15'
	        },
	       
			xAxis: {
				type: 'category',
				data: COMPANY,
				 axisLabel: {
		                margin: 10,
		                color: 'black',
		                textStyle: {
		                    fontSize: 8.5
		                },
		            },
	        
			},
			yAxis: {
				type: 'value'
			},
			series: [{
				data: ID,
				type: 'bar'
			}]
		};
		;
		if (option && typeof option === "object") {
			myChart.setOption(option, true);
		}
	}
		
		/* 统计图二*/
	function b(list){
		var dom2 = document.getElementById("container2");
		var myChart = echarts.init(dom2);
		var app = {};
	   	var ID = new Array();
		var COMPANY = new Array();
        $.each(list,function(key,value){
            ID[key] = this.id;      //如果是其他标签 用 html();
			COMPANY[key] = this.company;
        });
		option = null;
		option = {
			      title: {
			        text: '发送失败TOP10',
			        left: 'center',
			        y:'15'
			       
			    },  
			    tooltip: {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'shadow'
			        }
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '8%',
			        containLabel: true
			    },
			    xAxis: [{
			        type: 'category',
			        
			        axisTick: {
			            show: false,
			            color: '#707070'
			        },
			        axisLabel: {
			            textStyle: {
			                fontSize: 8.5,
			                color: '#4D4D4D'
			            }
			        },
			        axisLine: {
			            lineStyle: {
			                color: '#707070'
			            }
			        },
			        	data: COMPANY,
			    }],
			    yAxis: {
			        type: 'value',
			        nameTextStyle: {
			            fontSize: 14,
			            color: '#4D4D4D'
			        },
			        axisLabel: {
			            textStyle: {
			                fontSize: 12,
			                color: '#4D4D4D'
			            }
			        },
			        axisLine: {
			            lineStyle: {
			                color: '#707070'
			            }
			        }
			    },
			    series: [{
			        name: '直接访问',
			        type: 'bar',
			        barWidth: '60%',
			        data: [ {
			                name:  COMPANY[0],
			                value: ID[0],
			                itemStyle: {
			                    color: '#1F78B4'
			                }
			            },
			            {
			                name: COMPANY[1],
			                value: ID[1],
			                itemStyle: {
			                    color: '#A6CEE3'
			                }
			            },
			            {
			                name: COMPANY[2],
			                value: ID[2],
			                itemStyle: {
			                    color: '#B2DF8A'
			                }
			            },
			            {
			                name: COMPANY[3],
			                value: ID[3],
			                itemStyle: {
			                    color: '#33A02C'
			                }
			            },
			            {
			                name: COMPANY[4],
			                value: ID[4],
			                itemStyle: {
			                    color: '#FB9A99'
			                }
			            },
			            {
			                name: COMPANY[5],
			                value: ID[5],
			                itemStyle: {
			                    color: '#E31A1C'
			                }
			            },
			            {
			                name: COMPANY[6],
			                value: ID[6],
			                itemStyle: {
			                    color: '#33A02C'
			                }
			            },
			            {
			                name: COMPANY[7],
			                value: ID[7],
			                itemStyle: {
			                    color: '#FB9A99'
			                }
			            },
			            {
			                name: COMPANY[8],
			                value: ID[8],
			                itemStyle: {
			                    color: '#E31A1C'
			                }
			            },
			            {
			                name: COMPANY[9],
			                value: ID[9],
			                itemStyle: {
			                    color: '#E31A1C'
			                }
			            } 
			        ]
			    }]
			};
		if (option && typeof option === "object") {
			myChart.setOption(option, true);
		}
	}
		
	function c(other,list){
		 var dom3 = document.getElementById("container3");
		    var myChart = echarts.init(dom3);
		    var app = {};
				var DATA = new Array();
		         $.each(list,function(key,value){
		            DATA[key] = {value:this.id,name:this.company};
		         });
				DATA.push({value:other,name:'其他'});
			    option = null;
			    option = {
			        title : {
			            text: '发送总数前二十TOP及其他',
			            x:'center',
			            y:'15'
			        },
		       
		        series : [
		            {
		                name: '部门使用情况',
		                type: 'pie',
		                radius : '55%',
		                center: ['50%', '60%'],
		                label:{
		                    show:true,
		                    formatter:'{b}: {d}%'
		                },
		                data:DATA,
		                itemStyle: {
		                    emphasis: {
		                        shadowBlur: 10,
		                        shadowOffsetX: 0,
		                        shadowColor: 'rgba(0, 0, 0, 0.5)'
		                    }
		                }
		            }
		        ]
		    };

		    if (option && typeof option === "object") {
		        myChart.setOption(option, true);
		    }
		}
	function d(array1,array2){
		var dom4 = document.getElementById("container4");
	    var myChart = echarts.init(dom4);
	    var app = {};
	   	var count = new Array();
	   	count[0] = array1[0];
	   	count[1] = array1[1];
	   	count[2] = array1[2];
	   	count[3] = array1[3];
	   	count[4] = array1[4];
	   	count[5] = array1[5];
	   	count[6] = array1[6];
	   	count[7] = array1[7];
	   	count[8] = array2[0];
	   	count[9] = array2[1];
	   	count[10] = array2[2];
	   	count[11] = array2[3];
	   	count[12] = array2[4];
	   	count[13] = array2[5];
	   	count[14] = array2[6];
	   	count[15] = array2[7];
	   	
	    option = null;
	    var charts = {
	        names: ['发送成功', '发送失败'],
	        lineX: ['最近 三小时', '最近 六小时', '最近 九小时', '最近 十二小时', '最近 十五小时', '最近 十八小时', '最近 二十一小时', '最近 一天'], 
	        value: [
	            [count[0],count[1],count[2],count[3],count[4],count[5],count[6],count[7]],
	            [count[8],count[9],count[10],count[11],count[12],count[13],count[14],count[15]]
	        ]

	    }
	    var color = ['rgba(255,100,97', 'rgba(23, 22, 243']
	    var lineY = []

	    for (var i = 0; i < charts.names.length; i++) {
	        var x = i
	        if (x > color.length - 1) {
	            x = color.length - 1
	        }
	        var data = {
	            name: charts.names[i],
	            type: 'line',
	            color: color[x] + ')',
	            smooth: true,
	            areaStyle: {
	                normal: {
	                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
	                        offset: 0,
	                        color: color[x] + ', 0.3)'
	                    }, {
	                        offset: 0.8,
	                        color: color[x] + ', 0)'
	                    }], false),
	                    shadowColor: 'rgba(1, 0, 0, 0.1)',
	                    shadowBlur: 10
	                }
	            },
	            symbol: 'circle',
	            symbolSize: 10,
	            data: charts.value[i]
	        }
	        lineY.push(data)
	    }

	    lineY[0].markLine = {
	        silent: true,
	        data: [{
	            yAxis: 100
	        }, {
	            yAxis: 200
	        }, {
	            yAxis: 300
	        }, {
	            yAxis: 400
	        }]
	    }
	    var option = {
	       /*  backgroundColor:'#1b2735', */
	       title: {
			        text: '最近一天失败成功对比图',
			        left: 'center',
			        y:'15'
			       
			    },
	        tooltip: {
	            trigger: 'axis'
	        },
	        legend: {
	            data: charts.names,
	            textStyle: {
	                fontSize: 12,
	                color: 'black'
	            },
	            right: '%'
	        },
	        grid: {
	            top: '14%',
	            left: '4%',
	            right: '4%',
	            bottom: '12%',
	            containLabel: true
	        },
	        xAxis: {
	            type: 'category',
	            boundaryGap: false,
	            data: charts.lineX,
	            axisLabel: {
	                textStyle: {
	                    color: 'black',
	                    fontSize: 12
	                },
	                formatter: function(params) {
	                    return params.split(' ')[0] + '\n' + params.split(' ')[1]
	                }
	            }
	  
	        },
	        yAxis: {
	            name: charts.unit,
	            type: 'value',
	            axisLabel: {
	                formatter: '{value}',
	                textStyle: {
	                    color: 'black'
	                }
	            },
	            splitLine: {
	                lineStyle: {
	                    color: 'rgb(23,255,243,0.3)'
	                }
	            },
	            axisLine: {
	                lineStyle: {
	                    color: 'black'
	                }
	            }
	        },
	        series: lineY
	    }
	    setInterval(() => {
	        myChart.setOption({
	            legend: {
	                selected: {
	                    '发送成功': false,
	                    '发送失败': false
	                }
	            }
	        })
	        myChart.setOption({
	            legend: {
	                selected: {
	                    '发送成功': true,
	                    '发送失败': true
	                }
	            }
	        })
	    },10000)
	    if (option && typeof option === "object") {
	        myChart.setOption(option, true);
	    }
	}
}