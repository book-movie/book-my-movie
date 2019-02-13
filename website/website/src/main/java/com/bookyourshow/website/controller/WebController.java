package com.bookyourshow.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.bookyourshow.website.entity.Profile;

//@EnableOAuth2Sso
@Controller
public class WebController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/")
	public String form() {
		return "Index";
	}

	@RequestMapping("/addProfile")
	public String createProfile(Model model) {
		model.addAttribute("profile", new Profile());
		return "CreateProfile";
	}

	@RequestMapping("/add")
	public String create(@ModelAttribute Profile profile, Model model) {
		restTemplate.postForEntity("http://localhost:5062/profiles", profile, null); 
		//System.out.println(profile);
		model.addAttribute("message", "Your profile has been successfully created....!!!!");
		//model.addAttribute("profile", new Profile());
		return "CreateProfile";
	}

	@RequestMapping("/deleteProfile")
	public String deleteProfile() {
		return "DeleteProfile";
	}

	@RequestMapping("/delete")
	public String delete(@ModelAttribute Profile profile, Model model) {
		restTemplate.postForEntity("http://localhost:5062/profiles/deleteProfile", profile, null);
		model.addAttribute("message", "Your profile has been successfully deleted....!!!!");
		return "DeleteProfile";
	}

	/**
	 * Refresh the underlying {@link ApplicationContext}.
	 * 
	 * @param applicationContext the application context to refresh
	 *//*
		 * protected void refresh(ApplicationContext applicationContext) {
		 * Assert.isInstanceOf(AbstractApplicationContext.class, applicationContext);
		 * ((AbstractApplicationContext) applicationContext).refresh(); }
		 */
}
