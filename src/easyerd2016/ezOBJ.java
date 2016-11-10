/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyerd2016;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author junwu
 */
public abstract class ezOBJ extends Panel 
{
    
    ezOBJ()
    {
        this.setSize(200, 200);
        this.setLocation(100, 100);
    }
    
    ezOBJ(int x, int y, int w, int h)
    {
        this.setSize(w, h);
        this.setLocation(x, y);
    }

    public void paint(Graphics g)
    {
        draw(g);
    }
    
    abstract void draw(Graphics g);
        
}
