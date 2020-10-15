package bit.com.a.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDao dao;
	
	public MemberDto login( MemberDto dto) {
		
		return dao.login(dto);
	}
	
	public int idCheck( MemberDto dto) {
		
		return dao.idCheck(dto);
	}
	
	public void addMember( MemberDto dto) {
		
		dao.addMember(dto);
	}

}
