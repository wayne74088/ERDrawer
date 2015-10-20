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
    Vector<Line> Lines,Entityset;
    Page(ToolBar p)
    {
        super();       
        parent=p;
        Lines =new Vector<Line>();
        Entityset=new Vector<Line>();
        p1=new Point();
        p2=new Point();
        this.setBackground(Color.white);  
        this.addMouseListener(new MouseAdapter()
                                {
                                    public void mousePressed(MouseEvent e)
                                    {
                                        if((Page.this.parent.parent.parent.status==Status.pen)||
                                           (Page.this.parent.parent.parent.status==Status.line)||
                                           (Page.this.parent.parent.parent.status==Status.entity))
                                        {
                                            p1.x=e.getX();
                                            p1.y=e.getY();
                                            first=true;
                                        }
                                    }
                                    
                                    public void mouseReleased(MouseEvent e)
                                    {
                                        if(Page.this.parent.parent.parent.status==Status.line)
                                        {
                                            Graphics g=Page.this.getGraphics();
                                            Lines.add(new Line(p1,p2));
                                            if(first!=true)
                                            {
                                                g.setPaintMode();
                                                g.setColor(Color.black);
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                            }
                                        }
                                        if(Page.this.parent.parent.parent.status==Status.entity)
                                        {
                                            Graphics g=Page.this.getGraphics();
                                            Entityset.add(new Line(p1,p2));
                                            if(first!=true)
                                            {
                                                g.setPaintMode();
                                                g.setColor(Color.black);
                                                g.drawLine(p1.x, p1.y, p1.x, p2.y);
                                                g.drawLine(p1.x, p2.y, p2.x, p2.y);
                                                g.drawLine(p1.x, p1.y, p2.x, p1.y);
                                                g.drawLine(p2.x, p1.y, p2.x, p2.y);
                                            }
                                        }
                                    }
                                }
                             );
        this.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            if(Page.this.parent.parent.parent.status==Status.pen)
                                            {
                                                Graphics g=Page.this.getGraphics();
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                Lines.add(new Line(p1,p2));
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                                
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.line)
                                            {
                                                Graphics g=Page.this.getGraphics();                                              
                                                if(first!=true)
                                                {
                                                    g.setXORMode(Color.white);
                                                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                g.setXORMode(Color.white);
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.entity)
                                            {
                                                Graphics g=Page.this.getGraphics();

                                                if(first!=true)
                                                {
                                                    g.setXORMode(Color.white);
                                                    g.drawLine(p1.x, p1.y, p1.x, p2.y);
                                                    g.drawLine(p1.x, p2.y, p2.x, p2.y);
                                                    g.drawLine(p1.x, p1.y, p2.x, p1.y);
                                                    g.drawLine(p2.x, p1.y, p2.x, p2.y);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.setXORMode(Color.white);
                                                g.drawLine(p1.x, p1.y, p1.x, p2.y);
                                                g.drawLine(p1.x, p2.y, p2.x, p2.y);
                                                g.drawLine(p1.x, p1.y, p2.x, p1.y);
                                                g.drawLine(p2.x, p1.y, p2.x, p2.y);
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
        for(Line i : Entityset)
        {
            g.drawLine(i.start.x, i.start.y, i.start.x, i.end.y);
            g.drawLine(i.start.x, i.end.y, i.end.x, i.end.y);
            g.drawLine(i.start.x, i.start.y, i.end.x, i.start.y);
            g.drawLine(i.end.x, i.start.y, i.end.x, i.end.y);
        }
        //g.drawLine();
    }
}
