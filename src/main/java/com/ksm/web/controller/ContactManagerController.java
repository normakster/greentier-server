//package com.ksm.web.controller;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//public class ContactManagerController {
//	
//	@Resource(name="contactService")
////	 private ContactService contactService;
//
//	@RequestMapping(value = { "/apps/cm**" }, method = RequestMethod.GET)
//	public ModelAndView defaultPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Contact Manager");
//////		Element div = new Element(Tag.valueOf("div"),"");
////		String[] links = {tagWrap("a","../","href='../'"), tagWrap("a","","href=''")};
////		model.addObject("nav", buildNavLinks(
//////				"../, Contact Manager"
////				links
////				));
//		model.setViewName("contactManager/contactManager");
//		return model;
//
//	}
//	
////	@ModelAttribute("contacts")
////	 public List<Contact> getAllContacts() {
//////	  logger.debug("Retrieving all contacts and adding it to ModelAttribute");
////	   
////	  // Delegate to ContactService
////	  return contactService.getAll();
////	 }
////	
////	@ModelAttribute("apps")
////	public ArrayList<ArrayList<String>> getAppList() {
////		
////		String[] app = new String[2];
////		return null;
////	}
////	
////	private String buildNavLinks(String... links) {
////		// print("<%s>", link.tagName(),link.attr("abs:href"));
////		String builtLinks = "";
//////		builtLinks += "<ul>";
//////		String[] links = args.split(", ");
////		for (String link : links) {
////			builtLinks += tagWrap("li",link);
//////			builtLinks += "<li>" + link + "</li>";
////		}
//////		builtLinks += "</ul>";
//////		return builtLinks;
////		return tagWrap("ul",builtLinks);
////	}
////
////	
////	@ModelAttribute("buildNavLinks")
////	private String buildNavLinks() {
////		String[] links = {"a","b"};
////		String builtLinks = "";
////		for (String link : links) {
////			builtLinks += tagWrap("li",link);
////		}
////		return tagWrap("ul",builtLinks);
////	}
////	
////	private String tagWrap(String tag, String inner) {
////		return "<"+tag+">"+inner+"</"+tag+">";
////	}
////	
////	private String tagWrap(String tag, String inner, String attr) {
////		return "<"+tag+" "+attr+">"+inner+"</"+tag+">";
////	}
//////
//////	private static void print(String msg, Object... args) {
//////		System.out.println(String.format(msg, args));
//////	}
////
////	private String[] build(String args) {
////		String builtLinks = "";
////		// builtLinks += "<ul>";
////		String[] links = args.split(", ");
////		for (String link : links) {
////			builtLinks += "<li>" + link + "</li>";
////		}
////		// builtLinks += "</ul>";
////		return links;
////
////	}
//
//}