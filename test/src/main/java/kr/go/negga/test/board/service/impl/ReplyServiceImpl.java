package kr.go.negga.test.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.negga.test.board.service.ReplyService;
import kr.go.negga.test.board.service.ReplyVO;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource(name = "replyMapper")
	private ReplyMapper replyMapper;

	// 댓글 조회
	public List<ReplyVO> readReply(String bno) throws Exception {
		return replyMapper.readReply(bno);
	}

	// 댓글 등록
	public void insertReply(ReplyVO replyVO) throws Exception {
		replyMapper.insertReply(replyVO);
	}

	// 댓글 삭제
	public int deleteReply(ReplyVO replyVO) throws Exception {
		// select 한번 해봄 -> 개수 2이상이다
		int resultCnt = replyMapper.selectCnt(replyVO);
		
		if (resultCnt == 1) {
			int result = replyMapper.deleteReply(replyVO);
			return result;
		} else {
			int result = 0;
			return result;
		}
	}

	// 댓글 수정
	public void modifyReply(ReplyVO replyVO) throws Exception {
		replyMapper.modifyReply(replyVO);
		
	}

	// 대댓글 달기
	public void repReply(ReplyVO replyVO) throws Exception {
		replyMapper.repReply(replyVO);
		
	}

	// 대댓글 삭제
	public int deleteRepReply(ReplyVO replyVO) throws Exception {
		return replyMapper.deleteRepReply(replyVO);
		
	}

	// 모든 댓글 지우기
	public void allDeleteReply(String bno) throws Exception {
		replyMapper.allDeleteReply(bno);
	}

}
