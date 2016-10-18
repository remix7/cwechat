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
	         <li class="active"><fmt:message key="i18n.menu.Viewaccess"/> </li>
	      </ul>
	   </div>
	</div>
	 <!-- BEGIN ROW -->
        <div class="row">
           <div class="col-lg-12">
              <section class="panel">
                 <header class="panel-heading">
                    <span class="label label-primary"><fmt:message key="i18n.accessList"/> </span>
                 </header>
                 <table class="table table-striped table-advance table-hover">
                    <thead>
                       <tr>
                          <th><i class="fa fa-bullhorn"></i> <fmt:message key="i18n.appid"/> </th>
                          <th class="hidden-phone"><i class="fa fa-question-circle"></i><fmt:message key="i18n.secret"/> </th>
                          <th><i class="fa fa-bookmark"></i> <fmt:message key="i18n.encodingAESKey"/> </th>
                          <th><i class=" fa fa-edit"></i><fmt:message key="i18n.Status"/> </th>
                          <th><fmt:message key="i18n.accessDate"/></th>
                       </tr>
                    </thead>
                    <tbody>
                    	<s:forEach items="${cList}" var="v">
	                    	<tr>
		                          <td><a href="#">${v.appid}</a></td>
		                          <td class="hidden-phone">${v.secret}</td>
		                          <td>${v.encodingAESKey}</td>
		                          <td><span class="label label-info label-mini">${v.isTrue}</span></td>
		                          <td>${v.accessDate} </td>
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

