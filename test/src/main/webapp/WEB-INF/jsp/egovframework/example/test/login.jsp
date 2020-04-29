<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>로그인 페이지</title>
<meta name="robots" content="noindex">
<link rel="shortcut icon" type="image/x-icon"
	href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
<link rel="mask-icon" type=""
	href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg"
	color="#111" />
<link rel="canonical" href="https://codepen.io/frytyler/pen/EGdtg" />
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'>
<script src='https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js'></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/login.css'/>"/>
<script type="text/javascript">
if ('${result}' == 1){
	var message = '${message}';
	alert(message);
}
</script>
</head>

<body class="align">
	<div class="grid">
		<form action="./userLogin.do" method="POST" class="form login">
			<div class="form__field">
				<label for="login__username">
					<svg class="icon">
						<use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#user"></use>
					</svg>
				</label>
				<input id="login__username" type="text" name="id" class="form__input" placeholder="Username" required>
			</div>

			<div class="form__field">
				<label for="login__password">
					<svg class="icon">
						<use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#lock"></use>
					</svg>
				</label>
				<input id="login__password" type="password" name="pass" class="form__input" placeholder="Password" required>
			</div>

			<div class="form__field">
				<input type="submit" value="Sign In">
			</div>
		</form>

		<div class="sign_up">
			<a href="./userJoin.do">Sign up now</a>
		</div>

		<svg xmlns="http://www.w3.org/2000/svg" class="icons">
		<symbol id="arrow-right" viewBox="0 0 1792 1792">
		<path
				d="M1600 960q0 54-37 91l-651 651q-39 37-91 37-51 0-90-37l-75-75q-38-38-38-91t38-91l293-293H245q-52 0-84.5-37.5T128 1024V896q0-53 32.5-90.5T245 768h704L656 474q-38-36-38-90t38-90l75-75q38-38 90-38 53 0 91 38l651 651q37 35 37 90z" />
		</symbol>
			<symbol id="lock" viewBox="0 0 1792 1792">
			<path
				d="M640 768h512V576q0-106-75-181t-181-75-181 75-75 181v192zm832 96v576q0 40-28 68t-68 28H416q-40 0-68-28t-28-68V864q0-40 28-68t68-28h32V576q0-184 132-316t316-132 316 132 132 316v192h32q40 0 68 28t28 68z" /></symbol>
			<symbol id="user" viewBox="0 0 1792 1792">
			<path
				d="M1600 1405q0 120-73 189.5t-194 69.5H459q-121 0-194-69.5T192 1405q0-53 3.5-103.5t14-109T236 1084t43-97.5 62-81 85.5-53.5T538 832q9 0 42 21.5t74.5 48 108 48T896 971t133.5-21.5 108-48 74.5-48 42-21.5q61 0 111.5 20t85.5 53.5 62 81 43 97.5 26.5 108.5 14 109 3.5 103.5zm-320-893q0 159-112.5 271.5T896 896 624.5 783.5 512 512t112.5-271.5T896 128t271.5 112.5T1280 512z" /></symbol></svg>
	</div>	
</body>
</html>