<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
function addSon(){
	var value = $("#modelId").val();
	if('' != value ){
		location.href = "toAdd.do?root=" + value + "&catText=" + $("#modelId").find("option:selected").text();
	}
}
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 广告位置管理 - 列表</div>
	<form class="ropt">
		<select onchange="addSon()" id="modelId">
			<option>--添加子位置--</option>
			<option value="86">首页</option>
			<option value="87">列表页面</option>
			<option value="88">详细页面</option>
		</select>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<table width="100%" cellspacing="1" cellpadding="0" border="0" style="" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input type="checkbox" onclick=""/></th>
			<th>ID</th>
			<th>分类名称</th>
			<th>排列顺序</th>
			<th>显示</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
		<tr onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'" bgcolor="#ffffff">
			<td><input value="1" name="ids" type="checkbox"></td>
			<td align="center">86</td>
			<td align="center">首页 </td>
			<td align="center"><input style="width:40px; border:1px solid #7e9db9" value="1" name="sort" type="text"></td>
			<td align="center">
				是
				
			</td>
			<td align="center"><a class="pn-opt" href="v_edit.do?id=1">修改</a> | <a onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt" href="o_delete.do?ids=1&amp;root=">删除</a></td>
		</tr>
	
		<tr onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'" bgcolor="#ffffff">
			<td><input value="1" name="ids" type="checkbox"></td>
			<td align="center">87</td>
			<td align="center">列表页面 </td>
			<td align="center"><input style="width:40px; border:1px solid #7e9db9" value="1" name="sort" type="text"></td>
			<td align="center">
				是
				
			</td>
			<td align="center"><a class="pn-opt" href="v_edit.do?id=1">修改</a> | <a onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt" href="o_delete.do?ids=1&amp;root=">删除</a></td>
		</tr>
	
		<tr onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'" bgcolor="#ffffff">
			<td><input value="1" name="ids" type="checkbox"></td>
			<td align="center">88</td>
			<td align="center">详细页面 </td>
			<td align="center"><input style="width:40px; border:1px solid #7e9db9" value="1" name="sort" type="text"></td>
			<td align="center">
				是
				
			</td>
			<td align="center"><a class="pn-opt" href="v_edit.do?id=1">修改</a> | <a onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt" href="o_delete.do?ids=1&amp;root=">删除</a></td>
		</tr>
	</tbody>
</table>
</div>
</body>
</html>