package com.zonkware.wicketpi.config;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.zonkware.wicketpi.page.IndexPage;

public class WicketPi extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return IndexPage.class;
	}

}
