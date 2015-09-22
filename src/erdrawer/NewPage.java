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
public class NewPage extends Panel{
    static int x;
    NewPage()
    {
        super();
        x++;
        switch(x)
        {
            case 1:
                this.setBackground(Color.white);  
                break;
            case 2:
                this.setBackground(Color.BLACK);  
                break;
            case 3:
                this.setBackground(Color.BLUE);  
                break;
            case 4:
                this.setBackground(Color.CYAN);  
                break;
            case 5:
                this.setBackground(Color.GREEN);  
                break;
            case 6:
                this.setBackground(Color.ORANGE);  
                break;
        }
    }
}
