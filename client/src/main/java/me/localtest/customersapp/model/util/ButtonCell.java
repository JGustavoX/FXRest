package me.localtest.customersapp.model.util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import me.localtest.customersapp.controllers.MainController;
import me.localtest.customersapp.domain.entities.CustomerTblModel;

public class ButtonCell extends TableCell<CustomerTblModel, Boolean> {
	private final StackPane pane = new StackPane();
	private final Button btnPhones = new Button("Teléfonos");

	public ButtonCell(final MainController FATHER, final Modality MODALITY) {
		pane.setPadding(new Insets(3));
		btnPhones.getStyleClass().add("btn-new");
		pane.getChildren().add(btnPhones);
		btnPhones.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				StageUtil.loadCustomerPhones(FATHER, MODALITY).showAndWait();
			}
		});
	}
	@Override
	protected void updateItem(Boolean item, boolean empty) {
		super.updateItem(item, empty);
		if(!empty) {
			setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			setGraphic(pane);
		} else {
			setText(null);
			setGraphic(null);
		}
	}
}