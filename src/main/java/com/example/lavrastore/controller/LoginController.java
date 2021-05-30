package com.example.lavrastore.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.lavrastore.domain.Member;
import com.example.lavrastore.service.PetStoreFacade;

@Controller
@SessionAttributes("userSession")
public class LoginController { 

	private PetStoreFacade petStore;
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/login.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("memberid") String memberid,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		Member member = petStore.getMember(memberid, password);
		if (member == null) {
			return new ModelAndView("Error", "message", 
					"Invalid userid or password.  loginon failed.");
		}
		else {
			UserSession userSession = new UserSession(member);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return new ModelAndView("tiles/index");	// use Tiles
		}
	}
}

