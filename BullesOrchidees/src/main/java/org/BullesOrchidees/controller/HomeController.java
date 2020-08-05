package org.BullesOrchidees.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.BullesOrchidees.model.User;
import org.BullesOrchidees.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String showIndexPage() {
		return "redirect:/index";
	}
	
	@GetMapping("/loginUser")
	public String showLoginPage() {
		return "Login";
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
		User user = userService.findByEmail(email);
		session.setAttribute("currentUser", user);
		return "redirect:/HomePageFilter";
	}
	
	@GetMapping("/homePage")
	public String showHomePage() {
		return "HomePage";
	}
	
	@GetMapping("/HomePageFilter")
	public String showHomePageFilter() {
		return "HomePageFilter";
	}
	
	@GetMapping("services/corporate-events")
	public String showCorporateEvents() {
		return "services/corporate-events";
	}
	
	@GetMapping("services/private-events")
	public String showprivatepvents() {
		return "services/private-events";
	}
	
	@GetMapping("services/mariage-civil")
	public String showmariagecivil() {
		return "services/mariage-civil";
	}
	
	@GetMapping("services/service-chictradi")
	public String showServicechictradi() {
		return "services/service-chictradi";
	}
	
	@GetMapping("services/event-weddingPlanner")
	public String showServiceEventweddingPlanner() {
		return "services/event-weddingPlanner";
	}
	
	
	@GetMapping("/aboutPage")
	public String showAboutPage() {
		return "AboutPage";
	}
	
	@GetMapping("newUserForm")
	public String newUserForm(Model model) {
		model.addAttribute("newUser", new User());
		return "NewUserForm";
	}
	
	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "NewUserForm";
		}
		userService.createUser(newUser);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "forward:/";
	}
	
	@GetMapping("admin/adminPage")
	public String showAdminPage() {
		return "BullesAdminPage";
	}
}