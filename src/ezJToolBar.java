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
    static final private String PREVIOUS = "previous";
    static final private String UP = "up";
    static final private String NEXT = "next";
    
    public ezJToolBar(ezERD p) {
        
        //super(new BorderLayout());
        super();
        
        JToolBar toolBar = new JToolBar("Still draggable");
        addButtons(toolBar);
        
        setPreferredSize(new Dimension(450, 130));
        add(toolBar, BorderLayout.PAGE_START);
        //add(scrollPane, BorderLayout.CENTER);
    }
        
     public void addButtons(JToolBar toolBar)
     {
        JButton button = null;       //first button
        button = makeNavigationButton(PREVIOUS, "Back to previous something-or-other","Previous");
        toolBar.add(button);        //second button
        button = makeNavigationButton(UP, "Up to something-or-other","Up");
        toolBar.add(button);        //third button
        button = makeNavigationButton(NEXT, "Forward to something-or-other","Next");
        toolBar.add(button);
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
    
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        //String description = null;

        // Handle each button.
        if (PREVIOUS.equals(cmd))  //first button clicked
        {
            System.out.println("here 123");
            
            ezPage newPage= new ezPage();
            parent.mainWin.addPage(newPage);
            
            parent.totalPages++;
            parent.curPage++;
                
            parent.messagebar.updateMessage();
        }
        else if (UP.equals(cmd))  // second button clicked
        {

        }
        else if (NEXT.equals(cmd))  // third button clicked
        {

        }
    }
}
