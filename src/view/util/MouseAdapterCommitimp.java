package view.util;

import io.ReadFile;
import io.ReadFiles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import reflectImp.ClassToObj;
import algorithmSuminter.Inter_Algorithm_Total;
import view.MainView;

public class MouseAdapterCommitimp extends MouseAdapter
{
    private MainView view=null;
    private String alName;
	public MouseAdapterCommitimp( MainView view)
	{
		this.view = view;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		String alNameClass = this.view.getAlgorithmClass().getSelectedItem().toString();
		String alName = this.view.getAlgorithmInClass().getSelectedItem().toString();
		String inputType = this.view.getiOtype().getSelectedItem().toString();
		String operationType = this.view.getOperationType().getSelectedItem().toString();
		String outDemessionString=this.view.getIdDemesion().getText().toString();
		outDemessionString = (outDemessionString.equals("")?"0":outDemessionString);
		int outDemession = (isNumeric(outDemessionString)?Integer.parseInt(outDemessionString):0);
		System.out.println("alNameClass:"+alNameClass+",alName:"+alName+",inputType:"+inputType+",operationType:"+operationType+",outDemession:"+outDemession);
		//StringBuffer[] textArea = this.view.getInputText().getText();
		StringBuffer contents = null;
		ReadFile rf = new ReadFile(new File("tempFile/temp"));
		if(inputType.equals("file"))
			try {
				contents = rf.read();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		else
			contents = new StringBuffer(this.view.getInputText().getText());
		System.out.println("contents: "+contents);
		String alClassName = this.view.getBoxlist().getModelmap().get(alName).toString();
		ClassToObj classq =  new ClassToObj(alClassName);
		
		try {
			Inter_Algorithm_Total algorithm = (Inter_Algorithm_Total) classq.Product2Obj();
			algorithm.init(contents, outDemession);
			if(operationType.equals("train"))
			  algorithm.train();
			else algorithm.test();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	//正则表达式判断字符是否为数字
	public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}

	
  
}
