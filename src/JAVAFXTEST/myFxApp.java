package JAVAFXTEST;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;

public class myFxApp extends Application{

    Stage window;
    Scene loginScreen, afterLogin, newScene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        window = primaryStage;

        VBox login = new VBox();
        login.setSpacing(20);
        login.setPadding(new Insets(50));
        login.setAlignment(Pos.CENTER);

        HBox username = new HBox();
        username.setSpacing(10);
        username.setAlignment(Pos.CENTER);

        Label un = new Label("Username");
        TextField unf = new TextField();
        unf.setPrefWidth(150);
        unf.setPromptText("John Doe");

        username.getChildren().add(un);
        username.getChildren().add(unf);

        HBox password = new HBox();
        password.setSpacing(10);
        password.setAlignment(Pos.CENTER);

        Label pw = new Label("Password");
        PasswordField pwf = new PasswordField();
        pwf.setPrefWidth(150);
        pwf.setPromptText("Password");

        Button loginB = new Button("Login");
        loginB.setPrefWidth(200);
        loginB.setCursor(Cursor.HAND);
        if(pwf.getText().equals(123)){
        }
        //loginB.setOnAction(e -> window.setScene(afterLogin));
        loginB.setOnAction(e -> {
            System.out.println("The Hyperlink was clicked!" + unf.getText());
            String user = unf.getText();
            if (user.equals("123")) {
                window.setScene(afterLogin);
            }
        });

        Button openNewWindow = new Button("Open new window");
        openNewWindow.setPrefWidth(200);
        openNewWindow.setCursor(Cursor.HAND);
        openNewWindow.setOnAction(ActionEvent -> {

            Stage newWindow = new Stage();

            Label modal = new Label("I am a label in a modal window");
            Button close = new Button("Close modal");
            close.setOnAction(closeWindow -> {
                newWindow.close();
            });

            VBox newScreen = new VBox();
            newScreen.setAlignment(Pos.CENTER);
            newScreen.setSpacing(10);
            newScreen.getChildren().add(modal);
            newScreen.getChildren().add(close);

            newScene = new Scene(newScreen, 250, 100);

            newWindow.setTitle("Second Window");
            newWindow.setScene(newScene);

            newWindow.centerOnScreen();

            newWindow.show();
        });

        password.getChildren().add(pw);
        password.getChildren().add(pwf);

        login.getChildren().add(username);
        login.getChildren().add(password);
        login.getChildren().add(loginB);
        login.getChildren().add(openNewWindow);

        VBox loggedin = new VBox();
        loggedin.setSpacing(20);
        loggedin.setPadding(new Insets(50));
        loggedin.setAlignment(Pos.CENTER);

        Label successText = new Label("You are successfully logged in!");
        Button goBack = new Button("Log out");
        goBack.setPrefWidth(200);
        goBack.setCursor(Cursor.HAND);
        goBack.setOnAction(e -> window.setScene(loginScreen));
        goBack.setStyle("-fx-background-color: #e74c3c;");

        loggedin.getChildren().add(successText);
        loggedin.getChildren().add(goBack);


        afterLogin = new Scene(loggedin, 550, 550);
        loginScreen = new Scene(login, 550, 550);

        window.setTitle("First Window");
        window.setScene(loginScreen);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}