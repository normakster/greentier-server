package com.ksm.util.nav;

import java.util.List;

public class Dropdown implements Item {
	
	private String title = "";
	private String dropdown = "";
	private List<Item> items;
	
	public Dropdown(String title, List<Item> items) {
		this.title = title;
		this.items = items;
		build();
	}
	
	@Override
	public String get() {
		return this.dropdown;
	}

	@Override
	public void build() {
		this.dropdown += "<li class=\"dropdown\"><a href=\"#\" class=\"dropdown-toggle\" ";
		this.dropdown += "data-toggle=\"dropdown\">" + this.title + "<span class=\"caret\"></span></a>";
		this.dropdown += "<ul class=\"dropdown-menu\" role=\"menu\">";
		
		for (Item item : items) {
			this.dropdown += item.get();
		}
		
		this.dropdown += "</ul></li>";
	}
}
