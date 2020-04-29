package kr.go.negga.test.board.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.go.negga.test.board.service.ReplyVO;

@Mapper("replyMapper")
public class ReplyMapper extends EgovAbstractMapper{
	
	// 댓글 조회
	public List<ReplyVO> readReply(String bno) throws Exception {
		return selectList("readReply", bno);
	}
	
	// 댓글 등록
	public void insertReply(ReplyVO replyVO) throws Exception {
		insert("insertReply", replyVO);
	}
	
	// 댓글 삭제
	public int deleteReply(ReplyVO replyVO) throws Exception {
		return delete("deleteReply", replyVO);
	}
	
	// 댓글 수정
	public void modifyReply(ReplyVO replyVO) throws Exception {
		update("modifyReply", replyVO);
	}
	
	// 대댓글 달기
	public void repReply(ReplyVO replyVO) throws Exception {
		insert("repReply", replyVO);
	}
	
	// 대댓글 삭제
	public int deleteRepReply(ReplyVO replyVO) throws Exception {
		return delete("deleteRepReply", replyVO);
	}
	
	// 대댓글 개수
	public int selectCnt(ReplyVO replyVO) throws Exception {
		return selectOne("selectCnt", replyVO);
	}
	
	// 모든 댓글 지우기
	public void allDeleteReply(String bno) throws Exception {
		delete("allDeleteReply", bno);
	}
}
