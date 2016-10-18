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
	         <li class="active"><fmt:message key="i18n.menu.message"/> </li>
	      </ul>
	   </div>
	</div>
		<section class="panel">
                <div class="panel-body bio-graph-info">
                  <h1>
                   	<fmt:message key="i18n.info.Message.details"/>
                  </h1>
                  <s:if test="${recMessage.msgType=='text'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.context"/>
                        </span>
                        : ${recMessage.context}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${recMessage.msgType=='image'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.picUrl"/>
                        </span>
                        : <img alt="" src="${pageContext.request.contextPath}/download/${recMessage.mediaId}" width="130px" height="200">
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.MediaId"/> 
                        </span>
                        : <a href="${pageContext.request.contextPath}/download/${recMessage.mediaId}" target="_blank"><fmt:message key="i18n.message.Clicktoview"/></a> 
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${recMessage.msgType=='voice'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.recognition"/>
                        </span>
                        : ${recMessage.recognition}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MediaId"/>
                        </span>
                        : <a href="${pageContext.request.contextPath}/download/${recMessage.mediaId}" target="_blank"><fmt:message key="i18n.message.Clicktoview"/></a> 
                      </p>
                    </div>
                  </div>
                  </s:if>
                   <s:if test="${recMessage.msgType=='video'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MediaId"/>
                        </span>
                        : <a href="${pageContext.request.contextPath}/download/${recMessage.mediaId}" target="_blank"><fmt:message key="i18n.message.Clicktoview"/></a> 
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.ThumbMediaId"/>
                        </span>
                        : ${recMessage.thumbMediaId}
                      </p>
                    </div>
                  </div>
                  </s:if>
                   <s:if test="${recMessage.msgType=='shortvideo'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MediaId"/>
                        </span>
                        : <a href="${pageContext.request.contextPath}/download/${recMessage.mediaId}" target="_blank"><fmt:message key="i18n.message.Clicktoview"/></a> 
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.ThumbMediaId"/>
                        </span>
                        : ${recMessage.thumbMediaId}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${recMessage.msgType=='location'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Location_X"/>
                        </span>
                        : ${recMessage.location_X}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Location_Y"/>
                        </span>
                        : ${recMessage.location_Y}
                      </p>
                    </div>
                     <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Scale"/>
                        </span>
                        : ${recMessage.scale}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Label"/>
                        </span>
                        : ${recMessage.label}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${recMessage.msgType=='link'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${recMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${recMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${recMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${recMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Title"/>
                        </span>
                        : ${recMessage.title}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Description"/>
                        </span>
                        : ${recMessage.description}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Url"/>
                        </span>
                        : <a href="${recMessage.url}">${recMessage.url}</a> 
                      </p>
                    </div>
                  </div>
                  </s:if>
                </div>
         </section>
         <section class="panel">
          	<div class="panel-body bio-graph-info">
           	 	<h1>
             		<fmt:message key="i18n.info.Message.replay.details"/>
            	</h1>
            	<s:if test="${repMessage.msgType=='text'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${repMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${repMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${repMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${repMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.context"/>
                        </span>
                        : ${repMessage.context}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${repMessage.msgType=='image'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${repMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${repMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${repMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${repMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MediaId"/>
                        </span>
                        : ${repMessage.mediaId}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${repMessage.msgType=='voice'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${repMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${repMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${repMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${repMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MediaId"/>
                        </span>
                        : ${repMessage.mediaId}
                      </p>
                    </div>
                  </div>
                  </s:if>
                   <s:if test="${repMessage.msgType=='video'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${repMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${repMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${repMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${repMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MediaId"/>
                        </span>
                        : ${repMessage.mediaId}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Title"/>
                        </span>
                        : ${repMessage.title}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Description"/>
                        </span>
                        : ${repMessage.description}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${repMessage.msgType=='music'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${repMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${repMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${repMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${repMessage.createTime}
                      </p>
                    </div>
                     <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Title"/>
                        </span>
                        : ${repMessage.title}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Description"/>
                        </span>
                        : ${repMessage.description}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.MusicURL"/>
                        </span>
                        : ${repMessage.musicURL}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.HQMusicUrl"/>
                        </span>
                        : ${repMessage.hqMusicUrl}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.ThumbMediaId"/>
                        </span>
                        : ${repMessage.thumbMediaId}
                      </p>
                    </div>
                  </div>
                  </s:if>
                  <s:if test="${repMessage.msgType=='news'}">
                  	 <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          id
                        </span>
                        : ${repMessage.id}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.message.toUserName"/> 
                        </span>
                        : ${repMessage.toUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.fromUserName"/> 
                        </span>
                        : ${repMessage.fromUserName}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.createTime"></fmt:message>
                        </span>
                        : ${repMessage.createTime}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         	<fmt:message key="i18n.message.ArticleCount"></fmt:message>
                        </span>
                        : ${repMessage.articleCount}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Title"/>
                        </span>
                        : ${repMessage.title}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Description"/>
                        </span>
                        : ${repMessage.description}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.picUrl"/>
                        </span>
                        : ${repMessage.picUrl}
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                         <fmt:message key="i18n.message.Url"/>
                        </span>
                        : ${repMessage.url}
                      </p>
                    </div>
                  </div>
                  </s:if>
 			</div>
        </section>
</section>
</section>