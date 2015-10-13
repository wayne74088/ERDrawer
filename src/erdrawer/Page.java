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
public class Page extends Panel{
    ToolBar parent;
    Point p1,p2;
    boolean first=true;
    Vector<Line> Lines;
    Page(ToolBar p)
    {
        super();       
        parent=p;
        Lines =new Vector<Line>();
        p1=new Point();
        p2=new Point();
        this.setBackground(Color.white);  
        this.addMouseListener(new MouseAdapter()
                                {
                                    public void mousePressed(MouseEvent e)
                                    {
                                        if((Page.this.parent.parent.parent.isPen)||(Page.this.parent.parent.parent.isLine))
                                        {
                                            p1.x=e.getX();
                                            p1.y=e.getY();
                                        }
                                    }
                                    
                                    public void mouseReleased(MouseEvent e)
                                    {
                                        if(Page.this.parent.parent.parent.isLine==true)
                                        {
                                             Lines.add(new Line(p1,p2));
                                        }
                                    }
                                }
                             );
        this.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            if(Page.this.parent.parent.parent.isPen==true)
                                            {
                                                Graphics g=Page.this.getGraphics();
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                Lines.add(new Line(p1,p2));
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                                
                                            }
                                            if(Page.this.parent.parent.parent.isLine==true)
                                            {
                                                Graphics g=Page.this.getGraphics();                                              
                                                if(first!=true)
                                                {
                                                    g.setColor(Color.white);
                                                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                }
                                                first=false;
                                                g.setColor(Color.black);
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                
                                            }
                                        }
                                    }
                                   );
    }
    public void paint(Graphics g)
    {
        for(Line i : Lines)
        {
            g.drawLine(i.start.x, i.start.y, i.end.x, i.end.y);
        }
        //g.drawLine();
    }
}
