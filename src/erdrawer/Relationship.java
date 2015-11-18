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
public class Relationship extends OBJ{
    Color color1;
    Relationship(Color c)
    {
        color1=c;
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(color1);
        Dimension d=this.getSize();
        Point p=this.getLocation();
        g.drawLine( 0, d.height/2, d.width/2, 0 );
        g.drawLine( d.width/2, 0 , d.width, d.height/2);
        g.drawLine( d.width, d.height/2, d.width/2, d.height );
        g.drawLine( d.width/2 , d.height, 0, d.height/2 );
    }
    
}
