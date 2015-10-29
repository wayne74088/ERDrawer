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
 * @author Wayne
 */
public class MessageBar extends Panel{
    MyWindow parent;
    Label pageInfo,cursorInfo;
    MessageBar(MyWindow p)
    {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        parent=p;
        cursorInfo=new Label("--NULL--");
        this.add(cursorInfo,BorderLayout.WEST);
        pageInfo=new Label("0/0");
        this.add(pageInfo,BorderLayout.EAST);
        
    }
    void updateInfo(Page p)
    {
        if(pageInfo!=null)
        {
            pageInfo.setText("" + (this.parent.parent.pages.indexOf(p)+1) + 
                    "/" + this.parent.parent.pages.size());
        }
        if(cursorInfo!=null)
        {
            if(this.parent.parent.status==Status.pen)
            {
                cursorInfo.setText("Pen");
            }
            else if(this.parent.parent.status==Status.line)
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
    }
}
