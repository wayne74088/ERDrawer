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
public class OBJ extends Component
{
    Page parent;
    Status status=Status.idle,ss;
    boolean first,linestatus;
    Point p1,p2,m1,m2,s1;
    int x;
    Dimension d1;
    OBJ(Page p,Status s)
    {
        parent = p;
        ss=s;
        first=true;
        s1=new Point();
        d1=new Dimension();
        p1=new Point();
        p2=new Point();
        m1=new Point();
        m2=new Point();
        this.addMouseMotionListener(new MouseAdapter()
                                        {
                                        public void mouseDragged(MouseEvent e)
                                        {
                                            if(status==Status.actived)
                                            {
                                                if(first==true)
                                                {   
                                                    x=OBJ.this.parent.objecttotal-1;
                                                    while(OBJ.this.parent.activeOBJ!=null)
                                                    {
                                                        if((OBJ.this.parent.Return[x][0]==OBJ.this.getX())&&(OBJ.this.parent.Return[x][1]==OBJ.this.getY()))
                                                        {
                                                            break;
                                                        }
                                                        else
                                                        {
                                                            x--;
                                                        }
                                                    }
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][0]=OBJ.this.parent.Return[x][0];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][1]=OBJ.this.parent.Return[x][1];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][2]=OBJ.this.parent.Return[x][2];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][3]=OBJ.this.parent.Return[x][3];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][4]=OBJ.this.parent.Return[x][4];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][5]=3;
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][6]=x;
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][8]=OBJ.this.parent.Return[x][8];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][9]=OBJ.this.parent.Return[x][9];
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][10]=OBJ.this.parent.Return[x][10];
                                                    OBJ.this.parent.Return[x][1]=0;
                                                    OBJ.this.parent.Return[x][2]=0;
                                                    OBJ.this.parent.objecttotal++;
                                                    first=false;
                                                }
                                                m2.x=e.getXOnScreen();
                                                m2.y=e.getYOnScreen();
                                                p2.x=p1.x+(m2.x-m1.x);
                                                p2.y=p1.y+(m2.y-m1.y);
                                                OBJ.this.setLocation(p2);
                                                p1=p2;
                                                m1.x=m2.x;
                                                m1.y=m2.y;
                                                OBJ.this.parent.repaint();
                                            }
                                        }
                                        }
                                    );
        this.addMouseListener(new MouseAdapter()
                                {
                                    
                                    
                                    public void mousePressed(MouseEvent e)
                                    {
                                        if(status==Status.actived)
                                        {
                                            first=true;
                                            p1=OBJ.this.getLocation();
                                            m1.x=e.getXOnScreen();
                                            m1.y=e.getYOnScreen();
                                        }
                                    }
                                    
                                    public void mouseReleased(MouseEvent e)
                                    {
                                        if(status==Status.actived)
                                        {
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][0]=OBJ.this.getX();
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][1]=OBJ.this.getY();
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][2]=OBJ.this.getWidth();
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][3]=OBJ.this.getHeight();
                                            if(ss==Status.line)
                                            {
                                                OBJ.this.parent.Return[OBJ.this.parent.objecttotal][4]=1;
                                                if(linestatus==true)
                                                {
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][7]=1;
                                                }
                                                else
                                                {
                                                    OBJ.this.parent.Return[OBJ.this.parent.objecttotal][7]=0;
                                                }
                                            }
                                            else if(ss==Status.rect)
                                            {
                                                OBJ.this.parent.Return[OBJ.this.parent.objecttotal][4]=2;
                                            }
                                            else if(ss==Status.diamond)
                                            {
                                                OBJ.this.parent.Return[OBJ.this.parent.objecttotal][4]=3;
                                            }
                                            else if(ss==Status.oval)
                                            {
                                                OBJ.this.parent.Return[OBJ.this.parent.objecttotal][4]=4;
                                            }
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][5]=1;
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][6]=x;
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][8]=OBJ.this.parent.Return[x][8];
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][9]=OBJ.this.parent.Return[x][9];
                                            OBJ.this.parent.Return[OBJ.this.parent.objecttotal][10]=OBJ.this.parent.Return[x][10];
                                            if(OBJ.this.parent.objecttotal2!=0)
                                            {
                                                OBJ.this.parent.objecttotal2=0;
                                                OBJ.this.parent.parent.RedoBtn.setEnabled(false);
                                            }
                                            OBJ.this.parent.objecttotal++;
                                            OBJ.this.parent.repaint();
                                           
                                        }
                                    }
                                    
                                    public void mouseClicked(MouseEvent e)
                                    {
                                        if(status==Status.idle)
                                        {
                                            if(OBJ.this.parent.activeOBJ!=null)
                                            {
                                                status=Status.actived;
                                                OBJ.this.parent.activeOBJ.status=Status.idle;
                                                OBJ.this.parent.activeOBJ=OBJ.this;
                                            }
                                            else
                                            {
                                                OBJ.this.parent.activeOBJ=OBJ.this;
                                                //System.out.println(OBJ.this.parent.activeOBJ.status);
                                                status=Status.actived;
                                                //System.out.println(OBJ.this.parent.activeOBJ.status);
                                            }
                                        }
                                        /*else if(status==Status.actived)
                                        {
                                            OBJ.this.parent.activeOBJ.status=Status.idle;
                                            OBJ.this.parent.activeOBJ=null;
                                        }*/
                                        //OBJ.this.parent.activeOBJ=OBJ.this;
                                        OBJ.this.parent.repaint();
                                    }
                                }
                            );
    }

}
