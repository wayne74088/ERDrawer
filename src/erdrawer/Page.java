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
        System.out.println(this.getBackground());
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
                                            
                                            Lines.add(new Line(p1,p2,Page.this.parent.color));
                                            
                                            if(first!=true)
                                            {
                                                g.setPaintMode();
                                                g.setColor(Page.this.parent.color);
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                            }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.rect)
                                        {
                                            rects.add(new Line(p1,p2,Page.this.parent.color));
                                            if(first!=true)
                                            {
                                                new Rect(Page.this,p1,p2,false,Page.this.parent.color);
                                            }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.diamond)
                                        {
                                            diamonds.add(new Line(p1,p2,Page.this.parent.color));
                                            if(first!=true)
                                            {
                                                new Diamond(Page.this,p1,p2,false,Page.this.parent.color);
                                            }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.oval)
                                        {
                                            ovals.add(new Line(p1,p2,Page.this.parent.color));
                                            if(first!=true)
                                            {
                                                new Oval(Page.this,p1,p2,false,Page.this.parent.color);
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
                                                g.setColor(Page.this.parent.color);
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                                                Lines.add(new Line(p1,p2,Page.this.parent.color));
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.line)
                                            {      
                                                Color colorline=new Color (Page.this.parent.color.getRed()^Page.this.getBackground().getRed(), Page.this.parent.color.getGreen()^Page.this.getBackground().getGreen(), Page.this.parent.color.getBlue()^Page.this.getBackground().getBlue());
                                                g.setXORMode(colorline);
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
                                                    new Rect(Page.this,p1,p2,true,Page.this.parent.color);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Rect(Page.this,p1,p2,true,Page.this.parent.color);
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.diamond)
                                            {
                                                if(first!=true)
                                                {
                                                    new Diamond(Page.this,p1,p2,true,Page.this.parent.color);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Diamond(Page.this,p1,p2,true,Page.this.parent.color);
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.oval)
                                            {
                                                g.setXORMode(Color.white);
                                                if(first!=true)
                                                {
                                                    new Oval(Page.this,p1,p2,true,Page.this.parent.color);                                                  
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Oval(Page.this,p1,p2,true,Page.this.parent.color);                                               
                                            }
                                        }
                                    }
                                   );
    }
    public void paint(Graphics g)
    {
        for(Line i : Lines)
        {
            g.setColor(i.color);
            g.drawLine(i.start.x, i.start.y, i.end.x, i.end.y);          
        }
        for(Line i : rects)
        {
            new Rect(Page.this,i.start,i.end,false,i.color);
        }
        for(Line i : diamonds)
        {
            new Diamond(Page.this,i.start,i.end,false,i.color);
        }
        for(Line i : ovals)
        {
            new Oval(Page.this,i.start,i.end,false,i.color);
        }
    }
}
