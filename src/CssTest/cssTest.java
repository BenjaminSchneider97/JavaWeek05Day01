package CssTest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.awt.*;

public class cssTest extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{

        String styles1 = "-fx-background-color: #686de0;" + "-fx-border-color: #4834d4;" ;
        String styles2 = "-fx-background-color: #e056fd;" + "-fx-border-color: #be2edd;" ;

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        button1.setStyle(styles1);
        button1.setCursor(Cursor.NONE);

        button2.setStyle(styles2);
        button2.setCursor(Cursor.MOVE);

        VBox root = new VBox(button1, button2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(50));
        root.setSpacing(10);
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}