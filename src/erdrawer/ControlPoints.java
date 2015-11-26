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
public class ControlPoints {
    Page parent;
    Panel N,S,W,E,NW,NE,SW,SE;
    
    ControlPoints(Page p)
    {
        parent = p;
        N=new Panel();
        S=new Panel();
        W=new Panel();
        E=new Panel();
        NW=new Panel();
        NE=new Panel();
        SW=new Panel();
        SE=new Panel();
        
        N.setSize(9,9);
        S.setSize(9,9);
        W.setSize(9,9);
        E.setSize(9,9);
        NW.setSize(9,9);
        NE.setSize(9,9);
        SW.setSize(9,9);
        SE.setSize(9,9);
        
        N.setBackground(Color.black);
        S.setBackground(Color.black);
        W.setBackground(Color.black);
        E.setBackground(Color.black);
        NW.setBackground(Color.black);
        NE.setBackground(Color.black);
        SW.setBackground(Color.black);
        SE.setBackground(Color.black);
        
        ControlPoints.this.parent.add(N);
        ControlPoints.this.parent.add(S);
        ControlPoints.this.parent.add(W);
        ControlPoints.this.parent.add(E);
        ControlPoints.this.parent.add(NW);
        ControlPoints.this.parent.add(NE);
        ControlPoints.this.parent.add(SW);
        ControlPoints.this.parent.add(SE);
    }
    
    void a()
    {
        Point p1=ControlPoints.this.parent.activeOBJ.getLocation();
        Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
        
        NW.setLocation(p1.x-9, p1.y-9);
        N.setLocation(p1.x+d.width/2-4, p1.y-9);
        NE.setLocation(p1.x+d.width+1, p1.y-9);
        E.setLocation(p1.x+d.width+1,p1.y+d.height/2-4);
        SE.setLocation(p1.x+d.width+1, p1.y+d.height+1);
        S.setLocation(p1.x+d.width/2-4, p1.y+d.height+1);
        SW.setLocation(p1.x-9, p1.y+d.height+1);
        W.setLocation(p1.x-9, p1.y+d.height/2-4);   
    }
    
    void c(boolean b)
    {

        N.setVisible(b);
        S.setVisible(b);
        W.setVisible(b);
        E.setVisible(b);
        NW.setVisible(b);
        NE.setVisible(b);
        SW.setVisible(b);
        SE.setVisible(b);
    }
}
