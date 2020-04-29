<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
function noSpaceForm(obj) 
{             
    var str_space = /\s/;               // 공백 체크
    if(str_space.exec(obj.value)) 
    {     // 공백 체크
        alert("공백을 제거합니다");
        obj.focus();
        obj.value = obj.value.replace(' ',''); // 공백제거
        return false;
    }
}
</script>

</head>
<body>
	<!-- 네비게이션  -->
	<nav class="navbar navbar-default" style="margin-top: 10px; padding-left: 10px; padding-right: 10px;">
		<c:if test="${id ne null}">
			<span style="float: left; font-weight: bold">${id}님이 접속중</span>
			<a style="float: right" class="navbar-brand" href="./login.do">로그아웃</a>
		</c:if>
	</nav>
	
	<div class="container">
		<!-- 광고 배너 -->
		<div style="text-align: center; margin-top: 30px">
			<a href="#">
				<img src="<c:url value='/images/egovframework/example/banner.png'/>" alt="" style="width: 100%; height: auto">
			</a>
		</div>
		
		<div style="margin-top: 60px">
			<form action="./saveBoard.do" method="post" enctype="multipart/form-data">
				<table border="1" class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								<input type="text" class="form-control" onkeyup="noSpaceForm(this)" placeholder="글 제목" name="title" maxlength="50" required />
							</td>
						</tr>
						<tr>
							<td>
								<textarea class="form-control" onkeyup="noSpaceForm(this)" placeholder="글 내용" name="content" maxlength="2048" style="height: 350px;" required></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				
				<div style="display: inline-block; float: right">
					
					<input type="hidden" name="bid" value="${id}"/>
					<input type="hidden" name="id" value="${id}"/>
					<input type="hidden" name="curPage" value="${curPage}"/>
					<input type="submit" class="btn btn-primary" value="입력"/>
					<input type="button" class="btn btn-default" value="취소" onclick="location.href='./getBoardList.do?id=${id}&curPage=${curPage}'"/>
				</div>
			</form>
		</div>
	</div>
		
	<!-- 하단 -->
	<footer id="ft" style="bottom: 0px; position: absolute; width: 100%; padding-left: 10px; padding-right: 10px;">
	<hr/>
		<div class="company">
			<div class="pad">
				<a href="#">
					<b>솔루션</b>
				</a>
				<a href="#">
					<b>문의</b>
				</a>
				<a href="#">회사소개</a>
				<a href="#">이용약관</a>
				<a href="#">개인정보처리방침</a>
				<a href="#">이용가이드</a>
				<a href="#">게시물규제정책</a>
			</div>
		</div>
		<div class="pad info">
			<P>
				<strong>회사 이름</strong>
				<span>회사 주소</span>
				<span>대표메일</span>
				<span>사업자등록번호</span>
				<span>대표이름</span>
				<span>개인정보보호책임자</span>
			</P>
			<p>
				<a href="#">회사주소</a>
			</p>
		</div>
	</footer>
</body>
</html>