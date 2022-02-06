package kr.co.sol.admin.service;

import java.util.List;

import kr.co.sol.admin.dto.AdminDTO;
import kr.co.sol.custom.dto.MemberDTO;

public interface AdminService {
   String logon(AdminDTO adto);
   List<MemberDTO> getMemers(MemberDTO mdto);
}
