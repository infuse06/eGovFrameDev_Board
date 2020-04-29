package kr.go.negga.test.member.service;

public interface MemberService {

	// 회원가입
	public int userInsert(MemberVO memberVO) throws Exception;
	
	// 아이디체크&로그인
	public MemberVO idCheck_Login(MemberVO memberVO) throws Exception;
	
}
