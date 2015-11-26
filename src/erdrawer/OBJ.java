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
    Status status;
    OBJ(Page p)
    {
        parent = p;
        this.addMouseListener(new MouseAdapter()
                                {
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
                                                status=Status.actived;
                                            }
                                        }
                                        OBJ.this.parent.repaint();
                                    }
                                }
                            );
    }

}
