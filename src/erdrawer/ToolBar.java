/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.JColorChooser;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.*;
/**
 *
 * @author Wayne
 */

public class ToolBar extends JPanel{
    MyWindow parent;
    Color color=Color.black,color1;
    Button newPageBtn,nextPageBtn, prevPageBtn, firstPageBtn, lastPageBtn,lineBtn,entitysetBtn,rectBtn,diamondBtn,ovalBtn,setColorBtn,DeleteBtn,UndoBtn,RedoBtn;
    int x;
    ToolBar(MyWindow p)
    {
        super();
        parent=p;
        this.setBackground(Color.red);
        this.setLayout(new FlowLayout());
        newPageBtn=new Button("NewPage");
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter()
                                     {
                                        public void mouseClicked(MouseEvent e)
                                        {
                                            Page np=new Page(ToolBar.this);
                                            Page cp=ToolBar.this.parent.parent.curPage;
                                            if(cp!=null)
                                            {
                                                ToolBar.this.parent.remove(cp);
                                            }    
                                            ToolBar.this.parent.add(np,BorderLayout.CENTER);
                                            ToolBar.this.parent.parent.pages.add(np);
                                            ToolBar.this.parent.parent.curPage=np;
                                            ToolBar.this.parent.mb.updateInfo(np);
                                            /* MyWindow.this.setVisible(false);
                                            MyWindow.this.setVisible(true);*/
                                            ToolBar.this.parent.revalidate();
                                        }
                                     }   
                                    );
        
