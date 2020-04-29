package kr.go.negga.test.member.service.impl;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import kr.go.negga.test.member.service.MemberVO;

//count 조회 		selectOne
//상세 조회     		selectOne
//입력                    insert
//수정        		update
//삭제			delete

@Mapper("memberMapper")
public class MemberMapper extends EgovAbstractMapper{
	
	// 회원가입
	public int userInsert(MemberVO memberVO) throws Exception {
		return insert("userInsert", memberVO);
	}
	
	// 로그인
	public MemberVO idCheck(MemberVO memberVO) throws Exception {
		return selectOne("idCheck", memberVO);
	}
}
