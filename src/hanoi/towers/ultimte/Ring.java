/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi.towers.ultimte;

import javafx.scene.paint.Color;



/**
 *
 * @author rasamog
 */
public class Ring {
    int size;
    Color color;
    
    Ring(int s,int c){
        size=s;
        switch (c){
            case 0:color=Color.BLACK;break;
            case 1:color=Color.CHOCOLATE;break;
            case 2:color=Color.RED;break;
            case 3:color=Color.BLUE;break;
            case 4:color=Color.GREEN;break;
            case 5:color=Color.GOLD;break;
            default:break;
        }
    }
}