        prevPageBtn=new Button("PrevPage");
        this.add(prevPageBtn);
        prevPageBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                Page cp=ToolBar.this.parent.parent.curPage;
                                                int loc1=ToolBar.this.parent.parent.pages.indexOf(cp);
                                                if(loc1<=0)
                                                {
                                                    
                                                }
                                                else
                                                {
                                                    if(cp!=null)
                                                    {
                                                        ToolBar.this.parent.remove(cp);
                                                    }
                                                
                                                    Page pp=ToolBar.this.parent.parent.pages.elementAt(loc1-1);
                                                    ToolBar.this.parent.add(pp,BorderLayout.CENTER);
                                                    ToolBar.this.parent.mb.updateInfo(pp);
                                                    ToolBar.this.parent.parent.curPage=pp;
                                                    ToolBar.this.parent.parent.curPage.repaint();
                                                }
                                            }
                                        }
                                    );
        
        nextPageBtn=new Button("NextPage");
        this.add(nextPageBtn);
        nextPageBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                Page cp=ToolBar.this.parent.parent.curPage;
                                                int loc1=ToolBar.this.parent.parent.pages.indexOf(cp);
                                                if(loc1>=(ToolBar.this.parent.parent.pages.size()-1))
                                                {
                                                    
                                                }
                                                else
                                                {
                                                    if(cp!=null)
                                                    {
                                                        ToolBar.this.parent.remove(cp);
                                                    }
                                                    Page np=ToolBar.this.parent.parent.pages.elementAt(loc1+1);
                                                    ToolBar.this.parent.add(np);
                                                    ToolBar.this.parent.mb.updateInfo(np);
                                                    ToolBar.this.parent.parent.curPage=np;
                                                    ToolBar.this.parent.parent.curPage.repaint();
                                                }
                                            }
                                        }
                                    );
        
        firstPageBtn=new Button("FirstPage");
        this.add(firstPageBtn);
        firstPageBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                Page cp=ToolBar.this.parent.parent.curPage;
                                                if(ToolBar.this.parent.parent.pages.size()!=0)
                                                {
                                                    if(cp!=null)
                                                    {
                                                        ToolBar.this.parent.remove(cp);
                                                    }
                                                    int loc1=0;
                                                    Page fp=ToolBar.this.parent.parent.pages.elementAt(loc1);
                                                    ToolBar.this.parent.add(fp,BorderLayout.CENTER);
                                                    ToolBar.this.parent.mb.updateInfo(fp);
                                                    ToolBar.this.parent.parent.curPage=fp;
                                                    ToolBar.this.parent.parent.curPage.repaint();
                                                }
                                            }
                                        }
                                     );
        
        lastPageBtn=new Button("LastPage");
        this.add(lastPageBtn);
        lastPageBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                Page cp=ToolBar.this.parent.parent.curPage;
                                                if(ToolBar.this.parent.parent.pages.size()!=0)
                                                {
                                                    if(cp!=null)
                                                    {
                                                        ToolBar.this.parent.remove(cp);
                                                    }
                                                    int loc1=ToolBar.this.parent.parent.pages.size()-1; 
                                                    Page lp=ToolBar.this.parent.parent.pages.elementAt(loc1);
                                                    ToolBar.this.parent.add(lp,BorderLayout.CENTER);
                                                    ToolBar.this.parent.parent.curPage=lp;
                                                    ToolBar.this.parent.mb.updateInfo(lp);
                                                    ToolBar.this.parent.parent.curPage.repaint();
                                                }
                                            }
                                        }
                                    );
                
        lineBtn=new Button("Line");
        this.add(lineBtn);
        lineBtn.addMouseListener(new MouseAdapter()
                                    {
                                        public void mouseClicked(MouseEvent e)
                                        {
                                            Page cp=ToolBar.this.parent.parent.curPage;
                                            if(ToolBar.this.parent.parent.status==Status.line)
                                            {
                                                ToolBar.this.parent.parent.status=Status.free;
                                                ToolBar.this.parent.mb.updateInfo(cp);
                                            }
                                            else
                                            {
                                                ToolBar.this.parent.parent.status=Status.line;
                                                ToolBar.this.parent.mb.updateInfo(cp);
                                            }
                                            
                                        }
                                    }
                                );
        rectBtn=new Button("Rect");
        this.add(rectBtn);
        rectBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                Page cp=ToolBar.this.parent.parent.curPage;
                                                if(ToolBar.this.parent.parent.status==Status.rect)
                                                {
                                                    ToolBar.this.parent.parent.status=Status.free;
                                                    ToolBar.this.parent.mb.updateInfo(cp);
                                                }
                                                else
                                                {
                                                    ToolBar.this.parent.parent.status=Status.rect;
                                                    ToolBar.this.parent.mb.updateInfo(cp);
                                                }
                                            }
                                        }
                                     );
        diamondBtn=new Button("Diamond");
        this.add(diamondBtn);
        diamondBtn.addMouseListener(new MouseAdapter()
                                            {
                                                public void mouseClicked(MouseEvent e)
                                                {
                                                    Page cp=ToolBar.this.parent.parent.curPage;
                                                    if(ToolBar.this.parent.parent.status==Status.diamond)
                                                    {
                                                        ToolBar.this.parent.parent.status=Status.free;
                                                        ToolBar.this.parent.mb.updateInfo(cp);
                                                    }
                                                    else
                                                    {
                                                        ToolBar.this.parent.parent.status=Status.diamond;
                                                        ToolBar.this.parent.mb.updateInfo(cp);
                                                    }
                                                }
                                            }
                                   );
        ovalBtn=new Button("Oval");
        this.add(ovalBtn);
        ovalBtn.addMouseListener(new MouseAdapter()
                                            {
                                                public void mouseClicked(MouseEvent e)
                                                {
                                                    Page cp=ToolBar.this.parent.parent.curPage;
                                                    if(ToolBar.this.parent.parent.status==Status.oval)
                                                    {
                                                        ToolBar.this.parent.parent.status=Status.free;
                                                        ToolBar.this.parent.mb.updateInfo(cp);
                                                    }
                                                    else
                                                    {
                                                        ToolBar.this.parent.parent.status=Status.oval;
                                                        ToolBar.this.parent.mb.updateInfo(cp);
                                                    }
                                                }
                                            }
                                   );
        setColorBtn=new Button("SetColor");
        this.add(setColorBtn);
        setColorBtn.addMouseListener(new MouseAdapter()
                                            {
                                                public void mouseClicked(MouseEvent e)
                                                {
                                                    color1=color;
                                                    color = JColorChooser.showDialog( null, "Select Color", color);
                                                    if(color==null)
                                                    {
                                                        color=color1;
                                                    }
                                                }
                                            }
                                    );
        DeleteBtn = new Button("Delete");
        this.add(DeleteBtn);
        DeleteBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                if(ToolBar.this.parent.parent.curPage.activeOBJ!=null)
                                                {
                                                    if(ToolBar.this.parent.parent.curPage.activeOBJ.status==Status.actived)
                                                    {
                                                        ToolBar.this.parent.parent.curPage.activeOBJ.status=Status.idle;
                                                        
                                                        Point p1=new Point();
                                                        p1=ToolBar.this.parent.parent.curPage.activeOBJ.getLocation();
                                                        x=ToolBar.this.parent.parent.curPage.objecttotal-1;
                                                        while(ToolBar.this.parent.parent.curPage.activeOBJ!=null)
                                                        {
                                                            if((ToolBar.this.parent.parent.curPage.Return[x][0]==p1.x)&&(ToolBar.this.parent.parent.curPage.Return[x][1]==p1.y))
                                                            {
                                                                break;
                                                            }
                                                            else
                                                            {
                                                                x--;
                                                            }
                                                        }
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][0]= ToolBar.this.parent.parent.curPage.Return[x][0];
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][1]= ToolBar.this.parent.parent.curPage.Return[x][1];
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][2]= ToolBar.this.parent.parent.curPage.Return[x][2];
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][3]= ToolBar.this.parent.parent.curPage.Return[x][3];
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][4]= ToolBar.this.parent.parent.curPage.Return[x][4];
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][5]=2;
                                                        ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]=x;
                                                        ToolBar.this.parent.parent.curPage.Return[x][0]=0;
                                                        ToolBar.this.parent.parent.curPage.Return[x][1]=0;
                                                        ToolBar.this.parent.parent.curPage.objects.add(ToolBar.this.parent.parent.curPage.activeOBJ);
                                                        ToolBar.this.parent.parent.curPage.remove(ToolBar.this.parent.parent.curPage.activeOBJ);
                                                        ToolBar.this.parent.parent.curPage.objecttotal=ToolBar.this.parent.parent.curPage.objecttotal+1;
                                                        //ToolBar.this.parent.parent.curPage.activeOBJ.setVisible(false);
                                                        if(ToolBar.this.parent.parent.curPage.activeOBJ!=null)
                                                        {
                                                            ToolBar.this.parent.parent.curPage.activeOBJ=null;
                                                        }
                                                        ToolBar.this.parent.parent.curPage.repaint();
                                                    }
                                                }
                                            }
                                        });
        UndoBtn = new Button("Undo");
        this.add(UndoBtn);
        UndoBtn.addMouseListener(new MouseAdapter()
                                    {
                                        public void mouseClicked(MouseEvent e)
                                        {
                                            if(ToolBar.this.parent.parent.curPage.objecttotal>0)
                                            {
                                                ToolBar.this.parent.parent.curPage.objecttotal--;
                                                int b=ToolBar.this.parent.parent.curPage.objects.size();
                                                
                                                if(ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][5]==2)
                                                {
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][0]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][0];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][1]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][1];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][2]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][2];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][3]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][3];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][4]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][4];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][5]=1;
                                                }
                                                if(ToolBar.this.parent.parent.curPage.objecttotal-1>=0)
                                                {
                                                if(ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal-1][5]==3)
                                                {
                                                    ToolBar.this.parent.parent.curPage.objecttotal=ToolBar.this.parent.parent.curPage.objecttotal-1;
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][0]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][0];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][1]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][1];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][2]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][2];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][3]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][3];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][4]=ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][4];
                                                    ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.Return[ToolBar.this.parent.parent.curPage.objecttotal][6]][5]=1;
                                                }
                                                }
                                                
                                                for(int i=b-1;i>=0;i--)
                                                {
                                                    ToolBar.this.parent.parent.curPage.remove(ToolBar.this.parent.parent.curPage.objects.get(i));
                                                    ToolBar.this.parent.parent.curPage.objects.remove(i);
                                                }
                                                ToolBar.this.parent.parent.curPage.activeOBJ=null;
                                                ToolBar.this.parent.parent.re=Status.undo;
                                                ToolBar.this.parent.parent.curPage.repaint();
                                            }
                                        }
                                    });
    }
}
