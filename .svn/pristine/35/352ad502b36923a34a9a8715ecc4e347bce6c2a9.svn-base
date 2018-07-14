<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
   <link rel="stylesheet" type="text/css" href="/WirelessOrder/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/WirelessOrder/css/theme.css">
    <link rel="stylesheet" href="/WirelessOrder/font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="/WirelessOrder/bootstrap/css/bootstrapValidator.css">

	<script src="/WirelessOrder/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="/WirelessOrder/bootstrap/js/bootstrap.js"></script>
   <script type="text/javascript" src="/WirelessOrder/bootstrap/js/bootstrapValidator.js"></script>
    
	<style type="text/css">
  

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color:  #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
      #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }

    </style>
	

  </head>
  
  <body class="">
   <script type="text/javascript">
$(document).ready(function() {
    /**
     * 下面是进行插件初始化
     * 你只需传入相应的键值对
     * */
    $('#defaultForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {/*输入框不同状态，显示图片的样式*/
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {/*验证*/
                uname: {/*键名username和input name值对应*/
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {/*非空提示*/
                            message: '用户名不能为空'
                        },
                        stringLength: {/*长度提示*/
                            min: 4,
                            max: 30,
                            message: '用户名长度必须在4到30之间'
                        }/*最后一个没有逗号*/
                    }
                },
                password: {
                    message:'密码无效',
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 3,
                            max: 16,
                            message: '用户名长度必须在3到16之间'
                        }
                    }
                },
              
                }
            }
        );
});
</script>
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                </ul>
                <a class="brand" href="index.html"><span class="first">无线点餐</span> <span class="second">系统</span></a>
        </div>
    </div>
    <div class="container" style="margin-top:100px" ">
      <form id="defaultForm" class="form-signin" action="login" method="post">
         <div class="page-header" >
          <h2>无线点餐系统</h2>
        </div>
        <div class="form-group">
        <input type="text" class="input-block-level" placeholder="用户名"  name="uname">
        </div>
        <div class="form-group">
        <input type="password" class="input-block-level" placeholder="密码"  name="password">
        </div>
        <button class="btn  btn-primary" type="submit">登陆</button>
        <button class="btn" type="reset">重置</button>
      </form>
      <footer>
      		<hr>
      		<p class="pull-right">&copy; 2017.6 <a href="javascript:" target="_blank">点餐系统</a></p>
      </footer>

    </div> 
     
  
  </body>
</html>
