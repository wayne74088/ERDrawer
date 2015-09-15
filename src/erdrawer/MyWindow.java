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
public class MyWindow extends Frame{
    MyWindow()
    {
        super();
        this.setSize(1024,800);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.gray);
        this.setLayout(new BorderLayout());
        
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent event)
            {
                System.exit(0);
            }
        }               
                              );
        
        ToolBar tb=new ToolBar();
        tb.setLayout(new FlowLayout());
        Button PageBtn=new Button("NewPage");
        NewPage np=new NewPage();
        
        PageBtn.addMouseListener(new MouseAdapter()
            {
             public void mouseClicked(MouseEvent e)
                {
                 MyWindow.this.add(np,BorderLayout.CENTER);
                /* MyWindow.this.setVisible(false);
                 MyWindow.this.setVisible(true);*/
                 MyWindow.this.revalidate();
                }
            }   
                                );
        
    tb.add(PageBtn);
    this.add(tb,BorderLayout.NORTH);
    this.setVisible(true);
    }
}
