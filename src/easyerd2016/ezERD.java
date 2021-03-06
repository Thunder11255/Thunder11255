package easyerd2016;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Vector;

/**
 *
 * @author Thunder
 */
public class ezERD 
{
    ezMainWin mainWin;
    int mainWinWidth = 1024;
    int mainWinHeight = 1024;
    
    Vector<ezPage> pages;
    ezPage activePage;
    ezToolbar toolbar;
    ezJToolBar jtoolbar;
    ezMessageBar messagebar;
    ezColor ezcolor;
    
    int totalPages = 1;
    int curPage = 0;
    
    ezERD()
    {
        pages = new Vector<ezPage>();
        mainWin = new ezMainWin(this);
        toolbar = new ezToolbar(this);
        jtoolbar = new ezJToolBar(this);
        messagebar = new ezMessageBar(this);
        ezcolor = new ezColor(this);
        
        //mainWin.setToolbar(toolbar);
        mainWin.setMessageBar(messagebar);
        mainWin.setJToolBar(jtoolbar);
        mainWin.chooseColor(ezcolor);
        
        ezPage newPage = new ezPage(jtoolbar);
        
        activePage=null;
        
        mainWin.addPage(newPage);
    }
    
    public void run()
    {
        mainWin.setVisible(true);
    }
    
}
