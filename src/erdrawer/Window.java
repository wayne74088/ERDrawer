/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author User
 */
public class Window extends Frame{
    Window()
    {
        this.setSize(1024,800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                System.exit(0);
            }
        }
        );
    }
}
