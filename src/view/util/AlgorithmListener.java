package view.util;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class AlgorithmListener implements ItemListener {

	private ComboBoxList list = null;
	private JComboBox jc = null;
	public AlgorithmListener(ComboBoxList list,JComboBox jc)
	{
		this.list = list;
		this.jc = jc;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			String select = e.getItem().toString();
			ArrayList<String> algorithm = (ArrayList<String>) this.list.getMap().get(select);
			if(this.jc.getItemCount() != 0)
				this.jc.removeAllItems();
			
			for(String str:algorithm)
			{
				this.jc.addItem(str);
			}
		}

	}

}
