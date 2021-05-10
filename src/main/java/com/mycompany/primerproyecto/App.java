package com.mycompany.primerproyecto;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        String fxml = "primary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        scene = new Scene(fxmlLoader.load(), 640, 480);
        stage.setScene(scene);
        stage.show();
  
        // Give the controller access to the main app.
        PrimaryController controller = fxmlLoader.getController();
        controller.loadImage();
    }
    /*public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }*/
    
    static void loadImage2() throws IOException {
        String fxml = "secondary";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        SecondaryController controller = new SecondaryController();
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.loadImage();
    }
   
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    static void loadMercado() throws IOException, SQLException {
        String fxml = "mercado";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        MercadoController controller = new MercadoController();
        fxmlLoader.setController(controller);
        
        scene.setRoot(fxmlLoader.load());
        controller.relleno();
    }
    static void loadOpciones() throws IOException {
        String fxml = "opciones";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        OpcionesController controller = new OpcionesController();
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.loadImage1();
    }
    static void loadAdmin() throws IOException {
        String fxml = "admin";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        AdminController controller = new AdminController();
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.loadImage();
    }
    static void loadMercadoAdmin() throws IOException, SQLException {
        String fxml = "mercadoAdmin";
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        // Give the controller access to the main app.
        mercadoAdminController controller = new mercadoAdminController();
        fxmlLoader.setController(controller);
        scene.setRoot(fxmlLoader.load());
        controller.relleno();
    }
}