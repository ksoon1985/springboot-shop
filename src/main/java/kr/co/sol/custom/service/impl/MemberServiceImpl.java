package kr.co.sol.custom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sol.custom.dao.MemberDAO;
import kr.co.sol.custom.dto.MemberDTO;
import kr.co.sol.custom.service.MemberService;


@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public int idCheck(String id) {
		//데이터베이스 다녀오는 dao 호출
		return memberDao.idCheck(id);
	}

	@Override
	public int memberJoin(MemberDTO mdto) {
		return memberDao.memberJoin(mdto);
	}

	@Override
	public MemberDTO logonProc(MemberDTO mdto) {
		return memberDao.logonProc(mdto);
	}

	@Override
	public MemberDTO memberSelect(MemberDTO mdto) {
		return memberDao.memberSelect(mdto);
	}

	@Override
	public int memberUpdate(MemberDTO mdto) {
		return memberDao.memberUpdate(mdto);
	}

	@Override
	public int memberDelete(MemberDTO mdto) {
		return memberDao.memberDelete(mdto);
	}
}
