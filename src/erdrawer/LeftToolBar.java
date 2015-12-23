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
public class LeftToolBar extends JPanel{
    MyWindow parent;
    Color color=Color.black,color1;
    ImageButton lineBtn,entitysetBtn,diamondBtn,ovalBtn,setColorBtn,DeleteBtn;
    LeftToolBar(MyWindow p)
    {
        parent=p;
        this.setLayout(new GridLayout(8,1));
        this.setBackground(Color.GRAY);
        lineBtn=new ImageButton(new ImageIcon("img/line.png"));
        this.add(lineBtn);
        entitysetBtn=new ImageButton(new ImageIcon("img/rect.png"));
        this.add(entitysetBtn);
        diamondBtn=new ImageButton(new ImageIcon("img/diamond.png"));
        this.add(diamondBtn);
        ovalBtn=new ImageButton(new ImageIcon("img/oval.png"));
        this.add(ovalBtn);
        
        lineBtn.addMouseListener(new MouseAdapter()
                                    {
                                        public void mouseClicked(MouseEvent e)
                                        {
                                            Page cp=LeftToolBar.this.parent.parent.curPage;
                                            if(LeftToolBar.this.parent.parent.status==Status.line)
                                            {
                                                LeftToolBar.this.parent.parent.status=Status.free;
                                                LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                            }
                                            else
                                            {
                                                LeftToolBar.this.parent.parent.status=Status.line;
                                                LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                            }
                                            
                                        }
                                    }
                                );

        entitysetBtn.addMouseListener(new MouseAdapter()
                                        {
                                            public void mouseClicked(MouseEvent e)
                                            {
                                                Page cp=LeftToolBar.this.parent.parent.curPage;
                                                if(LeftToolBar.this.parent.parent.status==Status.rect)
                                                {
                                                    LeftToolBar.this.parent.parent.status=Status.free;
                                                    LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                                }
                                                else
                                                {
                                                    LeftToolBar.this.parent.parent.status=Status.rect;
                                                    LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                                }
                                            }
                                        }
                                     );

        diamondBtn.addMouseListener(new MouseAdapter()
                                            {
                                                public void mouseClicked(MouseEvent e)
                                                {
                                                    Page cp=LeftToolBar.this.parent.parent.curPage;
                                                    if(LeftToolBar.this.parent.parent.status==Status.diamond)
                                                    {
                                                        LeftToolBar.this.parent.parent.status=Status.free;
                                                        LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                                    }
                                                    else
                                                    {
                                                        LeftToolBar.this.parent.parent.status=Status.diamond;
                                                        LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                                    }
                                                }
                                            }
                                   );

        ovalBtn.addMouseListener(new MouseAdapter()
                                            {
                                                public void mouseClicked(MouseEvent e)
                                                {
                                                    Page cp=LeftToolBar.this.parent.parent.curPage;
                                                    if(LeftToolBar.this.parent.parent.status==Status.oval)
                                                    {
                                                        LeftToolBar.this.parent.parent.status=Status.free;
                                                        LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                                    }
                                                    else
                                                    {
                                                        LeftToolBar.this.parent.parent.status=Status.oval;
                                                        LeftToolBar.this.parent.mb.updateInfo(cp,null);
                                                    }
                                                }
                                            }
                                   );
    }
    
}
