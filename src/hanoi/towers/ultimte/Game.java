/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi.towers.ultimte;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author rasamog
 */
public class Game {
    
    static Ring using=null;
    static Field field;
    
    public static void start(final Stage primaryStage,int colors,int height) {
        Pane root = new Pane();
        field=new Field(height,colors);
        
        for(int i=0;i<field.poles.length;i++){
            Rectangle r = new Rectangle();
            r.setX(60+i*110);
            r.setY(10);
            r.setWidth(10);
            r.setHeight(100);
            r.setFill(field.poles[i].color);
            root.getChildren().add(r);
            
            final int no=i;
            
            Button b = new Button();
            b.setLayoutY(130);
            b.setLayoutX(i*110+30);
            b.setText("use");
            b.setMaxWidth(70);
            b.setMinWidth(70);
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    field=use(no,field);
                    play(primaryStage);
                }
            });
            root.getChildren().add(b);
            
            for(int j=0;j<field.poles[i].size;j++){
                if(field.poles[i].rings[j]!=null){
                    Rectangle r1 = new Rectangle();
                    r1.setX(65+i*110-field.poles[i].rings[j].size*5-5);
                    r1.setY(100-10*j);
                    r1.setWidth(field.poles[i].rings[j].size*10+10);
                    r1.setHeight(10);
                    r1.setFill(field.poles[i].rings[j].color);
                    root.getChildren().add(r1);
                }
            }
        
        }
        
        Scene scene = new Scene(root, 1000, 300);
        primaryStage.setTitle("Hanoi towers ultimate");
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }
    
    public static Field use(int i,Field f){
        if(using==null){
            if(f.poles[i].used>0){
                using=f.poles[i].pop();
            }
        }else{
            if(f.poles[i].push(using)){
                if(f.check()){
                    System.out.println("VICTORY");
                }
                using=null;
            }
        }
        return f;
    
    }
    
    public static void play(final Stage primaryStage){
        Pane root=new Pane();
        for(int i=0;i<field.poles.length;i++){
            Rectangle r = new Rectangle();
            r.setX(60+i*110);
            r.setY(10);
            r.setWidth(10);
            r.setHeight(100);
            r.setFill(field.poles[i].color);
            root.getChildren().add(r);
            
            final int no=i;
            
            Button b = new Button();
            b.setLayoutY(130);
            b.setLayoutX(i*110+30);
            b.setText("use");
            b.setMaxWidth(70);
            b.setMinWidth(70);
            b.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    field=use(no,field);
                    play(primaryStage);
                }
            });
            root.getChildren().add(b);
            
            for(int j=0;j<field.poles[i].size;j++){
                if(field.poles[i].rings[j]!=null){
                    Rectangle r1 = new Rectangle();
                    r1.setX(65+i*110-field.poles[i].rings[j].size*5-5);
                    r1.setY(100-10*j);
                    r1.setWidth(field.poles[i].rings[j].size*10+10);
                    r1.setHeight(10);
                    r1.setFill(field.poles[i].rings[j].color);
                    root.getChildren().add(r1);
                }
            }
        
        }
        
        Scene scene = new Scene(root, 1000, 300);
        primaryStage.setTitle("Hanoi towers ultimate");
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
    }
    
}
