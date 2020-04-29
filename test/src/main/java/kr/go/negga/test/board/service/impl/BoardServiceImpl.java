package kr.go.negga.test.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.negga.test.board.service.BoardService;
import kr.go.negga.test.board.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardMapper")
	private BoardMapper boardMapper;

	// 전체 리스트
	public List<BoardVO> getBoardList(BoardVO boardVO) throws Exception {
		return boardMapper.getBoardList(boardVO);
	}

	// 전체 리스트 갯수
	public int getBoardListCnt(BoardVO boardVO) throws Exception {
		return boardMapper.getBoardListCnt(boardVO);
	}

	// 새글 작성
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardMapper.insertBoard(boardVO);

	}

	// 상세보기
	public BoardVO getBoard(BoardVO boardVO) throws Exception {
		return boardMapper.getBoard(boardVO);
	}

	// 수정하기
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardMapper.updateBoard(boardVO);
	}

	// 삭제하기
	public int deleteBoard(BoardVO boardVO) throws Exception {
		return boardMapper.deleteBoard(boardVO);
	}

	// 작성 된 글 번호 찾기
	public String selectBno(BoardVO boardVO) throws Exception {
		return boardMapper.selectBno(boardVO);
	}

}
