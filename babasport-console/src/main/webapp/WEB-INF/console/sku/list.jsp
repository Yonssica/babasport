<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>babasport-list</title>
    <script>
        // 使数据变为可修改状态
        function showUpdateSku(skuId) {
            $("#m" + skuId).attr("disabled", false);
            $("#p" + skuId).attr("disabled", false);
            $("#s" + skuId).attr("disabled", false);
            $("#u" + skuId).attr("disabled", false);
            $("#d" + skuId).attr("disabled", false);
        };

        // 动态保存数据
        function doUpdateSku(skuId) {
            // 使数据变为不可修改状态
            $("#m" + skuId).attr("disabled", true);
            $("#p" + skuId).attr("disabled", true);
            $("#s" + skuId).attr("disabled", true);
            $("#u" + skuId).attr("disabled", true);
            $("#d" + skuId).attr("disabled", true);
            // 需要传送到服务器的数据
            var param = {
                "marketPrice": $("#m" + skuId).val(),
                "price": $("#p" + skuId).val(),
                "stock": $("#s" + skuId).val(),
                "upperLimit": $("#u" + skuId).val(),
                "deliveFee": $("#d" + skuId).val(),
                "id": skuId
            }
            // 异步调用Controller,保存编辑
            $.post("update.do", param, function (data) {

            })
        }
    </script>
</head>
<body>
<div class="box-positon">
    <div class="rpos">当前位置: 库存管理 - 列表</div>
    <div class="clear"></div>
</div>
<div class="body-box">
    <form method="post" id="tableForm">
        <table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
            <thead class="pn-lthead">
            <tr>
                <th width="20"><input type="checkbox" onclick="Pn.checkbox('ids',this.checked)"/></th>
                <th>商品编号</th>
                <th>商品颜色</th>
                <th>商品尺码</th>
                <th>市场价格</th>
                <th>销售价格</th>
                <th>库 存</th>
                <th>购买限制</th>
                <th>运 费</th>
                <th>是否赠品</th>
                <th>操 作</th>
            </tr>
            </thead>
            <tbody class="pn-ltbody">
            <c:forEach items="${skus}" var="sku">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td><input type="checkbox" name="ids" value="${sku.id}"/></td>
                    <td align="center">${sku.productId}</td>
                    <td align="center">${sku.color.name}</td>
                    <td align="center">${sku.size}</td>
                    <td align="center">
                        <input type="text" id="m${sku.id}" value="${sku.marketPrice}" disabled="disabled" size="10"/>
                    </td>
                    <td align="center">
                        <input type="text" id="p${sku.id}" value="${sku.price}" disabled="disabled" size="10"/></td>
                    <td align="center">
                        <input type="text" id="s${sku.id}" value="${sku.stock}" disabled="disabled" size="10"/></td>
                    <td align="center">
                        <input type="text" id="u${sku.id}" value="${sku.upperLimit}" disabled="disabled" size="10"/>
                    </td>
                    <td align="center">
                        <input type="text" id="d${sku.id}" value="${sku.deliveFee}" disabled="disabled" size="10"/></td>
                    <td align="center">不是</td>
                    <td align="center"><a href="javascript:showUpdateSku(${sku.id})" class="pn-opt">修改</a> | <a
                            href="javascript:doUpdateSku(${sku.id})" class="pn-opt">保存</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>