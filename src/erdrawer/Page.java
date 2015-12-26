/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
/**
 *
 * @author Wayne
 */
public class Page extends JPanel{
    ToolBar parent;
    Point p1,p2;
    boolean first,First,b;
    Vector<OBJ> objects;
    OBJ activeOBJ,obj;
    ControlPoints cp;
    int[][] Return;
    int objecttotal=0,objecttotal2=0;
    Page(ToolBar p)
    {
        super();       
        parent = p;
        First=true;
        objects = new Vector<OBJ>();
        cp=new ControlPoints(Page.this);
        this.setLayout(null);
        p1=new Point();
        p2=new Point();
        Return=new int[100][11];
        first=true;
        activeOBJ=new OBJ(Page.this,null);
        obj=new OBJ(Page.this,null);
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
                                        if((Page.this.parent.parent.parent.status==Status.line)||
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
                                        if(first!=true)
                                        {
                                            Line line=new Line(Page.this.parent.color,Page.this);
                                            if((p1.x<p2.x)&&(p1.y<p2.y))
                                            {
                                                line.setSize(p2.x-p1.x,p2.y-p1.y);
                                                line.setLocation(p1.x, p1.y);
                                                line.b1=true;
                                                Page.this.Return[objecttotal][7]=1;
                                            }
                                            else if((p1.x>p2.x)&&(p1.y>p2.y))
                                            {
                                                line.setSize(p1.x-p2.x,p1.y-p2.y);
                                                line.setLocation(p2.x, p2.y);
                                                line.b1=true;
                                                Page.this.Return[objecttotal][7]=1;
                                            }
                                            else if((p1.x>p2.x)&&(p1.y<p2.y))
                                            {
                                                line.setSize(p1.x-p2.x,p2.y-p1.y);
                                                line.setLocation(p2.x, p1.y);
                                                line.b1=false;
                                                Page.this.Return[objecttotal][7]=0;
                                            }
                                            else if((p1.x<p2.x)&&(p1.y>p2.y))
                                            {
                                                line.setSize(p2.x-p1.x,p1.y-p2.y);
                                                line.setLocation(p1.x, p2.y);
                                                line.b1=false;
                                                Page.this.Return[objecttotal][7]=0;
                                            }
                                            Page.this.add(line);
                                            objects.add(line);
                                            Page.this.Return[objecttotal][0]=line.getX();
                                            Page.this.Return[objecttotal][1]=line.getY();
                                            Page.this.Return[objecttotal][2]=line.getWidth();
                                            Page.this.Return[objecttotal][3]=line.getHeight();
                                            Page.this.Return[objecttotal][4]=1;
                                            Page.this.Return[objecttotal][5]=1;
                                            Page.this.Return[objecttotal][8]=Page.this.parent.color.getRed();
                                            Page.this.Return[objecttotal][9]=Page.this.parent.color.getGreen();
                                            Page.this.Return[objecttotal][10]=Page.this.parent.color.getBlue();
                                            if(objecttotal2!=0)
                                            {
                                                objecttotal2=0;
                                                Page.this.parent.RedoBtn.setEnabled(false);
                                            }
                                            objecttotal++;
                                            if(Page.this.activeOBJ!=null)
                                            {
                                                activeOBJ.status=Status.idle;
                                            }
                                            Page.this.activeOBJ=line;
                                            if(activeOBJ!=null)
                                            {
                                                activeOBJ.status=Status.actived;
                                            }
                                            Page.this.repaint();
                                            
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
                                            Page.this.Return[objecttotal][0]=Entity.getX();
                                            Page.this.Return[objecttotal][1]=Entity.getY();
                                            Page.this.Return[objecttotal][2]=Entity.getWidth();
                                            Page.this.Return[objecttotal][3]=Entity.getHeight();
                                            Page.this.Return[objecttotal][4]=2;
                                            Page.this.Return[objecttotal][5]=1;
                                            Page.this.Return[objecttotal][8]=Page.this.parent.color.getRed();
                                            Page.this.Return[objecttotal][9]=Page.this.parent.color.getGreen();
                                            Page.this.Return[objecttotal][10]=Page.this.parent.color.getBlue();
                                            if(objecttotal2!=0)
                                            {
                                                objecttotal2=0;
                                                Page.this.parent.RedoBtn.setEnabled(false);
                                            }
                                            objecttotal++;
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
                                            Page.this.Return[objecttotal][0]=Relation.getX();
                                            Page.this.Return[objecttotal][1]=Relation.getY();
                                            Page.this.Return[objecttotal][2]=Relation.getWidth();
                                            Page.this.Return[objecttotal][3]=Relation.getHeight();
                                            Page.this.Return[objecttotal][4]=3;
                                            Page.this.Return[objecttotal][5]=1;
                                            Page.this.Return[objecttotal][8]=Page.this.parent.color.getRed();
                                            Page.this.Return[objecttotal][9]=Page.this.parent.color.getGreen();
                                            Page.this.Return[objecttotal][10]=Page.this.parent.color.getBlue();
                                            if(objecttotal2!=0)
                                            {
                                                objecttotal2=0;
                                                Page.this.parent.RedoBtn.setEnabled(false);
                                            }
                                            objecttotal++;
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
                                            Attribute attribute=new Attribute(Page.this.parent.color,Page.this);
                                            if((p1.x<p2.x)&&(p1.y<p2.y))
                                            {
                                                attribute.setSize(p2.x-p1.x,p2.y-p1.y);
                                                attribute.setLocation(p1.x, p1.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y>p2.y))
                                            {
                                                attribute.setSize(p1.x-p2.x,p1.y-p2.y);
                                                attribute.setLocation(p2.x, p2.y);
                                            }
                                            else if((p1.x>p2.x)&&(p1.y<p2.y))
                                            {
                                                attribute.setSize(p1.x-p2.x,p2.y-p1.y);
                                                attribute.setLocation(p2.x, p1.y);
                                            }
                                            else if((p1.x<p2.x)&&(p1.y>p2.y))
                                            {
                                                attribute.setSize(p2.x-p1.x,p1.y-p2.y);
                                                attribute.setLocation(p1.x, p2.y);
                                            }
                                            Page.this.add(attribute);
                                            objects.add(attribute);
                                            Page.this.Return[objecttotal][0]=attribute.getX();
                                            Page.this.Return[objecttotal][1]=attribute.getY();
                                            Page.this.Return[objecttotal][2]=attribute.getWidth();
                                            Page.this.Return[objecttotal][3]=attribute.getHeight();
                                            Page.this.Return[objecttotal][4]=4;
                                            Page.this.Return[objecttotal][5]=1;
                                            Page.this.Return[objecttotal][8]=Page.this.parent.color.getRed();
                                            Page.this.Return[objecttotal][9]=Page.this.parent.color.getGreen();
                                            Page.this.Return[objecttotal][10]=Page.this.parent.color.getBlue();
                                            if(objecttotal2!=0)
                                            {
                                                objecttotal2=0;
                                                Page.this.parent.RedoBtn.setEnabled(false);
                                            }
                                            objecttotal=objecttotal+1;
                                            if(Page.this.activeOBJ!=null)
                                            {
                                                activeOBJ.status=Status.idle;
                                            }
                                            Page.this.activeOBJ=attribute;
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
                                            if(Page.this.parent.parent.parent.status==Status.line)
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
        else if(activeOBJ==null)
        {
            cp.c(false);
        }
        if((Page.this.parent.parent.parent.re==Status.undo)&&(objecttotal>=0))
        {
            
            for(int i=0;i<Page.this.objecttotal;i++)
            {
                if((Return[i][5]==2)||(Return[i][5]==3))
                {
                    
                }
                else if((Return[i][0]==0)&&(Return[i][1]==0))
                {
                    
                }
                else if(Return[i][4]==1)
                {
                    Point p5=new Point();
                    Dimension d5=new Dimension();
                    p5.x=Return[i][0];
                    p5.y=Return[i][1];
                    d5.width=Return[i][2];
                    d5.height=Return[i][3];
                    Color c=new Color(Return[i][8],Return[i][9],Return[i][10]);
                    Undo undo=new Undo(Page.this,p5,d5,Status.line,c);
                    if(Return[i][7]==1)
                        b=true;
                    else if(Return[i][7]==0)
                        b=false;
                    undo.line(b);
                }
                else if(Return[i][4]==2)
                {
                    Point p5=new Point();
                    Dimension d5=new Dimension();
                    p5.x=Return[i][0];
                    p5.y=Return[i][1];
                    d5.width=Return[i][2];
                    d5.height=Return[i][3];
                    Color c=new Color(Return[i][8],Return[i][9],Return[i][10]);
                    Undo undo=new Undo(Page.this,p5,d5,Status.rect,c);
                }
                else if(Return[i][4]==3)
                {
                    Point p5=new Point();
                    Dimension d5=new Dimension();
                    p5.x=Return[i][0];
                    p5.y=Return[i][1];
                    d5.width=Return[i][2];
                    d5.height=Return[i][3];
                    Color c=new Color(Return[i][8],Return[i][9],Return[i][10]);
                    Undo undo=new Undo(Page.this,p5,d5,Status.diamond,c);
                }
                else if(Return[i][4]==4)
                {
                    Point p5=new Point();
                    Dimension d5=new Dimension();
                    p5.x=Return[i][0];
                    p5.y=Return[i][1];
                    d5.width=Return[i][2];
                    d5.height=Return[i][3];
                    Color c=new Color(Return[i][8],Return[i][9],Return[i][10]);
                    Undo undo=new Undo(Page.this,p5,d5,Status.oval,c);
                }
            }
            Page.this.repaint();
            Page.this.parent.parent.parent.re=Status.free;
        }
    }
}
