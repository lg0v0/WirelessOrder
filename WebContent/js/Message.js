$(function(){
	$.ajax({  
        type : "post",  
        url : "ShowFoodStatus",
        success : function(data) {
            data = eval("(" + data + ")");
            //构造前先清空源节点  
            document.getElementById("body").innerHTML = "";  
            //设置一个文件碎片  
            var frag = document.createDocumentFragment();
            //利用循环构造表格的每一行，把其放在文件碎片上面  
            for (var i = 0; i < data.length; i++) {  
                tr = document.createElement("tr");  
                tr.innerHTML = "<td>" + data[i].tablenum + "</td>" 
                			+ "<td>" + data[i].foodname+ "</td>" 
                			+ "<td>" + data[i].foodcount + "</td>" 
                			+ "<td>" + data[i].foodstatus + "</td>";  
                frag.appendChild(tr);  
            }  
            //此时文件碎片已经是一张表了，直接放网页就可以了  
            document.getElementById("body").appendChild(frag);  
        },  
        error : function() {  
            alert("出错了");  
        }
	});
});