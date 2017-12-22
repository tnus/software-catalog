package de.nuss.software.catalog.software;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.nuss.software.catalog.about.AboutView;
import de.nuss.vaadin.addon.components.counter.Counter;

@SpringView(name = SoftwareView.ID)
public class SoftwareView extends VerticalLayout implements View {
	public static final String ID = "software";

	public SoftwareView() {
		addComponent(new Label("Software"));

		Button btnNav = new Button("navigate to about", c -> {
			UI.getCurrent().getNavigator().navigateTo(AboutView.ID);
		});
		addComponent(btnNav);

		Counter counterTotal = new Counter(23212);
		addComponent(counterTotal);
	}
}
