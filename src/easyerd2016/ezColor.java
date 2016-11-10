/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyerd2016;
   import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


/**
 *
 * @author Thunder
 */
public class ezColor extends JPanel
{
    ezERD parent;
    
    public ezColor(ezERD p)
    {
        super();
        parent = p;
        System.out.println("123");
        
        JFrame frame = new JFrame("JColorChooser Popup");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        
        final JLabel label = new JLabel("I Love Swing", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 48));
        contentPane.add(label, BorderLayout.SOUTH);
    
        JColorChooser colorChooser = new JColorChooser();
        colorChooser.setBorder(BorderFactory.createTitledBorder("Pick Foreground Color"));
        
        ColorSelectionModel model = colorChooser.getSelectionModel();
        ChangeListener changeListener = new ChangeListener()
        {
            public void stateChanged(ChangeEvent changeEvent)
            {
                Color newForegroundColor = colorChooser.getColor();
            }
        };
    }
}