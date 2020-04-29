package kr.go.negga.test.member.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.go.negga.test.board.service.BoardService;
import kr.go.negga.test.board.service.BoardVO;
import kr.go.negga.test.member.service.MemberService;
import kr.go.negga.test.member.service.MemberVO;

@Controller
public class MemberController {

	@Resource(name = "memberService")
	private MemberService memberService;

//	// 이동
//	@RequestMapping(value = "{url}.do")
//	public String home(@PathVariable String url) throws Exception {
//		System.out.println("이동하는 url 페이지 : " + url);
//		return "/test/" + url;
//	}
	
	// 로그인 페에지로
	@RequestMapping(value = "/login.do")
	public String login() throws Exception{
		return "test/login";
	}
	
	// 회원가입 페이지로
	@RequestMapping(value = "/userJoin.do")
	public String userJoin() throws Exception{
		return "test/userJoin";
	}
	
	// 회원가입
	@RequestMapping(value = "/userInsert.do")
	public String userInsert(@ModelAttribute("memberVO") MemberVO memberVO, Model model) throws Exception {
		
		String message = "";
		int result = memberService.userInsert(memberVO);
		
		if (result > 0)
			message = memberVO.getId() + "님 가입을 축하합니다.";
		
		model.addAttribute("message", message);
		model.addAttribute("result", result);
		
		return "test/login";
	}
	
	// 로그인
	@ RequestMapping(value = "/userLogin.do")
	public String userLogin(@ModelAttribute("memberVO") MemberVO memberVO, 
			Model model, 
			RedirectAttributes redirect) throws Exception {
		
		MemberVO result = memberService.idCheck_Login(memberVO);
		
		String id = result.getId();
		int curPage = 1;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("curPage", curPage);
		
		redirect.addAllAttributes(map);
		
		return "redirect:/getBoardList.do";
	}
}
