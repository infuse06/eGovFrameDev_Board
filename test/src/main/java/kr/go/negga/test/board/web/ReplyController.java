package kr.go.negga.test.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.go.negga.test.board.service.BoardService;
import kr.go.negga.test.board.service.BoardVO;
import kr.go.negga.test.board.service.ReplyService;
import kr.go.negga.test.board.service.ReplyVO;
import kr.go.negga.test.member.service.MemberVO;

@Controller
public class ReplyController {
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "replyService")
	private ReplyService replyService;
	
	// 댓글 등록
	@RequestMapping(value = "/insertReply.do")
	public String insertReply(@ModelAttribute("memberVO") MemberVO memberVO,
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		replyService.insertReply(replyVO);
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("selectedRep", replyVO.getRid());
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
		
		return "test/getBoard";
	}
	
	// 댓글 삭제
	@RequestMapping(value = "/deleteReply.do")
	public String deleteReply(@ModelAttribute("memberVO") MemberVO memberVO,
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		int resultOk2 = replyService.deleteReply(replyVO);
		if (resultOk2 == 0) {
			resultOk2 = 2;
		}
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("resultOk2", resultOk2);
		model.addAttribute("repList", repList);
		model.addAttribute("selectedRep", replyVO.getRid());
		model.addAttribute("selectedRcon", replyVO.getRcontent());
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
			
		return "test/getBoard";
	}
	
	// 댓글 수정하기 페이지로
	@RequestMapping(value = "/modifyReplyGo.do")
	public String modifyReplyGo(@ModelAttribute("memberVO") MemberVO memberVO, 
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("selectedRep", replyVO.getRid());
		model.addAttribute("selectedRcon", replyVO.getRcontent());
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
		
		return "test/updateReply";
	}
	
	// 댓글 수정
	@RequestMapping(value = "/modifyReply.do")
	public String modifyReply(@ModelAttribute("memberVO") MemberVO memberVO,
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		replyService.modifyReply(replyVO);
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
		
		return "test/getBoard";
	}
	
	// 댓글 답글하기 페이지로
	@RequestMapping(value = "/repReplyGo.do")
	public String repReplyGo(@ModelAttribute("memberVO") MemberVO memberVO, 
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("selectedRep", replyVO.getRid());
		model.addAttribute("selectedRcon", replyVO.getRcontent());
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
		
		return "test/repReply";
	}
	
	// 대댓글 달기
	@RequestMapping(value = "/repReply.do")
	public String repReply(@ModelAttribute("memberVO") MemberVO memberVO, 
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		replyService.repReply(replyVO);
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
		
		return "test/getBoard";
	}
	
	// 대댓글 삭제
	@RequestMapping(value = "/deleteRepReply.do")
	public String deleteRepReply(@ModelAttribute("memberVO") MemberVO memberVO, 
			@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		int resultOk3 = replyService.deleteRepReply(replyVO);
		if (resultOk3 == 0) {
			resultOk3 = 2;
		}
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("resultOk3", resultOk3);
		model.addAttribute("repList", repList);
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);
		
		return "test/getBoard";
	}
	

}
