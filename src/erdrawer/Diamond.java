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
public class Diamond {
    Page parent;
    Diamond(Page p,Point p1,Point p2,boolean b)
    {
        parent = p;
        Graphics g=this.parent.getGraphics();
        if(b==true)
        {
            g.setXORMode(Color.white);
            g.drawLine( p1.x, p1.y, p2.x, (p2.y+p1.y)/2);
            g.drawLine( p1.x, p2.y, p2.x, (p2.y+p1.y)/2);
            g.drawLine( p1.x, p1.y, p1.x+(p1.x-p2.x), (p2.y+p1.y)/2);
            g.drawLine( p1.x, p2.y, p1.x+(p1.x-p2.x), (p2.y+p1.y)/2);
        }
        else if(b==false)
        {
            g.setPaintMode();
            g.setColor(Color.black);
            g.drawLine( p1.x, p1.y, p2.x, (p2.y+p1.y)/2);
            g.drawLine( p1.x, p2.y, p2.x, (p2.y+p1.y)/2);
            g.drawLine( p1.x, p1.y, p1.x+(p1.x-p2.x), (p2.y+p1.y)/2);
            g.drawLine( p1.x, p2.y, p1.x+(p1.x-p2.x), (p2.y+p1.y)/2);
        }
    }
}
