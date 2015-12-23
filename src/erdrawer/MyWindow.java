/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
/**
 *
 * @author User
 */
public class MyWindow extends JFrame{
    ToolBar tb;
    LeftToolBar ltb;
    MessageBar mb;
    ERDrawer parent;
    MyWindow(ERDrawer p)
    {
        super();
        parent=p;
        this.setSize(1024,800);
        this.setVisible(true);
        this.setTitle("ERDrawer");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                System.exit(0);
            }
        }               
                              );
        
        tb=new ToolBar(this);
        ltb=new LeftToolBar(this);
        mb=new MessageBar(this);
        this.add(tb,BorderLayout.NORTH);
        this.add(ltb,BorderLayout.WEST);
        this.add(mb,BorderLayout.SOUTH);
        this.setVisible(true);
    }
}
