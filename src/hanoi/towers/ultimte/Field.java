/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoi.towers.ultimte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author rasamog
 */
public class Field {
    Pole[] poles;
    int height,colors;
    
    Field(int h,int c){
        height=h;
        colors=c;
        poles=new Pole[c+3];
        for(int i=0;i<=c;i++){
            poles[i]=new Pole(h,i);
        }
        poles[c+2]=new Pole(h,-1);
        poles[c+1]=new Pole(h,-1);
        ObservableList<Ring> rings=FXCollections.observableArrayList();
        for(int i=h;i>0;i--){
            for(int j=0;j<=c;j++){
                rings.add(new Ring(i,j));
            }
        }
        while(!rings.isEmpty()){
            Ring r=rings.remove(0);
            int x=(int) Math.round(Math.random()*(c+2));
            while(!poles[x].push(r)){
                x=(int) Math.round(Math.random()*(c+2));
            }
        }
    }
    
    boolean check(){
        for(Pole p:poles){
            if(!p.check()){
                return false;
            }
        }
        return true;
    }
}
