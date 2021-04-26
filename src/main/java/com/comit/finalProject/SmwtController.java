package com.comit.finalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SmwtController {
	
	@Autowired
	private UserRepository userRepo;
	
	 @GetMapping("")
	    public String home() {
	        return "homepage";
	    }
	 
	 @GetMapping("/register")
		public String showRegistrationForm(Model model) {
			model.addAttribute("user", new User());
			
			return "signup";
		}
	 
	 
		
		@PostMapping("/process_register")
		public String processRegister(User user) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			
			userRepo.save(user);
			
			return "registration_sucess";
		}
		
			@GetMapping("/users")
	    public String user() {
	        return "index";
	    }

		

}