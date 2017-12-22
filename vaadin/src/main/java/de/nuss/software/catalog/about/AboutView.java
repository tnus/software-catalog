package de.nuss.software.catalog.about;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.nuss.software.catalog.software.SoftwareView;

@SpringView(name = AboutView.ID)
public class AboutView extends VerticalLayout implements View {
	public static final String ID = "about";

	public AboutView() {
		addComponent(new Label("About"));

		Button btnNav = new Button("navigate to software", c -> {
			UI.getCurrent().getNavigator().navigateTo(SoftwareView.ID);
		});
		addComponent(btnNav);
	}
}
