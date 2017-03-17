package config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXException;

public class ReadClassConfig 
{
	private DocumentBuilderFactory factory = null;
	private DocumentBuilder builder = null;
	private Document document = null;
	private Element root = null;
	private Map map = null;
	private ArrayList listone=null;
	private Map<String,String> modelmap=null;
	public ReadClassConfig(Map<String,ArrayList<String>> map,ArrayList<String> listone,Map<String,String> modelmap) throws SAXException, IOException, ParserConfigurationException
	{
	  this.factory = DocumentBuilderFactory.newInstance();
	  this.builder = factory.newDocumentBuilder();
      this.document = (Document) builder.parse(new File("configFile/pulldown.xml"));
	  this.root = (Element)document.getDocumentElement();
	  this.map = map;
	  this.listone = listone;
	  this.modelmap = modelmap;
	  
	  NodeList list = this.root.getElementsByTagName("class");
	  
	  for(int i = 0; i<list.getLength();i++)
	  {
		  Element lan = (Element) list.item(i);
		  String className = lan.getAttribute("id");
		  //System.out.println("id = "+ lan.getAttribute("id"));
		  if(this.listone.contains(className)==false)
		  {
			  ArrayList tp = new ArrayList<String>();
			  this.map.put(className, tp);
			  this.listone.add(className);
		  }
		  NodeList clist = lan.getChildNodes();
		  int num=0;
		  for(int j=0;j<clist.getLength();j++)
		  {
		    Node st =  clist.item(j);
		    if(st.getNodeName().equals("#text"))continue;
		    num++;
		    
		    
		    if(num>=2)
		    { 
		    	Element st1 =  (Element)clist.item(j);
		    	String alName = st1.getAttribute("id");
		    	String algorithmClassName = st1.getChildNodes().item(3).getTextContent();
		    	if(this.modelmap.get(alName)==null)
		    		this.modelmap.put(alName,algorithmClassName);
		    	((ArrayList<String>)this.map.get(className)).add(alName);
		    	System.out.println(alName);
		    	System.out.println(st.getNodeName()+ " ::ssstttt:: "+ st.getTextContent());
		    	System.out.println("algorithmClassName::"+algorithmClassName);
		    	//this.map.get(name)).add(st.);
		    }
		 }
	  }
	  
	}
	
}
