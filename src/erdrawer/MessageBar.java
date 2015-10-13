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
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        parent=p;
        cursorInfo=new Label("NULL");
        this.add(cursorInfo);
        pageInfo=new Label("0/0");
        this.add(pageInfo);
        
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
            if(this.parent.parent.isPen==true)
            {
                cursorInfo.setText("Pen");
            }
            if(this.parent.parent.isLine==true)
            {
                cursorInfo.setText("Line");
            }
            if((this.parent.parent.isPen==false)&&(this.parent.parent.isLine==false))
            {
                cursorInfo.setText("NULL");
            }
        }
    }
}
