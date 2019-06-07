package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        // GridPane center
//        Parent root = FXMLLoader.load(getClass().getResource("sample1.fxml"));
        // GridPane top_center
//        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        // HBox
//        Parent root = FXMLLoader.load(getClass().getResource("sample3.fxml"));
        // BorderPane
//        Parent root = FXMLLoader.load(getClass().getResource("sample4.fxml"));
        // AnchorPane
//        Parent root = FXMLLoader.load(getClass().getResource("sample5.fxml"));
        // FlowPane
//        Parent root = FXMLLoader.load(getClass().getResource("sample6.fxml"));
        // TilePane
//        Parent root = FXMLLoader.load(getClass().getResource("sample7.fxml"));
        // StackPane
        Parent root = FXMLLoader.load(getClass().getResource("sample8.fxml"));


        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
