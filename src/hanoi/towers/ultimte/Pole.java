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
public class Pole {
    Ring[] rings;
    Color color;
    int size;
    int used;
    
    Pole(int s,int c){
        rings=new Ring[s];
        size=s;
        used=0;
        switch (c){
            case 0:color=Color.BLACK;break;
            case 1:color=Color.CHOCOLATE;break;
            case 2:color=Color.RED;break;
            case 3:color=Color.BLUE;break;
            case 4:color=Color.GREEN;break;
            case 5:color=Color.GOLD;break;
            default:color=Color.GRAY;break;
        }
    }
    
    Ring pop(){
        int i=size-1;
        while(rings[i]==null && i>=0){
            i--;
        }
        if(i>=0){
            Ring res=rings[i];
            rings[i]=null;
            used--;
            return res;
        }else{
            return null;
        }
    }
    
    boolean push(Ring r){
        if(rings[0]==null){
            rings[0]=r;
            used++;
            return true;
        }else{
            int i=size-1;
            while(rings[i]==null && i>0){
                i--;
            }
            if(r.size<rings[i].size || i<0){
                rings[i+1]=r;
                used++;
                return true;
            }else{
                return false;
            }
        }
    }
    
    boolean check(){
        if(color==Color.GRAY){
            if(rings[0]!=null){
                return false;
            }
        }else{
            for(Ring r:rings){
                if(r==null || r.color!=color){
                    return false;
                }
            } 
        }
        return true;
    }
}
