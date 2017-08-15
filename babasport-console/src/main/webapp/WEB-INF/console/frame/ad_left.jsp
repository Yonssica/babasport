<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<script src="/js/jquery.js" type="text/javascript"></script>
<script src="/js/jquery.ext.js" type="text/javascript"></script>
<script src="/js/jquery.form.js" type="text/javascript"></script>
<script src="/js/itcast.js" type="text/javascript"></script>
<script src="/js/admin.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	$("#browser").treeview({
		url : "/position/tree.do"
	});
})
</script>
</head>
<body>
<div class="left">
	<%@ include file="../date.jsp" %>
	<div class="fresh">
		 <table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td height="35" align="center"><img src="/images/admin/refresh-icon.png" />&nbsp;&nbsp;<a href="javascript:location.href=location.href">刷新</a></td>
	      	 </tr>
	     </table>
	</div>
</div>
<ul class="filetree treeview" id="browser">
<li class="collapsable lastCollapsable" id="30"><div class="hitarea hasChildren-hitarea collapsable-hitarea lastCollapsable-hitarea"></div><span class="folder"><a class="" href="/position/list.do?root=30" target="rightFrame">新巴巴商城</a></span><ul style="display: block;"><li class="expandable" id="86"><div class="hitarea hasChildren-hitarea expandable-hitarea"></div><span class="folder"><a class="" href="/position/list.do?root=86" target="rightFrame">首页</a></span><ul style="display: none;"><li id="89"><span class="file"><a href="../ad/list.jsp" target="rightFrame">大广告</a></span></li><li id="90"><span class="file"><a href="/ad/list.do?root=90" target="rightFrame">小广告</a></span></li><li id="91"><span class="file"><a href="/ad/list.do?root=91" target="rightFrame">新巴巴快报</a></span></li><li class="hasChildren expandable lastExpandable" id="96"><div class="hitarea hasChildren-hitarea expandable-hitarea lastExpandable-hitarea "></div><span class="folder"><a class="" href="/position/list.do?root=96" target="rightFrame">中广告</a></span><ul style="display: none;"><li class="last" id="placeholder"><span>placeholder</span></li></ul></li></ul></li><li class="hasChildren expandable" id="87"><div class="hitarea hasChildren-hitarea expandable-hitarea "></div><span class="folder"><a class="" href="/position/list.do?root=87" target="rightFrame">列表页面</a></span><ul style="display: none;"><li class="last" id="placeholder"><span>placeholder</span></li></ul></li><li class="hasChildren expandable lastExpandable" id="88"><div class="hitarea hasChildren-hitarea expandable-hitarea lastExpandable-hitarea "></div><span class="folder"><a class="" href="/position/list.do?root=88" target="rightFrame">详细页面</a></span><ul style="display: none;"><li class="last" id="placeholder"><span>placeholder</span></li></ul></li></ul></li>
</ul>
</div>
</body>
</html>