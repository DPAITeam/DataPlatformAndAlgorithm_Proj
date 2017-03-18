package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import view.util.AlgorithmListener;
import view.util.ComboBoxList;
import view.util.MouseAdapterCommitimp;
import view.util.MouseAdapterImp;
import view.util.SelectFileListener;

public class MainView {
    
	private JComboBox algorithmClass=null;
	private JComboBox algorithmInClass = null;
	private JComboBox iOtype = null;
	private JComboBox operationType = null;
	private JButton upload = null;
	private JTextArea inputText = null;
	private JButton commit = null;
	private JLabel idDemesionLable = null;
	private JTextField idDemesion = null;
	private ComboBoxList boxlist = null;
	private File[] files=null;
	public MainView() throws Exception
	{
		this.algorithmClass=new JComboBox();
		this.algorithmInClass = new JComboBox();
		this.iOtype = new JComboBox();
		this.operationType = new JComboBox();
		this.upload = new JButton("upload");
		this.inputText = new  JTextArea();
		this.commit = new JButton("Commit");
		this.idDemesionLable = new JLabel();
		this.idDemesion = new JTextField();
		this.boxlist = new ComboBoxList();
	}
	
	public void createAndShowGUI() throws SAXException, IOException, ParserConfigurationException {
		
        JFrame frame = new JFrame("PlatformStart");
        frame.setLayout(null);
        frame.setBounds(150,150,700,500);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		   addComponentsToPane(frame);
	
		   //frame.pack();
		   frame.setVisible(true);
		}
	public void addComponentsToPane(JFrame f) throws SAXException, IOException, ParserConfigurationException
	{
		Container pane = f.getContentPane();
		pane.setLayout(null);
		pane.setSize(f.getSize());
		int x = f.getWidth();
		x = (x - 80*5 - 40)/2;
		
		this.idDemesionLable.setText("dataOutputDemssion");
		this.algorithmClass.setBounds(x, 0, 80,30);
		this.algorithmInClass.setBounds(x+90, 0, 80,30);
		this.iOtype.setBounds(x+180, 0, 80,30);
		this.operationType.setBounds(x+270, 0, 80,30);
		this.idDemesion.setBounds(130,f.getHeight() - this.algorithmInClass.getHeight() - 50,80,30);
		this.idDemesionLable.setBounds(3,f.getHeight() - this.algorithmInClass.getHeight() - 50,120,30);
		this.upload.setBounds(x+360, 0, 80,30);
		this.inputText.setBounds(0, 40, pane.getWidth(), pane.getHeight() - this.algorithmInClass.getHeight() - 100);
		this.commit.setBounds(f.getWidth() - 100, f.getHeight() - this.algorithmInClass.getHeight() - 50, 80, 30);
		
		this.inputText.setFont(new Font("Times New Roman",Font.PLAIN,20));
		
		this.inputText.setEditable(false);
		this.upload.setEnabled(true);
		this.inputText.setBackground(new Color(144,144,144));
		
		pane.add(this.algorithmClass);
		pane.add(this.algorithmInClass);
		pane.add(this.iOtype);
		pane.add(this.operationType);
		pane.add(this.upload);
		pane.add(this.inputText);
		pane.add(this.idDemesionLable);
		pane.add(this.commit);
		pane.add(this.idDemesion);
		
		ArrayList classNameList = this.boxlist.getName();
		for(int t=0;t<classNameList.size();t++)
			this.algorithmClass.addItem(classNameList.get(t));
		
		ArrayList first = (ArrayList) this.boxlist.getMap().get(classNameList.get(0));
		for(int t=0;t<first.size();t++)
			this.algorithmInClass.addItem(first.get(t));
		
		this.iOtype.addItem("file");
		this.iOtype.addItem("paste_text");
		this.operationType.addItem("test_or_work");
		this.operationType.addItem("train");
		
		this.algorithmClass.addItemListener(new AlgorithmListener(boxlist,this.algorithmInClass));
		
		
		MouseAdapter mouseada = new MouseAdapterImp();
		this.upload.addMouseListener(mouseada);
		this.iOtype.addItemListener(new SelectFileListener(this.upload,this.inputText,mouseada));
		this.commit.addMouseListener(new MouseAdapterCommitimp(this));
		
	}

	public JComboBox getAlgorithmClass() {
		return algorithmClass;
	}

	public void setAlgorithmClass(JComboBox algorithmClass) {
		this.algorithmClass = algorithmClass;
	}

	public JComboBox getAlgorithmInClass() {
		return algorithmInClass;
	}

	public void setAlgorithmInClass(JComboBox algorithmInClass) {
		this.algorithmInClass = algorithmInClass;
	}

	public JComboBox getiOtype() {
		return iOtype;
	}

	public void setiOtype(JComboBox iOtype) {
		this.iOtype = iOtype;
	}

	public JComboBox getOperationType() {
		return operationType;
	}

	public void setOperationType(JComboBox operationType) {
		this.operationType = operationType;
	}

	public JButton getUpload() {
		return upload;
	}

	public void setUpload(JButton upload) {
		this.upload = upload;
	}

	public JTextArea getInputText() {
		return inputText;
	}

	public void setInputText(JTextArea inputText) {
		this.inputText = inputText;
	}

	public JButton getCommit() {
		return commit;
	}

	public void setCommit(JButton commit) {
		this.commit = commit;
	}

	public JLabel getIdDemesionLable() {
		return idDemesionLable;
	}

	public void setIdDemesionLable(JLabel idDemesionLable) {
		this.idDemesionLable = idDemesionLable;
	}

	public JTextField getIdDemesion() {
		return idDemesion;
	}

	public void setIdDemesion(JTextField idDemesion) {
		this.idDemesion = idDemesion;
	}

	public ComboBoxList getBoxlist() {
		return boxlist;
	}

	public void setBoxlist(ComboBoxList boxlist) {
		this.boxlist = boxlist;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}
	

}
