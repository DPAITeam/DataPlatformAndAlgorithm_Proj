package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFiles {
	
	private File[] files = null;
	public CopyFiles(File[] files)
	{
		this.files = files;
	}
    public void copy() throws Exception
    {
    	File desfile = new File("./tempFile/temp");
    	if(!desfile.exists())
    		desfile.createNewFile();
    	FileOutputStream out=new FileOutputStream(desfile);
    	int c;
    	byte buffer[]=new byte[1024];
    	FileInputStream in = null;
    	for(File f:this.files)
    	{
    		in = new FileInputStream(f);
    		while((c=in.read(buffer))!=-1)
    		{
    			for(int i=0;i<c;i++)
    			 out.write(buffer[i]);
    		}
    		in.close();
    	}
    	out.close();
    }

}
