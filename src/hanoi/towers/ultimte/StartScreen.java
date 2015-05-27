/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi.towers.ultimte;

import static hanoi.towers.ultimte.Game.field;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rasamog
 */
public class StartScreen extends Application {
    
    
    
    @Override
    public void start(final Stage primaryStage) {
        Pane root = new Pane();
        
        Button exit = new Button();
        exit.setText("exit");
        exit.setLayoutY(150);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        root.getChildren().add(exit);
        
        Text colorinfo=new Text();
        colorinfo.setText("colors: 0-5");
        colorinfo.setLayoutY(10);
        root.getChildren().add(colorinfo);
        
        final TextField color=new TextField();
        color.setLayoutY(20);
        color.setText("0");
        root.getChildren().add(color);
        
        Text heightinfo=new Text();
        heightinfo.setText("height: 1-8");
        heightinfo.setLayoutY(60);
        root.getChildren().add(heightinfo);
        
        final TextField height=new TextField();
        height.setLayoutY(70);
        height.setText("1");
        root.getChildren().add(height);
        
        Button play = new Button();
        play.setText("play");
        play.setLayoutY(100);
        play.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                int c=Integer.parseInt(color.getText());
                int h=Integer.parseInt(height.getText());
                if(c<0){c=0;}if(c>5){c=5;}
                if(h<1){h=1;}if(h>8){h=8;}
                Game.start(primaryStage,c,h);
            }
        });
        root.getChildren().add(play);
        
        
        Scene scene = new Scene(root, 300, 200);
        
        primaryStage.setTitle("Hanoi towers ultimate");
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
