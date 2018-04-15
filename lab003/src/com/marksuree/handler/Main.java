package com.marksuree.handler;

import com.marksuree.flowers.Rose;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * This is the Main class, which contains main method (for java start) and start method (for javaFX start).
 */

public class Main extends Application {

    /**
     * This method calls createGUI.
     * @param primaryStage This parameter is Main frame
     */
    @Override
    public void start(Stage primaryStage) {
       primaryStage = createGUI();
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method creates logic for app. It checks combobox, calls methods for them and change label's text.
     * @param arrStr this parameter  includes all strings in combobox
     * @param action this parameter is the user's choice
     * @param result this parameter is label, which text we must change
     */
    private void createLogic(String arrStr[], String action, Label result)
    {
        if(action.equals(arrStr[1]))
        {
           result.setText(Human.getInstance().plantAFlower(new Rose()));
           result.setVisible(true);
        }
       else if(action.equals(arrStr[0]))
       {
           result.setText(Human.getInstance().waterTheFlowers());
           result.setVisible(true);
       }
       else if(action.equals(arrStr[2]))
        {
            result.setText(Human.getInstance().smellTheFlowers());
            result.setVisible(true);
        }
    }


    /**
     * Method for GUI creation and manage layouts.
     * @return Stage this parameter define frame
     */
    private Stage createGUI()
    {
        Stage primaryStage = new Stage();

        Label whatDoing = new Label("Что делаем?");
        Label result = new Label("default");
        result.setVisible(false);

        String[] arrStr = new String[3];
        arrStr[0] = "Полить розу";
        arrStr[1] = "Посадить розу";
        arrStr[2] = "Понюхать розу";
        ObservableList<String> options =
                FXCollections.observableArrayList(
                        arrStr[1],
                        arrStr[0],
                        arrStr[2]
                );
       final ComboBox comboBox = new ComboBox(options);

        Button doing = new Button("Делать!");

        doing.setOnAction((ActionEvent e) ->
        {
            try
            {
                String action = comboBox.getValue().toString();
                createLogic(arrStr, action, result);
            }
            catch (NullPointerException nullptrex)
            {
                result.setText("Выберите то, что хотите (или не хотите) сделать");
                result.setVisible(true);
            }
        });

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(30);
        hbox.getChildren().addAll(whatDoing, comboBox, doing);

        BorderPane border = new BorderPane();
        border.setCenter(result);

        GridPane grid = new GridPane();
        grid.add(hbox, 0, 0);
        grid.add(border, 0, 1);

        primaryStage.setTitle("Flowers interaction");
        primaryStage.setScene(new Scene(grid, 380, 100));
        primaryStage.show();
        return primaryStage;
    }
}
