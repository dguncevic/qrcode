package com.mycompany.qrcode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.layout.AnchorPane;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
       
        FXMLLoader loader = new FXMLLoader(App.class.getResource("primary.fxml"));
        AnchorPane pane = loader.load();
        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}