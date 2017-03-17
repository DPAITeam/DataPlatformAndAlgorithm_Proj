package javaSwing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import view.util.AlgorithmListener;
import view.util.ComboBoxList;
import view.util.MouseAdapterImp;
import view.util.SelectFileListener;

public class swingClass extends JFrame
{

	public swingClass() {
		

	}
	
	public void createAndShowGUI() throws SAXException, IOException, ParserConfigurationException {
		
           JFrame frame = new JFrame("FlowLayoutDemo");
           frame.setLayout(null);
           frame.setBounds(150,150,700,500);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		   addComponentsToPane(frame);
	
		   //frame.pack();
		   frame.setVisible(true);
		}
	public void addComponentsToPane(JFrame f) throws SAXException, IOException, ParserConfigurationException {
		Container pane = f.getContentPane();
		pane.setLayout(null);
		pane.setSize(f.getSize());
		int x = f.getWidth();
		x = (x - 80*4 - 30)/2;
		JComboBox comboBox=new JComboBox();
		comboBox.setBounds(x, 0, 80,30);
		
		ComboBoxList s1 = new ComboBoxList();
		//comboBox.set
		pane.add(comboBox);
		ArrayList rt = s1.getName();
		for(int t=0;t<rt.size();t++)
		 comboBox.addItem(rt.get(t));
		
		
		JComboBox comboBox1=new JComboBox();
		comboBox1.setBounds(x+90,0, 80,30);
		pane.add(comboBox1);
		ArrayList rt1 = (ArrayList) s1.getMap().get(rt.get(0));
		for(int t=0;t<rt1.size();t++)
		comboBox1.addItem(rt1.get(t));
		
		comboBox.addItemListener(new AlgorithmListener(s1, comboBox1));
		
		JComboBox comboBox2=new JComboBox();
		comboBox2.setBounds(x+180, 0, 80,30);
		pane.add(comboBox2);
		comboBox2.addItem("文件");
		comboBox2.addItem("粘贴文本");
		JButton bt = new JButton("Upload");
		bt.setBounds(x+270, 0, 80,30);
		//JButton bt = new JButton("Upload");
		pane.add(bt);
		JTextArea te = new JTextArea();
		te.setEditable(false);
		bt.setEnabled(true);
		te.setBackground(new Color(144,144,144));
		
		MouseAdapter ser = new MouseAdapterImp();
		bt.addMouseListener(ser);
		comboBox2.addItemListener(new SelectFileListener(bt,te,ser));
		//pane.add(bt);
		//pane.add(new JButton("5"));
		
		
		//te.setBackground(new Color(199,237,204));
		te.setFont(new Font("Times New Roman",Font.PLAIN,20));
		te.setBounds(0, 40, pane.getWidth(), pane.getHeight() - comboBox2.getHeight() - 100);
		pane.add(te);
		JButton te2 = new JButton("提交");
		te2.setBounds(f.getWidth() - 100, f.getHeight() - comboBox2.getHeight() - 50, 80, 30);
		pane.add(te2);
		}
	
	

	

}
