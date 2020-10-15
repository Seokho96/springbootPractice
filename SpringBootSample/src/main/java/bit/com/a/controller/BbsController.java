package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "/getBbsList")
	public List<BbsDto> getBbsList( BbsParam param ){
		System.out.println("BbsController getBbsList()");
		// paging 처리
				int sn = param.getPageNumber();
				int start = sn * param.getRecordCountPerPage() + 1;
				int end = (sn + 1) * param.getRecordCountPerPage();
				
				param.setStart(start);
				param.setEnd(end);
				
				List<BbsDto> bbsList = null;
				bbsList = service.getBbsList(param);
											
		return bbsList;
	}
	

	@RequestMapping(value = "/bbsListCount", method = {RequestMethod.GET, RequestMethod.POST})
	public int bbsCount(BbsParam param) throws Exception {
		int count = 0;
		count =	service.getBbsCount(param);
		return count;
	}
	
	@RequestMapping(value = "/bbsDetail", method = {RequestMethod.GET, RequestMethod.POST})
	public BbsDto bbsDetail( int seq ) throws Exception {
		
		BbsDto dto = service.getBbsDetail(seq);
			
		return dto;
	}
	
	@RequestMapping(value = "/bbsDelete", method = {RequestMethod.GET, RequestMethod.POST})
	public void bbsDelete( int seq ) throws Exception {
		
		service.deleteBbs(seq);

	}
	
	@RequestMapping(value = "/bbsUpdate", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsUpdate( BbsDto dto ) throws Exception {
		String a = "";
		int i = service.updateBbs(dto);
		
		if(i > 0) {
			a = "yes";
		}else {
			a="no";
		}
		return a;

	}
	
	@RequestMapping(value = "/bbsWrite", method = {RequestMethod.GET, RequestMethod.POST})
	public void bbsWrite( BbsDto dto ) throws Exception {
		
		System.out.println("BbsController bbsWrite()");
		System.out.println(dto.getId() + " 내용 " + dto.getContent() + " 제목 " + dto.getTitle());
		service.bbsWrite(dto);

	}

}
