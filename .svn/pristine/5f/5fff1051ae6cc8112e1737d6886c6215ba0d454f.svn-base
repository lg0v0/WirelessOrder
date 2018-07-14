$(document).ready(function(){
	$.ajax({  
        type : "post",  
        url : "Order", 
        data : "action=showOrder",
        success : function(data) {  
        	//alert(data);
            data = eval(data); 
            var dt = document.getElementById("order");
            var tr = document.createElement("tr");  
            tr.innerHTML = "<td>订单号</td><td>餐桌号</td><td>下单时间</td><td>总金额</td><td>状态</td><td>操作</td>";  
            dt.appendChild(tr);  
            //利用循环构造表格的每一行，把其放在文件碎片上面  
            for (var i = 0; i < data.length; i++) {  
                tr = document.createElement("tr");  
                tr.innerHTML = "<td id='order" + i.toString() + "'>" + data[i].ordernum + "</td>" + 
                	"<td>"+ data[i].tableid + "</td>" + 
                	"<td>" + data[i].orderdate + "</td>" + 
                	"<td>" + data[i].totalprice + "</td>" + 
                	"<td>" + data[i].orderstatus + "</td>" + 
                	"<td><a class='btn btn-info' href='javascript:' id='change"+ i.toString() +"'><i class='icon-edit icon-white'></i>结账</a></td>" +
                	"<td><button class='btn btn-default' id='showOrderDetail"+ i.toString() +"'><i class='icon-edit icon-white'></i>订单详情</button></td>"; 
                dt.appendChild(tr);
                $("#change"+i.toString()).click(function(){
                	$.ajax({ 
                        type: "post",
                        url: "Order",
                        data: "action=changeOrderStatus&" + "orderid=" + document.getElementById("order"+$("#order a").index(this)).innerHTML,
                        success: function (result) {
                        	//alert(result);
                        	if (result == "yes") {
            	                alert("结账成功！");
            	                window.location.href = "order.jsp";
            	            }
            	            else if(result == "已结账")
            	            {
            	            	alert("已结账！");
            	            }
                        }
                    });
                });
                
                $("#showOrderDetail"+i.toString()).click(function(){
                	var orderid = document.getElementById("order"+$("#order button").index(this)).innerHTML;
                	window.location.href = "Orderdetail.jsp?orderid=" + orderid;
                	/*$.ajax({ 
                        type: "post",
                        url: "Order",
                        data: "action=showOrderDetail&" + "orderid=" + document.getElementById("order"+$("#order button").index(this)).innerHTML,
                        success: function (result) {
                        	//alert(result);
                        }
                    });*/
                });
                
            }  
            //此时文件碎片已经是一张表了，直接放网页就可以了  
        },  
        error : function() {  
            alert("出错了");  
        }  
  
    });  

	
	
});
 