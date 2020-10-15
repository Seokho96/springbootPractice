package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getBbsList( BbsParam param){
		
		return dao.getBbsList(param);
	}
	
	public int getBbsCount( BbsParam param ) {
		
		return dao.getBbsCount(param);
	}
	
	public BbsDto getBbsDetail( int seq) {
		
		return dao.getBbsDetail(seq);
	}
	
	public void deleteBbs( int seq) {
		dao.deleteBbs(seq);
	}
	public int updateBbs( BbsDto dto ) {
		return dao.updateBbs(dto);
	}
	
	public void bbsWrite( BbsDto dto ) {
		dao.bbsWrite(dto);
	}

}
