<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-position-list</title>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 广告管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="window.location.href='add.jsp?positionId=${positionId}'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/product/list.do" method="post" style="padding-top:5px;">
广告名称: <input type="text" name="name"/>
	<input type="submit" class="query" value="查询"/>
</form>
<form id="jvForm">
<table cellspacing="1" cellpadding="0" width="100%" border="0" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
			<th>ID</th>
			<th>广告位置</th>
			<th>广告名称</th>
			<th>链接</th>
			<th>图片</th>
			<th>宽</th>
			<th>高</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="73" name="ids"></td>
			<td align="center">44</td>
			<td align="center">大广告</td>
			<td align="center">手机</td>
			<td align="center">javascript:;"</td>
			<td align="center"><img width="144" height="45" src="/images/565c189bNf9721325.jpg"> </td>
			<td align="center">670</td>
			<td align="center">399</td>
			<td align="center">
			<a class="pn-opt" href="#">查看</a> | <a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a> | <a class="pn-opt" href="../sku/list.jsp">库存</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="73" name="ids"></td>
			<td align="center">45</td>
			<td align="center">大广告</td>
			<td align="center">电脑</td>
			<td align="center">javascript:;"</td>
			<td align="center"><img width="144" height="45" src="/images/565c0755N3d995d38.jpg"> </td>
			<td align="center">670</td>
			<td align="center">399</td>
			<td align="center">
			<a class="pn-opt" href="#">查看</a> | <a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a> | <a class="pn-opt" href="../sku/list.jsp">库存</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="73" name="ids"></td>
			<td align="center">46</td>
			<td align="center">大广告</td>
			<td align="center">洗衣液</td>
			<td align="center">javascript:;"</td>
			<td align="center"><img width="144" height="45" src="/images/56569f87N3b9ee5a6.jpg"> </td>
			<td align="center">670</td>
			<td align="center">399</td>
			<td align="center">
			<a class="pn-opt" href="#">查看</a> | <a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a> | <a class="pn-opt" href="../sku/list.jsp">库存</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="73" name="ids"></td>
			<td align="center">47</td>
			<td align="center">大广告</td>
			<td align="center">熊猫</td>
			<td align="center">javascript:;"</td>
			<td align="center"><img width="144" height="45" src="/images/5656b3deNcc43202a.jpg"> </td>
			<td align="center">670</td>
			<td align="center">399</td>
			<td align="center">
			<a class="pn-opt" href="#">查看</a> | <a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a> | <a class="pn-opt" href="../sku/list.jsp">库存</a>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td><input type="checkbox" value="73" name="ids"></td>
			<td align="center">48</td>
			<td align="center">大广告</td>
			<td align="center">书籍</td>
			<td align="center">javascript:;"</td>
			<td align="center"><img width="144" height="45" src="/images/5653e38eNed7f4ffc.jpg"> </td>
			<td align="center">670</td>
			<td align="center">399</td>
			<td align="center">
			<a class="pn-opt" href="#">查看</a> | <a class="pn-opt" href="#">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a> | <a class="pn-opt" href="../sku/list.jsp">库存</a>
			</td>
		</tr>
	</tbody>
</table>
<div style="margin-top:15px;"><input class="del-button" type="button" value="删除" onclick="optDelete();"/><input class="add" type="button" value="上架" onclick="isShow();"/><input class="del-button" type="button" value="下架" onclick="isHide();"/></div>
</form>
</div>
</body>
</html>