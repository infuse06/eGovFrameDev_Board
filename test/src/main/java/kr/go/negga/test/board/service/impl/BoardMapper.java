package kr.go.negga.test.board.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.go.negga.test.board.service.BoardVO;

//count 조회 		selectOne
//상세 조회     		selectOne
//입력                   insert
//수정        		update
//삭제			delete

@Mapper("boardMapper")
public class BoardMapper extends EgovAbstractMapper{

	// 전체 리스트
	public List<BoardVO> getBoardList(BoardVO boardVO) throws Exception{
		return selectList("selectBoardList", boardVO);
	}
	
	// 전체 리스트 갯수
	public int getBoardListCnt(BoardVO boardVO) throws Exception{
		return selectOne("selectBoardListCnt", boardVO);
	}
	
	// 새글 작성
	public void insertBoard(BoardVO boardVO) throws Exception{
		insert("insertBoard", boardVO);
	}
	
	// 상세보기
	public BoardVO getBoard(BoardVO boardVO) throws Exception{
		return selectOne("getBoard", boardVO);
	}
	
	// 수정하기
	public void updateBoard(BoardVO boardVO) throws Exception{
		update("updateBoard", boardVO);
	}
	
	// 삭제하기
	public int deleteBoard(BoardVO boardVO) throws Exception{
		return delete("deleteBoard", boardVO);
	}
	
	// 작성 된 글 번호 찾기
	public String selectBno(BoardVO boardVO) throws Exception{
		return selectOne("selectBno", boardVO);
	}
}
