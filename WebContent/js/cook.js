function changea(x)
{
	var i=$("#data a").index(x);
	var a=document.getElementById("changea"+i.toString());
	a.innerHTML="正在烹饪中";
	$.ajax({ 
        type: "post",
        url: "changefoodstatus",
        data: "tableid="+document.getElementById("tableid"+i.toString()).innerHTML +  "&action=click1"+"&foodname="+document.getElementById("foodname"+i.toString()).innerHTML,
        success: function (result) {
        	//alert(result);
        }
    });
}
function changeb(x)
{
	var i=$("#data a").index(x);
	var a=document.getElementById("changea"+i.toString());
	//a.innerHTML="烹饪完成";
	$.ajax({ 
        type: "post",
        url: "changefoodstatus",
        data: "tableid="+document.getElementById("tableid"+i.toString()).innerHTML +  "&action=click2"+"&foodname="+document.getElementById("foodname"+i.toString()).innerHTML,
        success: function (result) {
        	//alert(result);
        }
    });
}
$(document).ready(function(){
	$.ajax({  
        type : "post",  
        url : "autorequest",  
        dataType : "text",  
        success : function(data) {  
            data = eval(data);  
            //构造前先清空源节点  
            var dt= document.getElementById("data");
            document.getElementById("data").innerHTML = "";  
            //设置一个文件碎片  
            //这是表头  
            var tr = document.createElement("tr");  
            tr.innerHTML = "<td>桌号</td><td>菜名</td><td>数量</td><td>状态</td>";  
            dt.appendChild(tr);  
            //利用循环构造表格的每一行，把其放在文件碎片上面  
            for (var i = 0; i < data.length; i++) {  
                tr = document.createElement("tr");  
                if(data[i].foodstatus=="未烹饪")
                {
                	tr.innerHTML = "<td id='tableid"+ i.toString() +"'>" + data[i].tableid + "</td>" + "<td id='foodname"+i.toString()+"'>"  
                    + data[i].foodname + "</td>" + "<td>" + data[i].foodcount  
                    + "</td>"+ "<td>" + data[i].foodstatus
                    + "</td>"+"<td>"+"<a  class='btn btn-info' href='#'  id='changea"+ i.toString() +"'><i class='icon-edit icon-white'></i>开始烹饪</a>"+"</td>";  
                }
                else
                {
                	tr.innerHTML = "<td id='tableid"+ i.toString() +"'>" + data[i].tableid + "</td>" + "<td id='foodname"+i.toString()+"'>"  
                    + data[i].foodname + "</td>" + "<td>" + data[i].foodcount  
                    + "</td>"+ "<td>" + data[i].foodstatus
                    + "</td>"+"<td>"+"<a  class='btn btn-info' href='#'  id='changea"+ i.toString() +"'><i class='icon-edit icon-white'></i>正在烹饪中</a>"+"</td>";
                }
                
                dt.appendChild(tr);  
                $("#changea"+i.toString()).click(function(){
                	if(this.innerText=="正在烹饪中")
             		{
             			changeb(this);
             			
             		}	
                	else if(this.innerText=="开始烹饪")
            		{
            			changea(this);
            			 
            		}
                	window.location.href = "cook.jsp";
                			
                	
                });
            }  
            //此时文件碎片已经是一张表了，直接放网页就可以了  
        },  
        error : function() {  
            alert("出错了");  
        }
    });
});
 