package bit.com.a.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.dto.MemberDto;
import bit.com.a.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	MemberService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public MemberDto login( MemberDto dto ) {
		System.out.println("MemberController login()");
				
		MemberDto lodto = service.login(dto);
		
		return lodto;
		
	}
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck( MemberDto dto ) {
		System.out.println("MemberController idCheck()");
		String a = "";
		
		int count = service.idCheck(dto);
		
		if( count > 0 ) {
			a = "used";
		}
		else {
			a = "no";
		}	
		return a;
	}
	
	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public void addMember( MemberDto dto ) {
		System.out.println("MemberController addMember()");
		
		service.addMember(dto);
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout( HttpServletRequest req) {
		System.out.println("MemberController logout()");
		
		req.getSession().removeAttribute("login");
				
	}
}
