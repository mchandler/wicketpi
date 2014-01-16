package com.zonkware.wicketpi.page;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class IndexPage extends WebPage {

	private static final long serialVersionUID = 1L;
	private final GpioController gpio = GpioFactory.getInstance();
	private GpioPinDigitalOutput pin;
	
	public IndexPage() {
		add(new Label("headerTitle", "Welcome to Wicket Pi"));
		add(new Label("headerText", "Enjoy some fun by selecting some buttons below..."));
		
		AjaxFallbackLink<String> ajaxLink = new AjaxFallbackLink<String>("ajaxLink"){

			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				toggleLed();
			}
		};
		
		add(ajaxLink);
		
		ajaxLink.add(new Label("ajaxLinkLabel","[LED Toggle]"));
	}
	
	public void toggleLed() {
		if (pin == null) {
			pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
		} else {
			pin.toggle();
		}
	}

}
