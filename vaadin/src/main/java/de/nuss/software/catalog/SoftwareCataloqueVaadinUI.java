package de.nuss.software.catalog;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.PushStateNavigation;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import lombok.extern.slf4j.Slf4j;

@PushStateNavigation
@SpringUI
@Theme("valo")
@Slf4j
@SpringViewDisplay

public class SoftwareCataloqueVaadinUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		log.info("init vaadin ui");

		VerticalLayout content = new VerticalLayout();
		setContent(content);

		Label heading = new Label("Welcome");
		heading.addStyleName(ValoTheme.LABEL_H1);
		content.addComponent(heading);

		content.addComponent(new Label("Welcome to the software application"));

	}

}
