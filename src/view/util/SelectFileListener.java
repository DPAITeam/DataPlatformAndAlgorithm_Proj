package view.util;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class SelectFileListener implements ItemListener {

	private JButton jb = null;
	private JTextArea jt = null;
	private MouseAdapter mo = null;
	public SelectFileListener(JButton jb,JTextArea jt,MouseAdapter mo)
	{
		this.jb = jb;
		this.jt = jt;
		this.mo = mo;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED)
		{
			
			if(e.getItem().toString().equals("file"))
			{
                if(jb.getMouseListeners()!=null)
                	jb.removeMouseListener(mo);
				jt.setEditable(false);
				jb.setEnabled(true);
				
				jt.setBackground(new Color(144,144,144));
				jb.addMouseListener(mo);
			}
			else
			{
				jt.setEditable(true);
				jb.setEnabled(false);
				jt.setBackground(new Color(199,237,204));
				if(jb.getMouseListeners()!=null)
                	jb.removeMouseListener(mo);
			}
	}

  }
}