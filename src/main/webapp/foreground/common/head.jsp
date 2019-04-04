<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row-fluid">
	<div class="span12">
		<img src="${pageContext.request.contextPath}/images/logo2.jpg">
	</div>
</div>
<div class="row-fluid">
	<div class="span12">
		<div class="navbar">
		  <div class="navbar-inner">
		    <a class="brand" href="index.action">首页</a>
		    <ul class="nav">
		       <c:forEach var="newsType" items="${newsTypeList}">
		       		<li><a href="newsList.action?typeId=${newsType.newstypeid }">${newsType.typename }</a></li>
		       </c:forEach>
		    </ul>
		  </div>
		</div>
	</div>
</div>