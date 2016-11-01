/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Thunder
 */
public class ezMainWin extends Frame
{
    ezERD parent;
    
    void prevPage()
    {
        int p=parent.pages.indexOf(parent.activePage);
        ezPage ep = parent.pages.elementAt(--p);
        
        if(parent.activePage!=null)
        {
            this.remove(parent.activePage);
        }
        this.add(ep, BorderLayout.CENTER);
        
        this.validate();
        parent.activePage=ep;
    }
    
    void nextPage()
    {
        int p=parent.pages.indexOf(parent.activePage);
        ezPage ep = parent.pages.elementAt(++p);
        
        if(parent.activePage!=null)
        {
            this.remove(parent.activePage);
        }
        this.add(ep, BorderLayout.CENTER);
        
        this.validate();
        parent.activePage=ep;
    }
    
    void addPage(ezPage p)
    {
        System.out.println("here 1");
        
        if(parent.activePage!=null)
        {
            System.out.println("here 2");
            //parent.activePage.setVisible(false);
            this.remove(parent.activePage);
        }
        this.add(p, BorderLayout.CENTER);
        parent.pages.add(parent.curPage, p);
        //parent.activePage.setVisible(false);
        parent.curPage++;
        
        this.validate();
        parent.activePage=p;
    }
    
    void setMessageBar(ezMessageBar mb)
    {
        this.add(mb, BorderLayout.SOUTH);
    }
    
    void setToolbar(ezToolbar tb)
    {
        this.add(tb, BorderLayout.NORTH);
    }
    
    ezMainWin(ezERD p)
    {
        super();
        parent = p;
        
        this.setLayout(new BorderLayout());
        
        this.setSize(parent.mainWinWidth, parent.mainWinHeight);
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((ScreenSize.width-1024)/2, (ScreenSize.height-1024)/2);
        
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
}
