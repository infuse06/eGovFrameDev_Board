<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script>
function dataDelete(){
	alert("삭제하시겠습니까?");
}

if ('${resultOk}' == 2){
	alert("삭제되지않았습니다");
}

if ('${resultOk2}' == 1){
	alert("삭제되었습니다");	
}else if ('${resultOk2}' == 2){
	alert("삭제되지않았습니다");
}

if ('${resultOk3}' == 1){
	alert("삭제되었습니다");
}else if ('${resultOk3}' == 2){
	alert("삭제되지않았습니다");
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
			<table border="1" class="table table-striped" style="text-align: center; border: 1px solid #dddddd; height: 450px">
				<tr style="height: 15%">
					<td bgcolor="orange" width="70" style="vertical-align: middle">글번호</td>
					<td align="left" style="vertical-align: middle">
						${result.bno }
					</td>
				</tr>
				<tr style="height: 15%">
					<td bgcolor="orange" style="vertical-align: middle">제목</td>
					<td align="left" style="vertical-align: middle">
						${result.title }
					</td>
				</tr>
				<tr style="height: 15%">
					<td bgcolor="orange" style="vertical-align: middle">작성자</td>
					<td align="left" style="vertical-align: middle">
						${result.bid}
					</td>
				</tr>
				<tr style="height: 40%">
					<td bgcolor="orange">내용</td>
					<td align="left">
						${result.content }
					</td>
				</tr>
				<tr style="height: 15%">
					<td bgcolor="orange" style="vertical-align: middle">등록일</td>
					<td align="left" style="vertical-align: middle">
						${result.wdate }
					</td>
				</tr>
			</table>
			
			<div style="display: inline-block; float: right">
				<c:if test="${result.bid == id}">
				<input type="button" class="btn btn-warning" value="수정" onClick="location.href='./updateBoardGo.do?id=${id}&curPage=${curPage}&bid=${result.bid}&bno=${result.bno}&title=${result.title}&content=${result.content}&wdate=${result.wdate}'"/>
				<input type="button" class="btn btn-danger" id="boardDelete" value="삭제" onclick="dataDelete(); location.href='./deleteBoard.do?id=${id}&curPage=${curPage}&rid=${reply.rid}&rno=${reply.rno}&rcontent=${reply.rcontent}&rwdate=${reply.rwdate}&rrno=${reply.rrno}&bid=${result.bid}&bno=${result.bno}&title=${result.title}&content=${result.content}&wdate=${result.wdate}'"/>
				</c:if>
				<input type="button" class="btn btn-primary" value="목록" onclick="location.href='./getBoardList.do?id=${id}&curPage=${curPage}'"/>
			</div>
			
			<!-- 댓글 -->
			<div style="padding-top: 60px;">
				<form>
<!-- 					<div style="height:200px; overflow:auto"> -->
					<div>
						<table class="table table-striped" style="width: 100%; ">
							<c:forEach var="reply" items="${repList}">
								<c:if test="${result.bno eq reply.bno}">
								<c:choose>
									<c:when test="${reply.rrno eq 0}">
									<tr>
										<td style="width: 10%">
											${reply.rno}
										</td>
										<td style="width: 15%">
											${reply.rid}
											<br />
											<font size="2" color="lightgray">${reply.rwdate}</font>
										</td>
										<td style="width: 50%">
											${reply.rcontent}
											<input type="hidden" name="id" value="${id}"/>
											<input type="hidden" name="curPage" value="${curPage}"/>
											<input type="hidden" name="bid" value="${result.bid}"/>
											<input type="hidden" name="bno" value="${result.bno}"/>
											<input type="hidden" name="rno" value="${reply.rno}"/>
											<input type="hidden" name="rid" value="${id}"/>
											<input type="hidden" name="title" value="${result.title}"/>
											<input type="hidden" name="content" value="${result.content}"/>
											<input type="hidden" name="wdate" value="${result.wdate}"/>
										</td>
										<td style="width: 22%; text-align: center;" >
											<input class="btn btn-link" type="button" value="[답글]" onClick="location.href='./repReplyGo.do?id=${id}&curPage=${curPage}&rid=${reply.rid}&rno=${reply.rno}&rcontent=${reply.rcontent}&rwdate=${reply.rwdate}&rrno=${reply.rrno}&bid=${result.bid}&bno=${result.bno}&title=${result.title}&content=${result.content}&wdate=${result.wdate}'"/>	
											<input class="btn btn-link" type="button" value="[수정]" onClick="location.href='./modifyReplyGo.do?id=${id}&curPage=${curPage}&rid=${reply.rid}&rno=${reply.rno}&rcontent=${reply.rcontent}&rwdate=${reply.rwdate}&rrno=${reply.rrno}&bid=${result.bid}&bno=${result.bno}&title=${result.title}&content=${result.content}&wdate=${result.wdate}'" />						
											<input class="btn btn-link" type="button" value="[삭제]" onclick="dataDelete(); location.href='./deleteReply.do?id=${id}&curPage=${curPage}&rid=${reply.rid}&rno=${reply.rno}&rcontent=${reply.rcontent}&rwdate=${reply.rwdate}&rrno=${reply.rrno}&bid=${result.bid}&bno=${result.bno}&title=${result.title}&content=${result.content}&wdate=${result.wdate}'" />								
										</td>
									</tr>
									</c:when>
									
									<c:when test="${reply.rrno ne 0}">
									<tr>
										<td style="width: 10%">
											└
										</td>
										<td style="width: 15%">
											${reply.rid}
											<br />
											<font size="2" color="lightgray">${reply.rwdate}</font>
										</td>
										<td style="width: 50%">
											${reply.rcontent}
										</td>
										<td style="width: 22%; text-align: center;" >
											<input class="btn btn-link" type="button" value="[삭제]" onclick="dataDelete(); location.href='./deleteRepReply.do?id=${id}&curPage=${curPage}&rid=${reply.rid}&rno=${reply.rno}&rrno=${reply.rrno}&bid=${result.bid}&bno=${result.bno}&title=${result.title}&content=${result.content}&wdate=${result.wdate}'" />
										</td>
									</tr>
									</c:when>
									
								</c:choose>
								
								</c:if>
							</c:forEach>
							
							</table>
						</div>
				</form>
						
				<form action="./insertReply.do" method="post">
					<table class="table table-striped" style="width: 100%">
						<tr class="reply-insert">
							<td style="width: 18%">
								${id }
							</td>
							<td style="width: 60%">
								<input type="hidden" name="id" value="${id}"/>
								<input type="hidden" name="curPage" value="${curPage}"/>
								<input type="hidden" name="bid" value="${result.bid}"/>
								<input type="hidden" name="bno" value="${result.bno}"/>
								<input type="hidden" name="rno" value="${reply.rno}"/>
								<input type="hidden" name="rid" value="${id}"/>
								<input type="hidden" name="rwdate" value="${reply.rwdate}"/>
								<input type="hidden" name="rrno" value="${reply.rrno}"/>
								<input type="hidden" name="title" value="${result.title}"/>
								<input type="hidden" name="content" value="${result.content}"/>
								<input type="hidden" name="wdate" value="${result.wdate}"/>
								<textarea class="form-control" name="rcontent" rows="4"></textarea>
							</td>
							<td style="width: 22%; text-align: center;">
								<input class="btn btn-link" type="submit" value="[댓글등록]">
							</td>
						</tr>
					</table>
				</form>
			</div>
			
		</div>
		
	</div>
</body>
</html>
