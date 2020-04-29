package kr.go.negga.test.board.service;

public class BoardVO {

	// 게시글
	private String bid; // 작성자
	private String id; 
	private String bno; // 번호
	private String title; // 제목
	private String content; // 내용
	private String wdate; // 작성일
	
	// 페이징
	private int startIndex;
	private int endIndex;
	private int curPage;
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	// 게시글 getter/setter
	public String getBid() {
		return bid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

}
