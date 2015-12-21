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
    boolean first;
    Point p1,p2,m1,m2,s1;
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
                                                    s1.x=p1.x;
                                                    s1.y=p1.y;
                                                    d1=OBJ.this.getSize();
                                                    OBJ.this.parent.objects.insertElementAt(OBJ.this, OBJ.this.parent.objecttotal);
                                                    Undo undo= new Undo(parent,s1,d1,ss);
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
                                            if(OBJ.this.parent.objects.size()<OBJ.this.parent.objecttotal+1)
                                            {
                                                OBJ.this.parent.objects.setElementAt( OBJ.this, OBJ.this.parent.objecttotal);
                                            }
                                            else 
                                            {
                                                OBJ.this.parent.objects.setElementAt( OBJ.this, OBJ.this.parent.objecttotal);
                                                for(int i=OBJ.this.parent.objecttotal+1;i<OBJ.this.parent.objects.size();)
                                                {
                                                    OBJ.this.parent.objects.remove(i);
                                                }
                                            }
                                            OBJ.this.parent.objecttotal=OBJ.this.parent.objecttotal+1;
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
