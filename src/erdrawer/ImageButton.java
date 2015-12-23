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
public class ImageButton extends JButton{
    public ImageButton(ImageIcon icon){
		setSize(icon.getImage().getWidth(null),
				icon.getImage().getHeight(null));
		setIcon(icon);
		//setMargin(new Insets(0,0,0,0));//将边框外的上下左右空间设置为0
		//setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0
		//setBorderPainted(false);//不打印边框
		//setBorder(null);//除去边框
                //setText(null);//除去按钮的默认名称
		setFocusPainted(false);//除去焦点的框
		//setContentAreaFilled(false);//除去默认的背景填充
	}
}
