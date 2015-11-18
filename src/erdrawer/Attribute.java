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
public class Attribute extends OBJ{
    Color color1;
    Attribute(Color c)
    {
        color1=c;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(color1);
        Dimension d=this.getSize();
        Point p=this.getLocation();
        g.drawOval( 0, 0, d.width-1, d.height-1);
    }
}
