$(document).ready(function () {
	
	$("#table").click(function () {
		if(document.getElementById("showtable").innerHTML!="null")
		{
			alert("请先提交当前订单再添加新餐桌");
		}
		else if($("#tablenum").val() == "")
		{
			alert("请输入餐桌号");
		}
		else
		{
			$.ajax({
		        type: "post",
		        url: "AddFood",
		        data: "action=table&d=" + new Date() + "&tablenumber=" + $("#tablenum").val(),
		        success: function (result) {
		        	//alert(result);
		            if (result == "yes") {
		                alert("添加成功！");
		                window.location.href = "Waiter.jsp";
		            }
		            else
		            {
		            	alert("添加失败！");
		            }
		        }
		    });
		}
	});

	$.ajax({
        type: "post",
        url: "Waiter",
        //data: "action=showitem&d=" + new Date()+"&page="+page1.toString(),
        success: function (result) {
            //alert(result);
            var str = eval("(" + result + ")");
            //alert(str.length);
            for(var i = 0; i < str.length; i++)
        	{
            	/*$("#item_text" + i.toString()).html(str[i-1].foodname);
                $("#price" + i.toString()).html(str[i-1].price);
                $("#img_item" + i.toString()).attr("src", str[i-1].img);
                $("#img_item" + i.toString()).attr("alt", str[i-1].foodid);*/
            	
            	var div = document.createElement("div");
            	div.class = "row-fluid";
            	var li = document.createElement("li");  
            	li.class = "span3";
            	li.innerHTML = "";
            	if(i%4==0)
            	{
            		li.innerHTML += "<div class='row-fluid'>"
            	}
            	li.innerHTML += "<li class='span3' style='float:left;'><div class='thumbnail'>" +
            			"<img id='img_item" + i.toString() + "' src='" + str[i].img + "' alt='" + str[i].foodid + "' width='220' height='170'>" +
            			"<h3 id='item_text" + i.toString() + "'>" + str[i].foodname + "</h3>" +
            			"<span>¥</span><strong id='price" + i.toString() + "'>" + str[i].price + "</strong>" +
            			"<a id='add" + i.toString() + "' href='javascript:' class='btn btn-primary'>添加</a></div></li>" +
            			"";
            	if((i+1)%4==0&&i!=0||i==str.length)
            	{
            		li.innerHTML += "</div><div class='page-header' style='clear:both;'></div>"
            	}
            	div.appendChild(li)
            	document.getElementById("showItem").appendChild(div);
            	$("#add" + i.toString()).click(function () {
            		if(document.getElementById("showtable").innerHTML!="null")
            		{
            			$.ajax({
                	        type: "post",
                	        url: "AddFood",
                	        data: "action=addfood&d=" + new Date() + 
                	        	"&tablenumber=" + document.getElementById("showtable").innerHTML + 
                	        	"&foodid=" + $("#showItem a").index(this),
                	        success: function (result) {
                	        	//alert(result);
                	        	if (result == "yes") {
                	                alert("添加成功！");
                	            }
                	            else
                	            {
                	            	alert("添加失败！");
                	            }
                	        }
                	    });
            		}
            		else
            		{
            			alert("请先添加餐桌");
            		}
            		
            	});
            	
        	}
            
            
        }
    });
	


});