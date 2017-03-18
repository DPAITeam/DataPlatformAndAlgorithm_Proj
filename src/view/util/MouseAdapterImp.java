package view.util;

import io.CopyFiles;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MouseAdapterImp extends MouseAdapter 
{
	@Override
	public void mouseClicked(MouseEvent event)
	{
		try {
			eventOnImport(new JButton());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	public void eventOnImport(JButton jb) throws Exception
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
			String path = "./";
			for(File f : arrfiles) {
			File dir = new File(path);
            File[] fs = dir.listFiles();
			HashSet<String> set = new HashSet<String>();
			for (File file : fs) {
			 set.add(file.getName());
			}
            if (set.contains(f.getName())) {
			JOptionPane.showMessageDialog(new JDialog(),
			f.getName() + ":file has been exist!");
			return;
			}	
		   }
		   new CopyFiles(arrfiles).copy();
		
    }
}
}
