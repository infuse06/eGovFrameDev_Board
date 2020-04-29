package kr.go.negga.test.board.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.go.negga.test.board.service.BoardService;
import kr.go.negga.test.board.service.BoardVO;
import kr.go.negga.test.board.service.Pagination;
import kr.go.negga.test.board.service.ReplyService;
import kr.go.negga.test.board.service.ReplyVO;
import kr.go.negga.test.member.service.MemberVO;


@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "replyService")
	private ReplyService replyService;

	// 전체 보기 페이지로
	@RequestMapping(value = "/getBoardList.do")
	public String getBoardList(@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("memberVO") MemberVO memberVO, 
			Model model) throws Exception {
		
		// 전체 리스트 개수
		int listCnt = boardService.getBoardListCnt(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();

		Pagination pagination = new Pagination(listCnt, curPage);
		boardVO.setStartIndex(pagination.getStartIndex());
		boardVO.setEndIndex(pagination.getEndIndex());

		// 전체 리스트 출력
		List<BoardVO> list = boardService.getBoardList(boardVO);

		model.addAttribute("list", list);
		model.addAttribute("listCnt", listCnt);
		model.addAttribute("id", id);
		model.addAttribute("pagination", pagination);

		return "test/getBoardList";
	}

	// 새글 작성 페이지로
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(@ModelAttribute("boardVO") BoardVO boardVO, 
			@ModelAttribute("memberVO") MemberVO memberVO,
			Model model) throws Exception {
		
		String id = memberVO.getId();
		int curPage = boardVO.getCurPage();

		model.addAttribute("id", id);				
		model.addAttribute("curPage", curPage);

		return "test/insertBoard";
	}

	// 새글 등록
	@RequestMapping(value = "/saveBoard.do")
	public String saveBoard(@ModelAttribute("boardVO") BoardVO boardVO,
			@ModelAttribute("memberVO") MemberVO memberVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {

		boardService.insertBoard(boardVO);
		String bno = boardService.selectBno(boardVO);
		boardVO.setBno(bno);
		
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
	
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("selectedRep", replyVO.getId());
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);

		return "test/getBoard";
	}

	// 상세보기 페이지로
	@RequestMapping(value = "/getBoard.do")
	public String getBoard(@ModelAttribute("memberVO") MemberVO memberVO,
			@ModelAttribute("boardVO") BoardVO boardVO, 
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
				
		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		String bno = boardVO.getBno();
		List<ReplyVO> repList = replyService.readReply(bno);
		
		model.addAttribute("repList", repList);
		model.addAttribute("selectedRep", replyVO.getId());
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);

		return "test/getBoard";
	}

	// 수정하기 페이지로
	@RequestMapping(value = "/updateBoardGo.do")
	public String updateBoard(@ModelAttribute("memberVO") MemberVO memberVO, 
			@ModelAttribute("boardVO") BoardVO boardVO, 
			Model model) throws Exception {

		BoardVO result = boardService.getBoard(boardVO);
		int curPage = boardVO.getCurPage();
		String id = memberVO.getId();
		
		model.addAttribute("result", result);
		model.addAttribute("curPage", curPage);
		model.addAttribute("id", id);

		return "test/updateBoard";
	}

	// 수정하기
	@RequestMapping(value = "/updateBoard.do")
	public String update(@ModelAttribute("memberVO") MemberVO memberVO, 
			@ModelAttribute("boardVO") BoardVO boardVO, 
			Model model) throws Exception {
		
		boardService.updateBoard(boardVO);
		
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

	// 삭제하기
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(
			@ModelAttribute("boardVO") BoardVO boardVO, 
			@ModelAttribute("memberVO") MemberVO memberVO,
			@ModelAttribute("ReplyVO") ReplyVO replyVO,
			Model model) throws Exception {
		
		String bno = boardVO.getBno();
		replyService.allDeleteReply(bno);
		
		int resultOk = boardService.deleteBoard(boardVO);
		
		if (resultOk == 1) {
			int listCnt = boardService.getBoardListCnt(boardVO);
			
			String id = memberVO.getId();
			int curPage = boardVO.getCurPage();

			Pagination pagination = new Pagination(listCnt, curPage);
			boardVO.setStartIndex(pagination.getStartIndex());
			boardVO.setEndIndex(pagination.getEndIndex());

			// 전체 리스트 출력
			List<BoardVO> list = boardService.getBoardList(boardVO);
			
			model.addAttribute("resultOk", resultOk);
			model.addAttribute("list", list);
			model.addAttribute("listCnt", listCnt);
			model.addAttribute("id", id);
			model.addAttribute("pagination", pagination);

			return "test/getBoardList";
		}else {
			resultOk = 2;
			
			BoardVO result = boardService.getBoard(boardVO);
			int curPage = boardVO.getCurPage();
			String id = memberVO.getId();
			
			List<ReplyVO> repList = replyService.readReply(bno);
			
			model.addAttribute("resultOk", resultOk);
			model.addAttribute("repList", repList);
			model.addAttribute("result", result);
			model.addAttribute("curPage", curPage);
			model.addAttribute("id", id);

			return "test/getBoard";
		}
		
	}
	
}
