package io;

import java.io.File;

public class ReadFiles {

	private File[] files = null;
	public ReadFiles(File[] files)
	{
		this.files = files;
	}
	public StringBuffer reads() throws Exception
	{
		ReadFile rf = new ReadFile(null);
		StringBuffer strBufs = new StringBuffer();
		StringBuffer tmpone = null;
	    for (File f : files)
	    {
	    	rf.setF(f);
	    	tmpone = rf.read();
	    	strBufs.append(tmpone);
	    }
	    return strBufs;
	}
}
