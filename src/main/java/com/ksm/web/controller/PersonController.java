package com.ksm.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ksm.person.model.PersonEntity;
import com.ksm.person.service.PersonManager;
import com.ksm.util.nav.*;

@Controller
@RequestMapping(value = { "/contacts" })
public class PersonController {
	
	private String msg;

	@Autowired
	private PersonManager personManager;

	@RequestMapping(value = { "", "/" })
	public String listpersons(ModelMap map) {
		map.addAttribute("person", new PersonEntity());
		map.addAttribute("personList", personManager.getAllPersons());
		map.addAttribute("title", "Contact Manager");
		map.addAttribute("message", msg);
		map.addAttribute("nav", navbar());
		this.msg = "";
		return "contacts";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET, params = { "save" })
	public String addPerson(
			@ModelAttribute(value = "person") PersonEntity person,
			BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "redirect:";
		}
		this.personManager.addPerson(person);
		model.clear();
		this.msg = "Person Saved";
		return "redirect:";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editPerson(
			@RequestParam(value = "personId", required = true) int personId,
			@RequestParam(value = "firstname", required = true) String firstname,
			@RequestParam(value = "lastname", required = true) String lastname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "cellphone", required = true) String cellphone,
			@RequestParam(value = "homephone", required = true) String homephone
//			, BindingResult bindingResult
//			, ModelMap model
			) {
//		if (bindingResult.hasErrors()) {
//			return "redirect:";
//		}
		PersonEntity person = this.personManager.getPerson(personId);
		person.setFirstname(firstname);
		person.setLastname(lastname);
		person.setEmail(email);
		person.setCellphone(cellphone);
		person.setHomephone(homephone);
		
		this.personManager.editPerson(person);
//		model.clear();
		this.msg = "Person Edited";
		return "redirect:";
	}

	@RequestMapping(value = { "/delete" }, method = RequestMethod.POST)
	public String deletePerson(
			@RequestParam(value = "personId", required = true) int personId) {
		personManager.deletePerson(personId);
		this.msg = "Person Deleted";
		return "redirect:";
	}
	
	private String navbar() {
		List<Item> navbarItems = new ArrayList<Item>();
		navbarItems.add(new Link("Home","\\"));
		navbarItems.add(new Link("Person","\\persons"));
		navbarItems.add(new Link("About","\\about"));
		
		Item navbar = new Navbar("KSM",navbarItems);
		return navbar.get();
	}

}
