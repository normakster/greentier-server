//package com.ksm.web.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.ksm.person.model.PersonEntity;
//import com.ksm.person.service.PersonManager;
//
////@Controller
//public class EditPersonController {
//
//	@Autowired
//	private PersonManager personManager;
//
//	//  /apps/persons
//	@RequestMapping	(value = {"/","/editPersonList"}
////	, method = RequestMethod.GET
//			)
//	public String listPersons(ModelMap map) {
//		map.addAttribute("person", new PersonEntity());
//		map.addAttribute("personList", personManager.getAllPersons());
//		return "editPersonList";
//	}
//
////	@RequestMapping(value = "/add", method = RequestMethod.POST)
////	public String addPerson(
////			@ModelAttribute(value = "person") PersonEntity person,
////			BindingResult result) {
////		personManager.addPerson(person);
////		return "redirect:/";
////	}
//
////	@RequestMapping(value = "/add", method = RequestMethod.GET)
////	public String addPerson(
////			@ModelAttribute(value = "person") PersonEntity person,
////			BindingResult result,
////			ModelMap model) {
////		personManager.addPerson(person);
////		return "redirect:/";
////	}
//	
////	/* Sample code explaining different way to add a "Person" */
////	@RequestMapping(value="/add", params={"addPerson"})
////	public String addRow(final PersonEntity person, final BindingResult bindingResult, final HttpServletRequest req) {
////		
////		System.out.println("herehere"+req.getParameter("addPerson"));
//////	    person.getRows().add(new Row());
////	    return "redirect:/";
////	} 
//	
//	/* Sample code that is worked over to fit */
//    @RequestMapping(value="/editPersonList", method = RequestMethod.GET, params={"save"}
////    , method = RequestMethod.POST
//    		)
//    public String addPerson(
//    		@ModelAttribute(value = "person") PersonEntity person, 
//    		BindingResult bindingResult, 
//    		ModelMap model) {
//        if (bindingResult.hasErrors()) {
//            return "editPersonList";
//        }
//        this.personManager.addPerson(person);
//        model.clear();
//        return 
////        		"redirect:/" +
//        		"editPersonList";
//    }
//
//
//	@RequestMapping(value = "/editPersonList/delete/{personId}")
//	public String deleteEmplyee(
//			@PathVariable("personId") Integer personId
//			) {
////		personManager.deletePerson(personId);
////		return "redirect:/";
//		return "editPersonList";
//	}
//    
////@RequestMapping(value = "/editPersonList/remove/{personId}"
//////, params = { "removeRow" }
////)
////public String removeRow(
//////		PersonEntity person,
////		BindingResult bindingResult
//////		, HttpServletRequest req
////		) {
////	final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
////	person.getRows().remove(rowId.intValue());
////	return "editPersonList";
////}
////
////	/* Sample code explaining different way to remove a "Person" */
//    
//////	@RequestMapping(value = "/editPersonList", params = { "removeRow" })
//////	public String removeRow(final SeedStarter seedStarter,
//////			final BindingResult bindingResult, final HttpServletRequest req) {
//////		final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
//////		seedStarter.getRows().remove(rowId.intValue());
//////		return "editPersonList";
//////	}
//
//	public void setPersonManager(PersonManager personManager) {
//		this.personManager = personManager;
//	}
//
//}