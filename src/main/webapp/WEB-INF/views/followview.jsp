<%@ include file="/WEB-INF/views/public/header.jspf"%>
<%@ include file="/WEB-INF/views/public/menus.jspf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="main-content">
	<section class="wrapper">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="${pageContext.request.contextPath}/"><i
							class="fa fa-home"></i> <fmt:message key="i18n.Home" /> </a></li>
					<li>»</li>
					<li><fmt:message key="i18n.menu.Accessinformation" /></li>
					<li>»</li>
					<li class="active"><fmt:message key="i18n.menu.user" /></li>
				</ul>
			</div>
		</div>
		<section class="panel">
			<div class="panel-body bio-graph-info">
				<h1>
					<fmt:message key="i18n.menu.user" />
				</h1>
				<div class="row">
					<div class="bio-row">
						<p>
							<span><fmt:message key="i18n.follow.image" /> </span> <img
								alt="" src="${rMap.headimgurl}" width="100px" height="100px">
						</p>
					</div>

				</div>
				<div class="row">
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.nickname" />
							</span> : ${rMap.nickname}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.gender" />
							</span> :
							<s:if test="${rMap.sex=='1'}">
								<fmt:message key="i18n.follow.male" />
							</s:if>
							<s:if test="${rMap.sex=='2'}">
								<fmt:message key="i18n.follow.female" />
							</s:if>
							<s:if test="${rMap.sex=='0'}">
								<fmt:message key="i18n.follow.unknow" />
							</s:if>
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.country" />
							</span> : ${rMap.country}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.province" />
							</span> : ${rMap.province}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.city" />
							</span> : ${rMap.city}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.subscribe_time" />
							</span> : ${rMap.subscribe_time}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.remark" />
							</span> : ${rMap.remark}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.groupid" />
							</span> : ${rMap.groupid}
						</p>
					</div>
					<div class="bio-row">
						<p>
							<span> <fmt:message key="i18n.follow.tagid_list" />
							</span> : ${rMap.tagid_list}
						</p>
					</div>
				</div>
			</div>
		</section>
	</section>
</section>