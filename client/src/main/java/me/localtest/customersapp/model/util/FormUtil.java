package me.localtest.customersapp.model.util;

import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 *
 * @author Gustavo García
 */
public class FormUtil {
    
    public static Boolean isValid(Node... nodes) {
        Boolean isValid = true;
        for(Node node : nodes) {
            if(node instanceof TextField) {
                TextField textfield = (TextField) node;
                if(textfield.getText().isEmpty())
                    isValid = false;
            }
        }
        
        return isValid;
    }
}
