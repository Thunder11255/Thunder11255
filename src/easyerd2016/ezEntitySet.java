/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyerd2016;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Thunder
 */
public class ezEntitySet extends ezOBJ
{
    ezEntitySet(int x, int y, int w, int h)
    {
        super(x, y, w, h);
    }
    
    void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
    }
}
