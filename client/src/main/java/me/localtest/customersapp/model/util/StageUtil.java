package me.localtest.customersapp.model.util;

import java.io.IOException;

import me.localtest.customersapp.controllers.CustomerPhonesController;
import me.localtest.customersapp.controllers.EditCustomerController;
import me.localtest.customersapp.controllers.MainController;
import me.localtest.customersapp.controllers.NewCustomerController;
import me.localtest.customersapp.views.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Gus Garsaky
 */
public class StageUtil {
	
    public static Stage loadNewCustomer(final MainController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {
            final FXMLLoader LOADER = new FXMLLoader();
            LOADER.setLocation(Main.class.getResource("NewCustomer.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Nuevo cliente");
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("img/ico.png")));
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            NewCustomerController newCustomerController = LOADER.getController();
            newCustomerController.setFatherGUI(FATHER);
        } catch (IOException e) {
            e.getMessage();
        }
        
        return stage;
    }
    public static Stage loadEditCustomer(final MainController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {
        	final FXMLLoader LOADER = new FXMLLoader();
        	LOADER.setLocation(Main.class.getResource("EditCustomer.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Editar cliente");
            stage.getIcons().add(new Image(Main.class.getResourceAsStream("img/ico.png")));
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            EditCustomerController editCustomerController = LOADER.getController();
            editCustomerController.setFatherGUI(FATHER);
        } catch (IOException e) {
            e.getMessage();
        }
        
        return stage;
    }
    public static Stage loadCustomerPhones(final MainController FATHER, final Modality MODALITY) {
    	Stage stage = new Stage();
    	try {
    		final FXMLLoader LOADER = new FXMLLoader();
    		LOADER.setLocation(Main.class.getResource("CustomerPhones.fxml"));
    		AnchorPane root = (AnchorPane) LOADER.load();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("Teléfonos del cliente");
    		stage.getIcons().add(new Image(Main.class.getResourceAsStream("img/ico.png")));
    		stage.initModality(MODALITY);
    		stage.setResizable(false);
    		stage.sizeToScene();
    		CustomerPhonesController customerPhonesController = LOADER.getController();
    		customerPhonesController.setFatherGUI(FATHER);
    		customerPhonesController.retrievePhones();
    	} catch(IOException e) {
    		e.getMessage();
    	}
    	
    	return stage;
    }
}
