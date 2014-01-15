package com.zonkware.wicketpi.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class IndexPage extends WebPage {

	private static final long serialVersionUID = 1L;
	
	public IndexPage() {
		add(new Label("headerTitle", "Welcome to Wicket Pi"));
		add(new Label("headerText", "Enjoy some fun by selecting some buttons below..."));
	}

}
