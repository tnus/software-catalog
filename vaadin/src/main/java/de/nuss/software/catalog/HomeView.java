package de.nuss.software.catalog;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.nuss.software.catalog.about.AboutView;

@SpringView(name = HomeView.ID)
public class HomeView extends VerticalLayout implements View {
	public static final String ID = "";

	public HomeView() {
		addComponent(new Label("Home"));

		Button btnNav = new Button("navigate to about", c -> {
			UI.getCurrent().getNavigator().navigateTo(AboutView.ID);
		});
		addComponent(btnNav);
	}
}
