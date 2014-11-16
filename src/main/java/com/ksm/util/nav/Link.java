package com.ksm.util.nav;

public class Link implements Item {
	
	private String item = "";
	private String link = "";
	private String title = "";

	public Link(String title, String link) {
		this.link = link;
		this.title = title;
		build();
	}
	
	@Override
	public String get() {
		return this.item;
	}

	@Override
	public void build() {
		this.item += "<li><a href=\"" + this.link + "\">" + this.title + "</a></li>";
	}

//	private String item(String link, String title) {
//		String a = "";
//		a += "<li><a href=\"" + link + "\">" + title + "</a></li>";
//
//		// <li class=\"divider\"></li>
//		// <li class=\"dropdown-header\">Nav header</li>
//		return a;
//	}
}
