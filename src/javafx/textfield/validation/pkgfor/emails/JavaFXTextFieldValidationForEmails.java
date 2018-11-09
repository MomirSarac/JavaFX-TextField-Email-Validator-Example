/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.textfield.validation.pkgfor.emails;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 *
 * @author Momir Sarac
 */
public class JavaFXTextFieldValidationForEmails extends Application {
   
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label();
        Button btn = new Button();
        btn.setText("Validate!");
        TextField textField = new TextField();
        textField.setPromptText("Please, input a valid email address.");
        
        textField.focusedProperty().addListener((v, oldValue, newValue)
                -> {
            if (!newValue) // if focus lost
            {
                if (!textField.getText().matches("^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@+[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$")) {
                    label.setText("Please, input only a valid email address. ");
                } else {
                    label.setText("Awesome! Your email address is: \n" + textField.getText());
                }
            }
        });

        VBox root = new VBox();
        HBox firstRow = new HBox();
        firstRow.setSpacing(10);
        HBox secondRow = new HBox();
        secondRow.setSpacing(10);

        firstRow.getChildren().addAll(textField, btn);
        firstRow.setAlignment(Pos.CENTER);
        firstRow.setPadding(new Insets(10));
        secondRow.getChildren().addAll(label);
        secondRow.setAlignment(Pos.CENTER);
        secondRow.setPadding(new Insets(10));
        root.getChildren().addAll(firstRow, secondRow);

        Scene scene = new Scene(root, 350, 100);

        primaryStage.setTitle("JavaFX Input TextField Validator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
