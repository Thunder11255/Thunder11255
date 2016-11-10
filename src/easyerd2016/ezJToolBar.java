package easyerd2016;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
        
/**
 *
 * @author Thunder
 */
public class ezJToolBar extends JPanel implements ActionListener 
{
    ezERD parent;
    ezOBJType objType;
    
    static final private String NEWPAGE = "NewPage";
    static final private String PREVPAGE = "PrevPage";
    static final private String NEXTPAGE = "next";
    static final private String DRAW = "draw";
    static final private String ENTITYSET = "entityset";
    static final private String RELATIONSHIP = "relationship";
    static final private String ATTRIBUTE = "attribute";
    static final private String COLORCHOOSER = "colorchooser";
        
    public ezJToolBar(ezERD p) 
    {
        //super(new BorderLayout());
        super();
        parent = p;
        
        JToolBar toolBar = new JToolBar("Still draggable");
        addButtons(toolBar);
        
        setPreferredSize(new Dimension(450, 40));
        add(toolBar, BorderLayout.PAGE_START);
        //add(scrollPane, BorderLayout.CENTER);
    }
        
     public void addButtons(JToolBar toolBar)
     {
        JButton button = null;       //first button
        button = makeNavigationButton(NEWPAGE, "Create a newpage","NewPage");
        toolBar.add(button);        //second button
        button = makeNavigationButton(PREVPAGE, "Turn to PrevPage","PrevPage");
        toolBar.add(button);        //third button
        button = makeNavigationButton(NEXTPAGE, "Turn to NextPage","NextPage");
        toolBar.add(button);
        button = makeNavigationButton(DRAW, "Draw a Line","Draw");
        toolBar.add(button);
        button = makeNavigationButton(ENTITYSET, "Draw a Square","Entity Set");
        toolBar.add(button);
        button = makeNavigationButton(RELATIONSHIP, "Draw a Diamond","Relationship");
        toolBar.add(button);
        button = makeNavigationButton(ATTRIBUTE, "Draw a circle","Attribute");
        toolBar.add(button);
        //button = makeNavigationButton(COLORCHOOSER, "Pick a color","colorchoser");
        //toolBar.add(button);
    }
     
    public JButton makeNavigationButton(String actionCommand, String toolTipText,String altText) 
    {
        //Look for the image.
       // String imgLocation = "images/"+ imageName+ ".gif";
        //URL imageURL = JToolBar.class.getResource(imgLocation);
       
        //Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        //no image found
        button.setText(altText);
        return button;
    }
     
    public void actionPerformed (ActionEvent e){
        String cmd = e.getActionCommand();
        //String description = null;

        // Handle each button.
        if (NEWPAGE.equals(cmd))  //first button clicked
        {            
            ezPage newPage = new ezPage(ezJToolBar.this);
            parent.mainWin.addPage(newPage);
            
            parent.totalPages++;
                            
            parent.messagebar.updateMessage();
        }
        else if (PREVPAGE.equals(cmd))  // second button clicked
        {
            if(parent.curPage !=1)
            {
                parent.mainWin.prevPage();
            
                parent.curPage--;
                parent.messagebar.updateMessage();
            }
        }
        else if (NEXTPAGE.equals(cmd))  // third button clicked
        {
            if(parent.totalPages != parent.curPage)
            {
                parent.mainWin.nextPage();
            
                parent.curPage++;
                parent.messagebar.updateMessage();
                parent.activePage.status=ezPageStatus.inactivated;
            }
        }
        else if (DRAW.equals(cmd))  // third button clicked
        {
            if(parent.activePage.status==ezPageStatus.activated)
                parent.activePage.status=ezPageStatus.ready2draw;
            else if(parent.activePage.status == ezPageStatus.ready2creatOBJ)
                parent.activePage.status = ezPageStatus.ready2draw;
        }
        else if (ENTITYSET.equals(cmd))  // third button clicked
        {
            objType = ezOBJType.ES;
            if(parent.activePage.status == ezPageStatus.activated)
            {
                parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
            else if(parent.activePage.status == ezPageStatus.ready2draw)
            {
                parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
        }
        else if (RELATIONSHIP.equals(cmd))  // third button clicked
        {
            objType = ezOBJType.RS;
            if(parent.activePage.status == ezPageStatus.activated)
            {
                parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
            else if(parent.activePage.status == ezPageStatus.ready2draw)
            {
                parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
        }
        else if (ATTRIBUTE.equals(cmd))  // third button clicked
        {
            objType = ezOBJType.AT;
            if(parent.activePage.status == ezPageStatus.activated)
            {
                parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
            else if(parent.activePage.status == ezPageStatus.ready2draw)
            {
                parent.activePage.status = ezPageStatus.ready2creatOBJ;
            }
        }
        /*else if (COLORCHOOSER.equals(cmd))  // second button clicked
        {
            parent.mainWin.chooseColor();
        }*/
    }
}
