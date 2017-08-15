<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
[
	<c:forEach items="${list }" var="l" varStatus="stat">
		{
		"id": "${l.id }",
		"text": "<a href='<c:if test="${l.isParent }">/position/list.do?root=${l.id }</c:if><c:if test="${!l.isParent }">/ad/list.do?root=${l.id }</c:if>' target='rightFrame'>${l.name }</a>",
		"classes": 
			<c:choose>
				<c:when test="${l.isParent }">"folder"</c:when>
				<c:otherwise>"file"</c:otherwise>
			</c:choose>,
		"hasChildren": 
			<c:choose>
				<c:when test="${l.isParent }">true</c:when>
				<c:otherwise>false</c:otherwise>
			</c:choose>
		}
		<c:if test="${!stat.last }">,</c:if>
	</c:forEach>
]

