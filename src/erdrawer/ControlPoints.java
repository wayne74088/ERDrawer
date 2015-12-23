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
    Point p1,p2;
    boolean first;
    int x;
    ControlPoints(Page p)
    {
        parent = p;
        p1=new Point();
        p2=new Point();
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
        
        N.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        N.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if((d.height+(p1.y-p2.y))>=0)
                                            {
                                                d.height = d.height+(p1.y-p2.y);
                                                p.y=p.y-(p1.y-p2.y);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                ControlPoints.this.parent.activeOBJ.setLocation(p);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        NE.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        NE.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if(((d.height+(p1.y-p2.y))>=0)&&((d.width+(p2.x-p1.x))>=0))
                                            {
                                                d.height = d.height+(p1.y-p2.y);
                                                d.width = d.width+(p2.x-p1.x);
                                                p.y=p.y-(p1.y-p2.y);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                ControlPoints.this.parent.activeOBJ.setLocation(p);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        E.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        E.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if((d.width+(p2.x-p1.x))>=0)
                                            {
                                                d.width = d.width + (p2.x-p1.x);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        SE.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        SE.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if((d.height+(p2.y-p1.y)>=0)&&(d.width+(p2.x-p1.x)>=0))
                                            {
                                                d.height = d.height+(p2.y-p1.y);
                                                d.width = d.width+(p2.x-p1.x);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        S.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        S.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if(d.height+(p2.y-p1.y)>=0)
                                            {
                                                d.height = d.height+(p2.y-p1.y);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        SW.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        SW.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if((d.height+(p2.y-p1.y)>=0)&&(d.width+(p1.x-p2.x)>=0))
                                            {
                                                d.height = d.height+(p2.y-p1.y);
                                                d.width = d.width+(p1.x-p2.x);
                                                p.x=p.x-(p1.x-p2.x);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                ControlPoints.this.parent.activeOBJ.setLocation(p);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        W.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        W.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if(d.width+(p1.x-p2.x)>=0)
                                            {
                                                d.width = d.width+(p1.x-p2.x);
                                                p.x=p.x-(p1.x-p2.x);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                ControlPoints.this.parent.activeOBJ.setLocation(p);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
        NW.addMouseListener(new MouseAdapter()
                            {
                                public void mousePressed(MouseEvent e)
                                {
                                    first=true;
                                    ControlPoints.this.parent.activeOBJ.status=Status.reSize;
                                    p1.x = e.getXOnScreen();
                                    p1.y = e.getYOnScreen();
                                }
                                public void mouseReleased(MouseEvent e)
                                {
                                    ControlPoints.this.parent.activeOBJ.status=Status.actived;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.activeOBJ.getX();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.activeOBJ.getY();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.activeOBJ.getWidth();
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.activeOBJ.getHeight();
                                    if(ControlPoints.this.parent.activeOBJ.ss== Status.line)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=1;
                                        if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=1;
                                        }
                                        else if(ControlPoints.this.parent.activeOBJ.linestatus==true)
                                        {
                                            ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][7]=0;
                                        }
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.rect)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=2;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.diamond)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=3;
                                    }
                                    else if(ControlPoints.this.parent.activeOBJ.ss== Status.oval)
                                    {
                                        ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=4;
                                    }
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=1;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                    ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                    ControlPoints.this.parent.objecttotal++;
                                    ControlPoints.this.parent.repaint();
                                }
                            });
        NW.addMouseMotionListener(new MouseAdapter()
                                    {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            p2.x = e.getXOnScreen();
                                            p2.y = e.getYOnScreen();
                                            Point p=ControlPoints.this.parent.activeOBJ.getLocation();
                                            Dimension d=ControlPoints.this.parent.activeOBJ.getSize();
                                            if(first==true)
                                            {
                                                x=ControlPoints.this.parent.objecttotal-1;
                                                while(ControlPoints.this.parent.activeOBJ!=null)
                                                {
                                                    if((ControlPoints.this.parent.Return[x][0]==ControlPoints.this.parent.activeOBJ.getX())&&(ControlPoints.this.parent.Return[x][1]==ControlPoints.this.parent.activeOBJ.getY()))
                                                    {
                                                        break;
                                                    }
                                                    else
                                                    {
                                                        x--;
                                                    }
                                                }
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][0]=ControlPoints.this.parent.Return[x][0];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][1]=ControlPoints.this.parent.Return[x][1];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][2]=ControlPoints.this.parent.Return[x][2];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][3]=ControlPoints.this.parent.Return[x][3];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][4]=ControlPoints.this.parent.Return[x][4];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][5]=3;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][6]=x;
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][8]=ControlPoints.this.parent.Return[x][8];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][9]=ControlPoints.this.parent.Return[x][9];
                                                ControlPoints.this.parent.Return[ControlPoints.this.parent.objecttotal][10]=ControlPoints.this.parent.Return[x][10];
                                                ControlPoints.this.parent.Return[x][0]=0;
                                                ControlPoints.this.parent.Return[x][1]=0;
                                                ControlPoints.this.parent.objecttotal++;
                                                first=false;
                                            }
                                            if((d.height+(p1.y-p2.y)>=0)&&(d.width+(p1.x-p2.x)>=0))
                                            {
                                                d.height = d.height+(p1.y-p2.y);
                                                d.width = d.width+(p1.x-p2.x);
                                                p.x=p.x-(p1.x-p2.x);
                                                p.y=p.y-(p1.y-p2.y);
                                                ControlPoints.this.parent.activeOBJ.setSize(d);
                                                ControlPoints.this.parent.activeOBJ.setLocation(p);
                                                p1.x=p2.x;
                                                p1.y=p2.y;
                                            }
                                            ControlPoints.this.parent.repaint();
                                        }
                                    });
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
