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
 * @author Wayne
 */
public class MessageBar extends JPanel{
    MyWindow parent;
    JLabel pageInfo,cursorInfo,colorInfo;
    MessageBar(MyWindow p)
    {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        parent=p;
        colorInfo=new JLabel("     ");
        colorInfo.setBackground(this.parent.tb.color);
        colorInfo.setOpaque(true);
        this.add(colorInfo,BorderLayout.WEST);
        cursorInfo=new JLabel("--NULL--");
        this.add(cursorInfo,BorderLayout.CENTER);
        pageInfo=new JLabel("0/0");
        this.add(pageInfo,BorderLayout.EAST);
        
    }
    void updateInfo(Page p,Color c)
    {
        if(pageInfo!=null)
        {
            pageInfo.setText("" + (this.parent.parent.pages.indexOf(p)+1) + 
                    "/" + this.parent.parent.pages.size());
        }
        if(cursorInfo!=null)
        {
            if(this.parent.parent.status==Status.line)
            {
                cursorInfo.setText("Line");
            }
            else if(this.parent.parent.status==Status.rect)
            {
                cursorInfo.setText("Rect");
            }
            else if(this.parent.parent.status==Status.diamond)
            {
                cursorInfo.setText("Diamond");
            }
            else if(this.parent.parent.status==Status.oval)
            {
                cursorInfo.setText("Oval");
            }
            else if(this.parent.parent.status==Status.free)
            {
                cursorInfo.setText("--NULL--");
            }
        }
        if(c!=null)
        {
            colorInfo.setBackground(c);
        }
    }
}
