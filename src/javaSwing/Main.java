package javaSwing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import cluster.knnImp;
import reflectImp.ClassToObj;
import view.MainView;
import config.ReadClassConfig;

public class Main {
	
	static MainView sr = null;
	public static class Runn implements Runnable
	{

		@Override
		public void run() {
			try {
				sr.createAndShowGUI();
			} catch (SAXException | IOException | ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws Exception {
		//swingClass sr = new swingClass();
		//javax.swing.SwingUtilities.invokeLater(new Runn());
		//ReadClassConfig st = new ReadClassConfig(new HashMap<String,ArrayList<String>>(),new ArrayList<String>());
        //MainView swr = new MainView();
		sr = new MainView();
        javax.swing.SwingUtilities.invokeLater(new Runn());
        
		ClassToObj se = new ClassToObj("cluster.knnImp");
        Object obj = se.Product2Obj();
	}

}
