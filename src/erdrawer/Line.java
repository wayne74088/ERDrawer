/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.Event.*;
/**
 *
 * @author Wayne
 */
public class Line extends OBJ{
    Color color1;
    boolean b1;
    Line( Color c, Page p)
    {
        super(p,Status.line);
        color1 = c;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(color1);
        Dimension d=this.getSize();
        Point p=this.getLocation();
        if(b1==true)
        {
            this.linestatus=true;
            g.drawLine( 0, 0, d.width-1, d.height-1);
        }
        else if(b1==false)
        {
            this.linestatus=false;
            g.drawLine( 0, d.height-1, d.width-1, 0);
        }
    }
}
