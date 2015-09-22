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
public class ToolBar extends Panel{
    MyWindow parent;
    
    Button newPageBtn,nextPageBtn, prevPageBtn, firstPageBtn, lastPageBtn;
    
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
                                            NewPage np=new NewPage();
                                            NewPage cp=ToolBar.this.parent.parent.curPage;
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
                                                NewPage cp=ToolBar.this.parent.parent.curPage;
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
                                                
                                                    NewPage pp=ToolBar.this.parent.parent.pages.elementAt(loc1-1);
                                                    ToolBar.this.parent.add(pp,BorderLayout.CENTER);
                                                    ToolBar.this.parent.mb.updateInfo(pp);
                                                    ToolBar.this.parent.parent.curPage=pp;
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
                                                NewPage cp=ToolBar.this.parent.parent.curPage;
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
                                                    NewPage np=ToolBar.this.parent.parent.pages.elementAt(loc1+1);
                                                    ToolBar.this.parent.add(np);
                                                    ToolBar.this.parent.mb.updateInfo(np);
                                                    ToolBar.this.parent.parent.curPage=np;
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
                                                NewPage cp=ToolBar.this.parent.parent.curPage;
                                                if(cp!=null)
                                                {
                                                    ToolBar.this.parent.remove(cp);
                                                }
                                                int loc1=0;
                                                NewPage fp=ToolBar.this.parent.parent.pages.elementAt(loc1);
                                                ToolBar.this.parent.add(fp,BorderLayout.CENTER);
                                                ToolBar.this.parent.mb.updateInfo(fp);
                                                ToolBar.this.parent.parent.curPage=fp;
                                            }
                                        }
                                     );
        
        lastPageBtn=new Button("LastPage");
        this.add(lastPageBtn);
        lastPageBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                               NewPage cp=ToolBar.this.parent.parent.curPage;
                                               if(cp!=null)
                                               {
                                                   ToolBar.this.parent.remove(cp);
                                               }
                                               int loc1=ToolBar.this.parent.parent.pages.size()-1; 
                                               NewPage lp=ToolBar.this.parent.parent.pages.elementAt(loc1);
                                               ToolBar.this.parent.add(lp,BorderLayout.CENTER);
                                               ToolBar.this.parent.parent.curPage=lp;
                                               ToolBar.this.parent.mb.updateInfo(lp);
                                            }
                                        }
                                    );
    }
}
