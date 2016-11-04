/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 *
 * @author Thunder
 */

enum ezPageStatus{activated, inactivated, ready2draw, drawing, ready2creatOBJ, creatingOBJ}

public class ezPage extends Panel
{
    //static Color c[] = {Color.BLACK};
    static int count = 0;
    
    ezPageStatus status;
    
    Point lp, cp;
    Vector<ezDrawLine> drawLines;
    
    public ezPage()
    {
        super();
        status = ezPageStatus.activated;
        drawLines = new Vector<ezDrawLine>();
        
        this.setBackground(Color.WHITE);
        
        this.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                if(status == ezPageStatus.drawing)
                {
                    cp=e.getPoint();
                    Graphics g=ezPage.this.getGraphics();
                    g.setColor(Color.BLACK);                    
                    g.drawLine(lp.x, lp.y, cp.x, cp.y);
                    drawLines.add(new ezDrawLine(lp, cp));
                    lp=cp;
                }
                else if(status==ezPageStatus.creatingOBJ)
                {
                    Graphics g=ezPage.this.getGraphics();
                    if(cp!=null)
                    {
                        g.setXORMode(Color.green);             
                        g.drawRect(lp.x, lp.y, cp.x-lp.x, cp.y-lp.y);
                    }
                    cp=e.getPoint();
                    g.setXORMode(Color.green);
                    g.drawRect(lp.x, lp.y, cp.x-lp.x, cp.y-lp.y);
                }
            }
        });
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if(status==ezPageStatus.ready2draw)
                {
                    lp=e.getPoint();
                    status=ezPageStatus.drawing;
                }
                else if(status==ezPageStatus.ready2creatOBJ)
                {
                    lp=e.getPoint();
                    status=ezPageStatus.creatingOBJ; 
                    cp=null;
                }
            }
            
            public void mouseReleased(MouseEvent e)
            {
                if(status == ezPageStatus.drawing)
                {
                    status=ezPageStatus.ready2draw;
                }
                else if(status == ezPageStatus.creatingOBJ)
                {
                    status=ezPageStatus.ready2creatOBJ;
                }
            }

        });
        
        
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLACK);
        for(ezDrawLine l:drawLines)
        {
                g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
    }
}
