package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Member;
import model.MemberRepository;

@Controller
public class AuthController {
	MemberRepository repository = new MemberRepository();

	@RequestMapping(value = "register.html", method = RequestMethod.POST)
	public String register(Member obj) {
		repository.add(obj);
		return "redirect:/auth/logon.html";
	}

	@RequestMapping("register.html")
	public String register() {
		return "auth.register" ;
	}

}
