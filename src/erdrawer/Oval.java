/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
/**
 *
 * @author Wayne
 */
public class Oval {
    Page parent;
    Oval(Page p,Point p1,Point p2,boolean b)
    {
        parent = p;
        Graphics g=this.parent.getGraphics();
        if(b==true)
        {
            g.setXORMode(Color.white);
            if((p1.x<p2.x)&&(p1.y<p2.y))
            {
                g.drawOval(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
            }
            else if((p1.x>p2.x)&&(p1.y>p2.y))
            {
                g.drawOval(p2.x, p2.y, p1.x-p2.x, p1.y-p2.y);
            }
            else if((p1.x>p2.x)&&(p1.y<p2.y))
            {
                g.drawOval(p2.x, p1.y, p1.x-p2.x, p2.y-p1.y);
            }
            else if((p1.x<p2.x)&&(p1.y>p2.y))
            {
                g.drawOval(p1.x, p2.y, p2.x-p1.x, p1.y-p2.y);
            }
        }
        else if(b==false)
        {
            g.setPaintMode();
            g.setColor(Color.black);
            if((p1.x<p2.x)&&(p1.y<p2.y))
            {
                g.drawOval(p1.x, p1.y, p2.x-p1.x, p2.y-p1.y);
            }
            else if((p1.x>p2.x)&&(p1.y>p2.y))
            {
                g.drawOval(p2.x, p2.y, p1.x-p2.x, p1.y-p2.y);
            }
            else if((p1.x>p2.x)&&(p1.y<p2.y))
            {
                g.drawOval(p2.x, p1.y, p1.x-p2.x, p2.y-p1.y);
            }
            else if((p1.x<p2.x)&&(p1.y>p2.y))
            {
                g.drawOval(p1.x, p2.y, p2.x-p1.x, p1.y-p2.y);
            }
        }
    }
    
}
