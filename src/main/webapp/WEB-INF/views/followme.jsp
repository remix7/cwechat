<%@ include file="/WEB-INF/views/public/header.jspf"%>
<%@ include file="/WEB-INF/views/public/menus.jspf"%>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="main-content">
<section class="wrapper">
	<div class="row">
	   <div class="col-lg-12">
	      <ul class="breadcrumb">
	         <li><a href="${pageContext.request.contextPath}/"><i class="fa fa-home"></i> <fmt:message key="i18n.Home"/> </a></li>
	         <li>»</li>
	         <li><fmt:message key="i18n.menu.Accessinformation"/></li>
	        <li> »</li>
	         <li class="active"><fmt:message key="i18n.menu.usermanagerment"/> </li>
	      </ul>
	   </div>
	</div>
	 <!-- BEGIN ROW -->
        <div class="row">
           <div class="col-lg-12">
              <section class="panel">
                 <header class="panel-heading">
                    <span class="label label-primary"><fmt:message key="i18n.menu.usermanagerment"/> </span>
                 </header>
                 <table class="table table-striped table-advance table-hover">
                    <thead>
                       <tr>
                       	  <th><fmt:message key="i18n.message.details"/> </th>
                          <th>openID</th>
                          <th><fmt:message key="i18n.message.createTime"/></th>
                          <th>AccessID</th>
                          <th>.....</th>
                       </tr>
                    </thead>
                    <tbody>
                    	<s:forEach items="${cList}" var="v">
	                    	<tr>
	                    		  <td><a href="${pageContext.request.contextPath}/followme/${v.openId}"><fmt:message key="i18n.message.details"/></a> </td>
		                          <td>${v.openId}</td>
		                          <td>${v.createDate}</td>
		                          <td>${v.accessId}</td>
		                          <td>....</td>
		                    </tr>
                    	</s:forEach>
                    </tbody>
                 </table>
              </section>
           </div>
        </div>
<!-- END ROW -->
</section>
</section>