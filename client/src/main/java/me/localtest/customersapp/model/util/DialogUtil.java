package me.localtest.customersapp.model.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Gus Garsaky
 */
public class DialogUtil {
    
    public static Alert buildSimpleDialog(String title, String header, String body, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(body);
        return alert;
    }
    public static Alert buildConfirmationDialog(String title, String header, String body) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(body);
        return alert;
    }
    public static Alert buildExceptionDialog(String title, String header, Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        Label label = new Label("El rastreo de pila es:");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        TextArea traceArea = new TextArea(sw.toString());
        traceArea.setEditable(false);
        traceArea.setWrapText(true);
        traceArea.setMaxWidth(Double.MAX_VALUE);
        traceArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(traceArea, Priority.ALWAYS);
        GridPane.setHgrow(traceArea, Priority.ALWAYS);
        GridPane content = new GridPane();
        content.setMaxWidth(Double.MAX_VALUE);
        content.add(label, 0, 0);
        content.add(traceArea, 0, 1);
        alert.getDialogPane().setExpandableContent(content);
        return alert;
    }
    public static TextInputDialog buildInputDialog(String title, String header, String body) {
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle(title);
    	dialog.setHeaderText(header);
    	dialog.setContentText(body);
    	return dialog;
    }
}