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
    boolean first;
    Vector<Line> Lines,rects,diamonds,ovals;
    Page(ToolBar p)
    {
        super();       
        parent=p;
        Lines =new Vector<Line>();
        rects=new Vector<Line>();
        diamonds=new Vector<Line>();
        ovals=new Vector<Line>();
        p1=new Point();
        p2=new Point();
        first=true;
        this.setBackground(Color.white);  
        this.addMouseListener(new MouseAdapter()
                                {
                                    public void mousePressed(MouseEvent e)
                                    {
                                        
                                        if((Page.this.parent.parent.parent.status==Status.pen)||
                                           (Page.this.parent.parent.parent.status==Status.line)||
                                           (Page.this.parent.parent.parent.status==Status.rect)||
                                           (Page.this.parent.parent.parent.status==Status.diamond)||
                                           (Page.this.parent.parent.parent.status==Status.oval))
                                        {
                                            first=true;
                                            p1.x=e.getX();
                                            p1.y=e.getY();  
                                        }
                                    }
                                    
                                    public void mouseReleased(MouseEvent e)
                                    {
                                        Graphics g=Page.this.getGraphics();
                                        if(Page.this.parent.parent.parent.status==Status.line)
                                        {
                                            
                                            Lines.add(new Line(p1,p2));
                                            if(first!=true)
                                            {
                                                g.setPaintMode();
                                                g.setColor(Color.black);
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                            }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.rect)
                                        {
                                            rects.add(new Line(p1,p2));
                                            if(first!=true)
                                            {
                                                new Rect(Page.this,p1,p2,false);
                                            }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.diamond)
                                        {
                                            diamonds.add(new Line(p1,p2));
                                            if(first!=true)
                                            {
                                                new Diamond(Page.this,p1,p2,false);
                                            }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.oval)
                                        {
                                            ovals.add(new Line(p1,p2));
                                            if(first!=true)
                                            {
                                                new Oval(Page.this,p1,p2,false);
                                            }
                                        }
                                    }
                                }
                             );
        this.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            Graphics g=Page.this.getGraphics();
                                            if(Page.this.parent.parent.parent.status==Status.pen)
                                            {
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                Lines.add(new Line(p1,p2));
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.line)
                                            {      
                                                g.setXORMode(Color.white);
                                                if(first!=true)
                                                {
                                                    //g.setXORMode(Color.white);
                                                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.rect)
                                            {
                                                if(first!=true)
                                                {
                                                    new Rect(Page.this,p1,p2,true);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Rect(Page.this,p1,p2,true);
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.diamond)
                                            {
                                                if(first!=true)
                                                {
                                                    new Diamond(Page.this,p1,p2,true);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Diamond(Page.this,p1,p2,true);
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.oval)
                                            {
                                                g.setXORMode(Color.white);
                                                if(first!=true)
                                                {
                                                    new Oval(Page.this,p1,p2,true);                                                  
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Oval(Page.this,p1,p2,true);                                               
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
        for(Line i : rects)
        {
            new Rect(Page.this,i.start,i.end,false);
        }
        for(Line i : diamonds)
        {
            new Diamond(Page.this,i.start,i.end,false);
        }
        for(Line i : ovals)
        {
            new Oval(Page.this,i.start,i.end,false);
        }
    }
}
