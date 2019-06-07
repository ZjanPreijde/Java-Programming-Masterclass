package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.util.Optional;

public class Controller {
    @FXML
    private TextField firstName, lastName, fullName;
    @FXML
    private Button helloButton;
    @FXML
    private CheckBox cbClear;
    @FXML
    private Label lblProgress;

    public void initialize() {
        firstName.setText( "" );
        setFullName();
    }

    @FXML
    public void handleClick( ActionEvent event) {
//        System.out.println( event.getEventType() );
//        System.out.println(event.getSource().getClass());
        Control control = (Control) event.getSource();
//        System.out.println(control.getTypeSelector());
        lblProgress.setText( "Standing by" );
        if (control.equals(cbClear)) {

            lblProgress.setText( "Task running in background ..." );
            try {Thread.sleep(100);} catch(InterruptedException excEvent) { /**/ }

            Runnable task = new Runnable() {
                @Override
                public void run() {
                    try {
                        String s = (Platform.isFxApplicationThread() ? "UI" : "Background") + " thread";
                        System.out.println("Sleeping on the " + s);
                        System.out.println("Sleeping for 5 seconds... ");
                        Thread.sleep(5000);
                        System.out.println("Woke up!");
                        Platform.runLater( new Runnable() {
                            @Override
                            public void run() {
                                String s = (Platform.isFxApplicationThread() ? "UI" : "Background") + " thread";
                                System.out.println("Completing on the " + s);
                                lblProgress.setText( "Task completed" );
                            }
                        } );
                    } catch(InterruptedException excEvent) {
                        // I don't care!
                    }
                }
            };

            new Thread(task).start();

            System.out.println("CheckBox clicked");
            System.out.println("Current state : " + (cbClear.isSelected() ? "" : "un") + "checked");
            return;
        }


        Button pressedButton = (Button) control;
//        System.out.println("Text pressed button : " + pressedButton.getText());

        System.out.println();
        switch (pressedButton.getId()) {
            case "helloButton" :
                System.out.println("Hello there" + fullName.getText() + "!");
                if (cbClear.isSelected()) {
                    clearNames();
                }
                break;
            case "byeButton" :
                System.out.println("Bye bye, CUL8R!");
                break;
            default:
                System.out.println("Unknown button pressed (" + pressedButton.getText() + ")");
                break;
        }
        if ( pressedButton.isDefaultButton() ) {
            System.out.println("You pressed the default button");
        } else
        if ( pressedButton.isCancelButton() ) {
            System.out.println("You pressed the cancel button");
            Platform.exit();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (fullName.getText().isEmpty()) {
                alert.setHeaderText("I am not sure who you are");
            } else {
                alert.setHeaderText("You are " + fullName.getText());
            }
//            alert.getButtonTypes().setAll( ButtonType.YES, ButtonType.NO, ButtonType.CANCEL); /*  */
//            Optional <ButtonType> result = alert.showAndWait();
            alert.showAndWait();
        }
    }
    @FXML
    public void handleKeyTyped( KeyEvent event) {
//        System.out.println( event.getEventType() );
//        System.out.println( "Character : " + event.getCharacter());
//        System.out.println( "Code : " + event.getCode()); only for key pressed/released events
        lblProgress.setText( "Standing by" );
        setFullName();
    }

    private void clearNames() {
        firstName.setText( "" );
        lastName.setText( "" );
        setFullName();
    }

    private void setFullName() {
        fullName.setText(
                (" " + firstName.getText()).stripTrailing()
              + (" " + lastName.getText()).stripTrailing()
        );
        helloButton.setDisable( fullName.getText().isEmpty() );
    }
}
