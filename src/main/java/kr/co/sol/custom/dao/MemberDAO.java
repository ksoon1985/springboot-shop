package kr.co.sol.custom.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.co.sol.custom.dto.MemberDTO;

@Mapper
public interface MemberDAO {
	int idCheck(String id);
	int memberJoin(MemberDTO mdto);
	MemberDTO logonProc(MemberDTO mdto);
	MemberDTO memberSelect(MemberDTO mdto);
	int memberUpdate(MemberDTO mdto);
	int memberDelete(MemberDTO mdto);

}
