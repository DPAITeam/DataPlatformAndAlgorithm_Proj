package view.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		int outDemession = Integer.parseInt(this.view.getIdDemesion().getText().toString());
		System.out.println("alNameClass:"+alNameClass+",alName:"+alName+",inputType:"+inputType+",operationType:"+operationType+",outDemession:"+outDemession);
		//StringBuffer[] textArea = this.view.getInputText().getText(); 
		String alClassName = this.view.getBoxlist().getModelmap().get(alName).toString();
		ClassToObj classq =  new ClassToObj(alClassName);
		
		try {
			Inter_Algorithm_Total algorithm = (Inter_Algorithm_Total) classq.Product2Obj();
			algorithm.train();
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
  
}
