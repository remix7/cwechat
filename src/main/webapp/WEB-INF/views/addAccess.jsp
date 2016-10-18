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
	         <li class="active"><fmt:message key="i18n.menu.Addaccess"/> </li>
	      </ul>
	   </div>
	</div>
	<section class="panel">
                <div class="panel-body bio-graph-info">
                  <h1>
                   	<fmt:message key="i18n.info.settingaccess"/>
                  </h1>
                  <div class="row">
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.info.wechaturl"/> 
                        </span>
                        : <a href="https://mp.weixin.qq.com" target="_blank">https://mp.weixin.qq.com</a>
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          <fmt:message key="i18n.info.setting"/> 
                        </span>
                        : <fmt:message key="i18n.info.settingVal"/>
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          Url
                        </span>
                        : http://cwechat.cynara.top/accessWechat
                      </p>
                    </div>
                    <div class="bio-row">
                      <p>
                        <span>
                          Token
                        </span>
                        : cynara
                      </p>
                    </div>
                  </div>
                </div>
              </section>
	 <!-- BEGIN ROW -->
         <!-- BEGIN ROW  -->
        <div class="row">
         <div class="col-lg-12">
            <section class="panel">
               <header class="panel-heading">
               </header>
               <div class="panel-body">
                  <form role="form" class="form-horizontal tasi-form" action="${pageContext.request.contextPath}/addAccess" method="POST">
                     <div class="form-group has-success">
                        <label class="col-lg-2 control-label"><fmt:message key="i18n.appid"/> </label>
                        <div class="col-lg-10">
                           <input type="text" name="appid" value="${access.appid}" id="f-name" class="form-control">
                           <p class="help-block"><fmt:message key="i18n.info.appid"/> </p>
                           <p class="help-block">${appid}</p>
                        </div>
                     </div>
                     <div class="form-group has-error">
                        <label class="col-lg-2 control-label"><fmt:message key="i18n.secret"/> </label>
                        <div class="col-lg-10">
                           <input type="text" name="secret" value="${access.secret}" id="l-name" class="form-control">
                           <p class="help-block"><fmt:message key="i18n.info.secret"/></p>
                           <p class="help-block">${secret}</p>
                        </div>
                     </div>
                     <div class="form-group has-warning">
                        <label class="col-lg-2 control-label"><fmt:message key="i18n.encodingAESKey"/> </label>
                        <div class="col-lg-10">
                           <input type=text name="encodingAESKey" value="${access.encodingAESKey}"  class="form-control">
                           <p class="help-block"><fmt:message key="i18n.info.encodingAESKey"/></p>
                           <p class="help-block">${encodingAESKey}</p>
                        </div>
                     </div>
                     <div class="form-group has-warning">
                     		<label class="col-lg-2 control-label"><fmt:message key="i18n.validatecode"/> </label>
	                     <DIV class="col-lg-10">
							<input type="text"  name="randomcode" placeholder=<fmt:message key="i18n.validatecode"/> style="width:75% ;font-size: 12px;padding: 10px;border: 1px solid #eaeaea;font-family: 'Open Sans', sans-serif;"/>
							<IMG alt="va|lidateCode" src="${pageContext.request.contextPath}/ValidateCode" style="" /> 
							<s:if test="${randomCode!=null}">
								<p class="help-block"><fmt:message key="i18n.Validatecodeerror"/></p>
							</s:if>
						</DIV>
					</div>
                     <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                           <button class="btn btn-primary" type="submit"><fmt:message key="i18n.submit"/> </button>
                        </div>
                     </div>
                  </form>
               </div>
            </section>
          </div>
       </div>
<!-- END ROW -->
</section>
</section>