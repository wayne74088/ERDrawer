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
    Label pageInfo;
    MessageBar(MyWindow p)
    {
        super();
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        parent=p;
        pageInfo=new Label("0/0");
        this.add(pageInfo);     
    }
    void updateInfo(NewPage p)
    {
        if(pageInfo!=null)
        {
            pageInfo.setText("" + (this.parent.parent.pages.indexOf(p)+1) + 
                    "/" + this.parent.parent.pages.size());
        }
    }
}
