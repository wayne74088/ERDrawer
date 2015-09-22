/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erdrawer;
import java.util.Vector;
/**
 *
 * @author User
 */
public class ERDrawer {
    Vector<NewPage> pages;
    NewPage curPage;
    ERDrawer()
    {
     MyWindow mywin=new MyWindow(this);
     pages=new Vector<NewPage>();
     curPage=null;
    }
}
