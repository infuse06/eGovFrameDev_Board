<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 게시판 리스트</title>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script>
	function fn_paging(curPage, id) {
		location.href = "./getBoardList.do?curPage=" + curPage + "&id=" + id;
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
			<!-- 게시판 Body -->
			<div class="board-body">
				<table class="table table-hover table-striped" style="table-layout: fixed; word-break:break-all">
					<thead>
						<tr>
							<th scope="col" style="text-align: left" width="60">번호</th>
							<th scope="col" style="text-align: left" width="180">제목</th>
							<th scope="col" style="text-align: center" width="100">작성자</th>
							<th scope="col" style="text-align: left" width="150">날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr onclick="location.href='./getBoard.do?id=${id}&bid=${board.bid}&bno=${board.bno}&curPage=${pagination.curPage}'" style="cursor: pointer; height: 40px">
								<td style="text-align: left">${board.bno}</td>
								<td style="text-align: left">${board.title}</td>
								<td style="text-align: center">${board.bid}</td>
								<td style="text-align: left">${board.wdate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
				
			<!-- 게시판 페이징 -->
			<div align="center">
				<ul class="pagination">
					<li class="page-item"><a href="#" onClick="fn_paging(1, '${id}')"> << </a></li>
					
					<li class="page-item">
						<c:if test="${pagination.curPage ne 1}">
							<a href="#" onClick="fn_paging('${pagination.prevPage }', '${id}')"> < </a>
						</c:if>
					</li>
					
					<li class="page-item">
						<c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
							<c:choose>
								<c:when test="${pageNum eq  pagination.curPage}">
									<span style="font-weight: bold;">
										<a href="#" onClick="fn_paging('${pageNum }', '${id}')">${pageNum }</a>
									</span>
								</c:when>
		
								<c:otherwise>
									<a href="#" onClick="fn_paging('${pageNum }', '${id}')">${pageNum }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</li>
					
					<li class="page-item">
						<c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
							<a href="#" onClick="fn_paging('${pagination.nextPage }', '${id}')"> > </a>
						</c:if>
					</li>
					
					<li class="page-item">
						<a href="#" onClick="fn_paging('${pagination.pageCnt }', '${id}')"> >> </a>
					</li>
				</ul>
			</div>
			
			<div style="float: right">
				<input type="button" class="btn btn-primary" value="새로작성" onclick="location.href='./insertBoard.do?id=${id}&curPage=${pagination.curPage}'"/>
			</div>
			
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
	
<script>
if ('${resultOk}' == 1){
	alert("삭제되었습니다");	
}
</script>			
</body>
</html>