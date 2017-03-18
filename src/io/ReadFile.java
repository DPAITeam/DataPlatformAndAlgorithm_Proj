package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReadFile {
	private File f = null;
	public ReadFile(File f){
		this.f = f;
	}
	public void setF(File f)
	{
		this.f = f;
	}
	public StringBuffer read() throws Exception
	{
		FileInputStream input = null;
		FileOutputStream out = null;
		input = new FileInputStream(f);
		StringBuffer strBuf = new StringBuffer();
		byte buffer[]=new byte[1024];;
		while(-1 != (input.read(buffer)))
		{
			strBuf.append(new String(buffer)+"\n");
	    }
		return strBuf;
	}

}
