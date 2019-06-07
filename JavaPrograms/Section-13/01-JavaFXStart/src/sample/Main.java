package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        if (false) {
//            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        } else {
            GridPane root = new GridPane();
            root.setAlignment( Pos.CENTER );
            root.setVgap( 10 );
            root.setHgap( 10 );
//        }

//        System.out.println(getClass().getName());
//        System.out.println(getClass().getResource("sample.fxml"));

        Label greeting = new Label("Welcome to JavaFX!");
        greeting.setTextFill( Color.GREEN );
        greeting.setFont( Font.font("Times New Roman", FontWeight.BOLD, 70));
        root.getChildren().add( greeting );


        primaryStage.setTitle("Hello JavaFX!");
        primaryStage.setScene(new Scene(root, 900, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
