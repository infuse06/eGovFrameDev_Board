package kr.go.negga.test.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	
	// 전체 리스트
	public List<BoardVO> getBoardList(BoardVO boardVO) throws Exception;
	
	// 전체 리스트 갯수
	public int getBoardListCnt(BoardVO boardVO) throws Exception;
	
	// 새글 작성
	void insertBoard(BoardVO boardVO) throws Exception;
	
	// 상세 보기
	BoardVO getBoard(BoardVO boardVO) throws Exception;
	
	// 수정하기
	void updateBoard(BoardVO boardVO) throws Exception;
	
	// 삭제하기
	public int deleteBoard(BoardVO boardVO) throws Exception;
	
	// 작성된 번호 찾기
	public String selectBno(BoardVO boardVO) throws Exception;
}
