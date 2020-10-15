package bit.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	public List<BbsDto> getBbsList( BbsParam param );
	
	int getBbsCount( BbsParam param );
	
	BbsDto getBbsDetail( int seq);
	
	public void deleteBbs( int seq );
	
	int updateBbs( BbsDto dto );
	
	public void bbsWrite( BbsDto dto );

}
