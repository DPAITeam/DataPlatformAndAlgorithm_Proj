package view.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import config.ReadClassConfig;

public class ComboBoxList 
{
    private Map map = null;
    private ArrayList name = null;
    private ReadClassConfig rcc = null;
    private Map modelmap = null;
    
	public  ComboBoxList() throws SAXException, IOException, ParserConfigurationException
    {
    	this.map = new HashMap<String,ArrayList<String>>();
    	this.name = new ArrayList<String>();
    	this.modelmap = new HashMap<String,String>();
    	this.rcc = new ReadClassConfig(this.map,this.name,this.modelmap);   
    }
    
    public void addAlgorithmClass(String name,ArrayList st)
    {
    	this.map.put(name,st);
    	this.name.add(name);
    }
    public void addAlgorithmInClass(String str1,String str)
    {
    	((ArrayList) this.map.get(str1)).add(str);
    }

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList getName() {
		return name;
	}

	public void setName(ArrayList name) {
		this.name = name;
	}
	
	public Map getModelmap() {
		return modelmap;
	}

	public void setModelmap(Map modelmap) {
		this.modelmap = modelmap;
	}

    
}
