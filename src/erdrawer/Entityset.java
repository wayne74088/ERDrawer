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
public class Entityset extends OBJ{
    Color color1;
    Entityset(Color c,Page p)
    {
        super(p,Status.rect);
        color1=c;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(color1);
        Dimension d=this.getSize();
        Point p=this.getLocation();
        g.drawRect( 0, 0, d.width-1, d.height-1);
        g.drawString("text", 20, d.height/2);
    }
}
