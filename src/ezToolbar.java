/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;/**
 *
 * @author Thunder
 */
public class ezToolbar extends Panel{
    
    ezERD parent;
    
    ezToolbar(ezERD p)
    {
        super();
        parent=p;
        
        this.setLayout(new FlowLayout());
        this.setBackground(Color.darkGray);
        
        Button exitBtn = new Button("Exit");
        this.add(exitBtn);
        exitBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);
            }
        });
    
        Button newPageBtn = new Button("New Page");
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                ezPage newPage= new ezPage();
                parent.mainWin.addPage(newPage);
                
                parent.totalPages++;
              //  parent.curPage++;
                
                parent.messagebar.updateMessage();
            }
        });

        Button prevPageBtn = new Button("Prev Page");
        this.add(prevPageBtn);
        prevPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
//                ezPage newPage= new ezPage();

                if(parent.curPage !=1)
                {
                    parent.mainWin.prevPage();
                
                    parent.curPage--;
                    parent.messagebar.updateMessage();
                }
            }
        });

        Button nextPageBtn = new Button("Next Page");
        this.add(nextPageBtn);
        nextPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
//                ezPage newPage= new ezPage();

                if(parent.totalPages != parent.curPage)
                {
                    parent.mainWin.nextPage();
                
                    parent.curPage++;
                    parent.messagebar.updateMessage();
                    parent.activePage.status=ezPageStatus.inactivated;
                }
            }
        });

        
        Button drawBtn = new Button("Draw");
        this.add(drawBtn);
        drawBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(parent.activePage.status==ezPageStatus.activated)
                    parent.activePage.status=ezPageStatus.ready2draw;
                else if(parent.activePage.status == ezPageStatus.ready2creatOBJ)
                    parent.activePage.status = ezPageStatus.ready2draw;
            }
        });
        
        Button createOBJBtn = new Button("Create OBJ");
        this.add(createOBJBtn);
        createOBJBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(parent.activePage.status == ezPageStatus.activated)
                    parent.activePage.status = ezPageStatus.ready2creatOBJ;
                else if(parent.activePage.status == ezPageStatus.ready2draw)
                    parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
        });
        
    
    
    }
    
}