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
    boolean first,First;
    Vector<Line> Lines;
    Vector<OBJ> objects;
    OBJ activeOBJ;
    ControlPoints cp;
    Page(ToolBar p)
    {
        super();       
        parent = p;
        First=true;
        Lines = new Vector<Line>();
        objects = new Vector<OBJ>();
        cp=new ControlPoints(Page.this);
        this.setLayout(null);
        p1=new Point();
        p2=new Point();
        first=true;
        activeOBJ=new OBJ(Page.this);
        activeOBJ=null;
        this.setBackground(Color.white); 
        this.addMouseListener(new MouseAdapter()
                                {
                                    
                                    public void mousePressed(MouseEvent e)
                                    {
                                        if(activeOBJ!=null)
                                        {
                                            activeOBJ.status=Status.idle;
                                            activeOBJ=null;
                                        }
                                        Page.this.repaint();
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
                                        else
                                        {
                                        if(Page.this.parent.parent.parent.status==Status.rect)
                                        {
                                        if(first!=true)
                                        {
                                            Entityset Entity=new Entityset(Page.this.parent.color,Page.this);
                                            if((p1.x<p2.x)&&(p1.y<p2.y))
                                            {
                                                Entity.setSize(p2.x-p1.x,p2.y-p1.y);
                                                Entity.setLocation(p1.x, p1.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y>p2.y))
                                            {
                                                Entity.setSize(p1.x-p2.x,p1.y-p2.y);
                                                Entity.setLocation(p2.x, p2.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y<p2.y))
                                            {
                                                Entity.setSize(p1.x-p2.x,p2.y-p1.y);
                                                Entity.setLocation(p2.x, p1.y);
                                            }
                                            else if((p1.x<p2.x)&&(p1.y>p2.y))
                                            {
                                                Entity.setSize(p2.x-p1.x,p1.y-p2.y);
                                                Entity.setLocation(p1.x, p2.y);
                                            }
                                            Page.this.add(Entity);
                                            objects.add(Entity);
                                            if(Page.this.activeOBJ!=null)
                                            {
                                                activeOBJ.status=Status.idle;
                                            }
                                            Page.this.activeOBJ=Entity;
                                            Page.this.repaint();
                                        }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.diamond)
                                        {
                                        if(first!=true)
                                        {
                                            Relationship Relation=new Relationship(Page.this.parent.color,Page.this);
                                            if((p1.x<p2.x)&&(p1.y<p2.y))
                                            {
                                                Relation.setSize(p2.x-p1.x,p2.y-p1.y);
                                                Relation.setLocation(p1.x, p1.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y>p2.y))
                                            {
                                                Relation.setSize(p1.x-p2.x,p1.y-p2.y);
                                                Relation.setLocation(p2.x, p2.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y<p2.y))
                                            {
                                                Relation.setSize(p1.x-p2.x,p2.y-p1.y);
                                                Relation.setLocation(p2.x, p1.y);
                                            }
                                            else if((p1.x<p2.x)&&(p1.y>p2.y))
                                            {
                                                Relation.setSize(p2.x-p1.x,p1.y-p2.y);
                                                Relation.setLocation(p1.x, p2.y);
                                            }
                                            Page.this.add(Relation);
                                            objects.add(Relation);
                                            if(Page.this.activeOBJ!=null)
                                            {
                                                activeOBJ.status=Status.idle;
                                            }
                                            Page.this.activeOBJ=Relation;
                                            Page.this.repaint();
                                        }
                                        }
                                        else if(Page.this.parent.parent.parent.status==Status.oval)
                                        {
                                        if(first!=true)
                                        {
                                            Attribute attributen=new Attribute(Page.this.parent.color,Page.this);
                                            if((p1.x<p2.x)&&(p1.y<p2.y))
                                            {
                                                attributen.setSize(p2.x-p1.x,p2.y-p1.y);
                                                attributen.setLocation(p1.x, p1.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y>p2.y))
                                            {
                                                attributen.setSize(p1.x-p2.x,p1.y-p2.y);
                                                attributen.setLocation(p2.x, p2.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y<p2.y))
                                            {
                                                attributen.setSize(p1.x-p2.x,p2.y-p1.y);
                                                attributen.setLocation(p2.x, p1.y);
                                            }
                                            else if((p1.x<p2.x)&&(p1.y>p2.y))
                                            {
                                                attributen.setSize(p2.x-p1.x,p1.y-p2.y);
                                                attributen.setLocation(p1.x, p2.y);
                                            }
                                            Page.this.add(attributen);
                                            objects.add(attributen);
                                            if(Page.this.activeOBJ!=null)
                                            {
                                                activeOBJ.status=Status.idle;
                                            }
                                            Page.this.activeOBJ=attributen;
                                            
                                            Page.this.repaint();
                                        }
                                        }         
                                        if(activeOBJ!=null)
                                        {
                                            activeOBJ.status=Status.actived;
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
                                                    new Rect(Page.this,p1,p2,Page.this.parent.color);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Rect(Page.this,p1,p2,Page.this.parent.color);
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.diamond)
                                            {
                                                if(first!=true)
                                                {
                                                    new Diamond(Page.this,p1,p2,Page.this.parent.color);
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Diamond(Page.this,p1,p2,Page.this.parent.color);
                                            }
                                            else if(Page.this.parent.parent.parent.status==Status.oval)
                                            {
                                                g.setXORMode(Color.white);
                                                if(first!=true)
                                                {
                                                    new Oval(Page.this,p1,p2,Page.this.parent.color);                                                  
                                                }
                                                else
                                                {
                                                    first=false;
                                                }
                                                p2.x=e.getX();
                                                p2.y=e.getY();
                                                new Oval(Page.this,p1,p2,Page.this.parent.color);                                               
                                            }
                                        }
                                    }
                                   );
    }

    public void paint(Graphics g)
    {       
        super.paint(g);
        for(Line i : Lines)
        {
            g.setColor(i.color);
            g.drawLine(i.start.x, i.start.y, i.end.x, i.end.y);          
        }
        
        if(activeOBJ!=null)
        {
            cp.a();
            cp.c(true);
            g.setXORMode(Color.white);
            Point p=activeOBJ.getLocation();
            Dimension d=activeOBJ.getSize();
            //g.drawRect(p.x-5,p.y-5,d.width+10,d.height+10);
            g.drawLine(p.x-5,p.y-5,p.x-5+d.width+10,p.y-5);
            g.drawLine(p.x-5+d.width+10,p.y-5,p.x-5+d.width+10,p.y-5+d.height+10);
            g.drawLine(p.x-5+d.width+10,p.y-5+d.height+10,p.x-5,p.y-5+d.height+10);
            g.drawLine(p.x-5,p.y-5,p.x-5,p.y-5+d.height+10);
        }
        else
        {
            cp.c(false);
        }
        
    }
}
