<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/style/public/title_setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>${sys_title}</title>
  <%@ include file="/style/public/meta.jsp" %>
  <!-- Loading Bootstrap -->
  <link href="${ctx}/style/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Loading Flat UI -->
  <link href="${ctx}/style/flatui/css/flat-ui.css" rel="stylesheet">
  <!-- Loading md5 -->
  <script type="text/javascript" src="${ctx}/style/js/md5.js"></script>
  <!-- Loading jquery -->
  <script type="text/javascript" src="${ctx}/style/js/jquery-2.2.3.min.js"></script>
  <script type="text/javascript">
      function login(){
          var password = $("#password").val();
          /* $("#password").val(hex_md5(password)); */
          $("#password").val(password);
          $("#login-forms").submit();
      }

  </script>
</head>
<body style="background-color:#3E607B">
<div class="container" >
  <div class="login"> 
    <div class="login-screen">
      <div class="login-icon"> 
        <img src="${ctx}/style/images/database.png" width="285px" height="90px" alt="" />
      </div> 
        <form method="post" action="${ctx}/user/login" id="login-forms">
        	<label for="loginName">用户名</label>
        	<input id="loginName" name="loginName" type="text" placeholder="输入您的用户名" class="span3">
        	<label for="passwore">密码</label>
        	<input id="passwore" type="password" name="passwore" placeholder="输入您的密码" class="span3"><br>
        	<input type="submit" class="btn btn-primary btn-block" value="登       录">
        </form> 
    </div> 
  </div>
</div>
</body>
</html>
