package kr.go.negga.test.board.service;

import java.util.List;

public interface ReplyService {

	// 댓글 조회
	public List<ReplyVO> readReply(String bno) throws Exception;
	
	// 댓글 등록
	void insertReply(ReplyVO replyVO) throws Exception;
	
	// 댓글 삭제
	public int deleteReply(ReplyVO replyVO) throws Exception;
	
	// 댓글 수정
	void modifyReply(ReplyVO replyVO) throws Exception;
	
	// 대댓글 달기
	void repReply(ReplyVO replyVO) throws Exception;
	
	// 대댓글 삭제
	public int deleteRepReply(ReplyVO replyVO) throws Exception;
	
	// 모든 댓글 삭제
	void allDeleteReply(String bno) throws Exception;
}
