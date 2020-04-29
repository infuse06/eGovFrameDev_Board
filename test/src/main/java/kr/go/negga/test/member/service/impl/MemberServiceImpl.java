package kr.go.negga.test.member.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.go.negga.test.member.service.MemberService;
import kr.go.negga.test.member.service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Resource(name="memberMapper")
	private MemberMapper memberMapper;
	
	// 회원가입
	public int userInsert(MemberVO memberVO) throws Exception {
		return memberMapper.userInsert(memberVO);
	}

	// 로그인
	public MemberVO idCheck_Login(MemberVO memberVO) throws Exception {
		return memberMapper.idCheck(memberVO);
	}

}
