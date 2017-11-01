<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html >
	<head>
		<meta http-equiv="Content-Type" content="text/javascript; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>内容列表页面</title>
		<link href="<%=basePath %>resources/css/all.css" rel="stylesheet" type="text/css" />
	</head>
	<body style="background: #e1e9eb;">
		<form action="" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容列表</div>
				<div class="rightCont">
					<p class="g_title fix">内容列表 <a class="btn03" href="#">新 增</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03" href="#">删 除</a></p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">演示字段1：</td>
								<td>
									<input type="text" class="allInput" value=""/>
								</td>
								<td width="90" align="right">演示字段2：</td>
								<td>
									<input type="text" class="allInput" value=""/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="查 询" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="#"/></th>
								    <th>序号</th>
								    <th>演示字段1</th>
								    <th>演示字段2</th>
								    <th>操作</th>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>1</td>
									<td>演示值1</td>
									<td>演示值2</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
								<tr style="background-color:#ECF6EE;">
									<td><input type="checkbox" /></td>
									<td>2</td>
									<td>演示值1</td>
									<td>演示值2</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
								<tr>
									<td><input type="checkbox" /></td>
									<td>3</td>
									<td>演示值1</td>
									<td>演示值2</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
								<tr style="background-color:#ECF6EE;">
									<td><input type="checkbox" /></td>
									<td>4</td>
									<td>演示值1</td>
									<td>演示值2</td>
									<td>
										<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
										<a href="#">删除</a>
									</td>
								</tr>
							</tbody>
						</table>
						<div class='page fix'>
							共 <b>4</b> 条
							<a href='###' class='first'>首页</a>
							<a href='###' class='pre'>上一页</a>
							当前第<span>1/1</span>页
							<a href='###' class='next'>下一页</a>
							<a href='###' class='last'>末页</a>
							跳至&nbsp;<input type='text' value='1' class='allInput w28' />&nbsp;页&nbsp;
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	    
	    <form id="formid"  name= "myform" method = 'post'  action = 'List.action' onsubmit = "return checkUser();" >
            <table width="100%" border="0">
              <tr>
                <td width="60" height="40" align="right">用户名&nbsp;</td>
                <td><input type="text" value="" class="text2" name = "username" id = "userid"/></td>
              </tr>
              <tr>
                <td width="60" height="40" align="right">密&nbsp;&nbsp;码&nbsp;</td>
                <td><input type="password" value="" class="text2" name = "userpass" id = "userpassid"/></td>
              </tr>
              <tr>
                <td width="60" height="40" align="right">&nbsp;</td>
                <td><div class="c4">
                    <input type="submit" value="submit" class="btn2"  />
                    </div>
                    </td>
                    </tr>
                    </table>
         </form>
	</body>
	
	<script language="javascript">
		function checkUser(){
			alert("hello!");
			return true;
		}
	</script>
</html>