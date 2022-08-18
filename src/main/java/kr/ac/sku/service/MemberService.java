package kr.ac.sku.service;

import java.util.List;

import kr.ac.sku.dao.MemberDAO;
import kr.ac.sku.dto.MemberDTO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	//회원가입
	public void joinMember(MemberDTO member) {
		//회원 가입을 위해서 체크해야하거나
		//필요한 비지니스가 있다면 여기서 구현!!  
		//회원가입 조건에 충족하면 DB에 저장하도록 dao를 이용한다.
		boolean resultFlag = dao.addMember(member);
		if(resultFlag)
			System.out.println("DB에 저장성공");
		else
			System.out.println("DB에 저장하다가 문제 발생!!");
	}
	//회원목록
	public List<MemberDTO> getMemberList(){
		return dao.getMembers();
	}
	
	//회원삭제
	public void delMember(String id) {
		dao.delMember(id);
	}

	//회원정보조회
	public MemberDTO getMember(String id) {

		return dao.getMember(id);
	}

	//회원정보수정
	public void updateMember(MemberDTO member) {

		dao.updateMember(member);
	}

	//회원확인
	public int checkMember(String id, String password){
		MemberDTO member = dao.getMember(id);
		if(member == null)
			return 1;				//회원가입 안한 사용자
		else if(member.getPassword().equals(password))
			return 3;				//아이디, 비밀번호 맞음
		else
			return 2;				//비밀번호 틀림
	}

}