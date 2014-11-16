package com.ksm.util.nav;

import java.util.List;

public class Navbar implements Item {

	private String navbar = "";
	@SuppressWarnings("unused")
	private String title = "";
	private List<Item> items;

	public Navbar(String title, List<Item> items) {
		this.title = title;
		this.items = items;
		build();
	}

	@Override
	public String get() {
		return this.navbar;
	}

	@Override
	public void build() {
//		this.navbar += "<ul id=\"dynamicNavbar\" class=\"nav navbar-nav\">";

		for (Item item : items) {
			this.navbar += item.get();
		}

//		this.navbar += "</ul>";
//		this.navbar += "<ul class=\"navnavbar-navnavbar-right\">" + "<li>"
//				+ "<div th:include=\"layout::currentUser\"></div>" + "</li>" + "</ul>";
	}
}
