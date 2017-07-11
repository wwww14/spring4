<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/style/public/title_setting.jsp"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<link href="${ctx}/style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/style/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${ctx}/style/bootstrap/js/jquery.min.js"></script>
<script src="${ctx}/style/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="containet">
	
		<div class="accordion" id="accordion1">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" href="#collapse1" data-toggle="collapse" data-parent="#accordion1">折叠内容一</a>
				</div>
				<div class="collapse in" id="collapse1">
					<div class="accordion-inner"><a href="#"><span class="badge">11</span>子菜单一xx</a></div>
					<div class="accordion-inner">子菜单一esss</div>
					<div class="accordion-inner">子菜单一saaa</div>
				</div> 
			</div>
			
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" href="#collapse2" data-toggle="collapse" data-parent="#accordion1">折叠内容二</a>
				</div>
				<div class="collapse" id="collapse2">
					<div class="accordion-inner">子菜单二ggg</div>
					<div class="accordion-inner">子菜单二fff</div>
					<div class="accordion-inner">子菜单二555</div>
					<div class="accordion-inner">子菜单二uuu</div>
				</div> 
			</div>
			
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" href="#collapse3" data-toggle="collapse" data-parent="#accordion1">折叠内容三</a>
				</div>
				<div class="collapse" id="collapse3">
					<div class="accordion-inner">子菜单二ggg</div>
					<div class="accordion-inner">子菜单二fff</div>
					<div class="accordion-inner">子菜单二555</div>
					<div class="accordion-inner">子菜单二uuu</div>
				</div> 
			</div>
			
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" href="#collapse4" data-toggle="collapse" data-parent="#accordion1">折叠内容三</a>
				</div>
				<div class="collapse" id="collapse4">
					<div class="accordion-inner">子菜单二ggg</div>
					<div class="accordion-inner">子菜单二fff</div>
					<div class="accordion-inner">子菜单二555</div>
					<div class="accordion-inner">子菜单二uuu</div>
				</div> 
			</div>
			
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" href="#collapse5" data-toggle="collapse" data-parent="#accordion1">折叠内容三</a>
				</div>
				<div class="collapse" id="collapse5">
					<div class="accordion-inner">子菜单二ggg</div>
					<div class="accordion-inner">子菜单二fff</div>
					<div class="accordion-inner">子菜单二555</div>
					<div class="accordion-inner">子菜单二uuu</div>
				</div> 
			</div>
			
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" href="#collapse6" data-toggle="collapse" data-parent="#accordion1">折叠内容三</a>
				</div>
				<div class="collapse" id="collapse6">
					<div class="accordion-inner">子菜单二ggg</div>
					<div class="accordion-inner">子菜单二fff</div>
					<div class="accordion-inner">子菜单二555</div>
					<div class="accordion-inner">子菜单二uuu</div>
				</div> 
			</div>
			
			
		</div>
	</div>
</body>
</html>