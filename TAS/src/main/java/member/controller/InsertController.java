package member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.dto.MemberDTO;
import member.service.MemberService;

@Controller
public class InsertController {
	@Autowired
	MemberService service;
	
	//get방식으로 요청될때 실행할 메소드 - insert페이지를 response
	@RequestMapping(value="/memberinsert.do", method=RequestMethod.GET)
	public String showPage(){
		return "memberinput/form";
	}
	
	//post방식으로 요청될때 실행할 메소드 - 실제 db에 insert를 하기 위한 기능을 수행
	@RequestMapping(value="/memberinsert.do", method=RequestMethod.POST)
	public ModelAndView runInsert(HttpServletRequest req, MemberDTO user, String id){
		
		service.insert(user);
		return new ModelAndView("redirect:memberlist.do");
	}
}

