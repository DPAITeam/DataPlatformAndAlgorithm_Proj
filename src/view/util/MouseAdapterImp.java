package view.util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MouseAdapterImp extends MouseAdapter 
{
	@Override
	public void mouseClicked(MouseEvent event) {
		eventOnImport(new JButton());
		}
	public void eventOnImport(JButton jb)
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("war","xml", "txt", "doc", "docx");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(jb);
		if (returnVal == JFileChooser.APPROVE_OPTION)
		{
			File[] arrfiles = chooser.getSelectedFiles();
			if (arrfiles == null || arrfiles.length == 0) 
			{
				return;
		    }
			
		}
    }
}
