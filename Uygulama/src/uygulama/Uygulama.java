/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uygulama;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author simay
 */
public class Uygulama extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        //Creating a GridPane container
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        
        //Defining the KEY text field
        final TextField key = new TextField();
        key.setPromptText("Enter your key.");
        key.setPrefColumnCount(10);
        key.getText();
        GridPane.setConstraints(key, 0, 0);
        grid.getChildren().add(key);
        
        //Defining the PLAIN text field
        final TextField plain = new TextField();
        plain.setPromptText("Enter your plaintext | ciphertext.");
        GridPane.setConstraints(plain, 0, 1);
        grid.getChildren().add(plain);
        
        //Defining the RESULT text field
        final TextField result = new TextField();
        result.setPrefColumnCount(15);
        result.setPromptText("Result");
        GridPane.setConstraints(result, 0, 2);
        grid.getChildren().add(result);
        //Defining the ENCRYPT button
        Button encrypt = new Button("Encrypt ");
        GridPane.setConstraints(encrypt, 1, 0);
        grid.getChildren().add(encrypt);
        
        //Defining the CLEAR button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 1, 1);
        grid.getChildren().add(clear);
        
        //Defining the DECYRPT button
        Button decrypt = new Button("Decrypt ");
        GridPane.setConstraints(decrypt, 2, 0);
        grid.getChildren().add(decrypt);
        
        final  Label label = new Label();
        GridPane.setConstraints(label, 0, 3);
        GridPane.setColumnSpan(label, 2);
        grid.getChildren().add(label);
        
        //Setting an action for the ENCRYPT button
        encrypt.setOnAction(new EventHandler<ActionEvent>() {

        @Override
            public void handle(ActionEvent e) {
               VigenereCipher vigenere= new VigenereCipher();
               vigenere.encrypt(plain,key,result);
                         
             }
         });

        //Setting an action for the CLEAR button
        clear.setOnAction(new EventHandler<ActionEvent>() {

        @Override
            public void handle(ActionEvent e) {
                key.clear();
                plain.clear();
                result.clear();
                label.setText(null);
            }
        });
        
        //Setting an action for DECYRPT button
        decrypt.setOnAction(new EventHandler<ActionEvent>() {

        @Override
            public void handle(ActionEvent e) {
                VigenereCipher vigenere= new VigenereCipher();
               vigenere.decrypt(plain, key, result);
               
             }
         });
        // Creating SCENE       
        Scene scene = new Scene(grid, 350, 250);        
        primaryStage.setTitle("Vigenère Autokey System");
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
