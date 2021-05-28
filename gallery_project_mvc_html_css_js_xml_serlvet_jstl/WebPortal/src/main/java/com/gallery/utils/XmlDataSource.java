package com.gallery.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;



import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.gallery.entity.Painting;
/***
 * xmldatasource class is used to read xml data and parse them into painting class.
 * main function getRawData() is in singleton pattern.
 * @author dwang
 *
 */
public class XmlDataSource {
	private static List<Painting> dataList = new ArrayList<>();
	private static String dataFile = "";
	static {
		// painting 放在src下，编译后 也会放在class目录下 getResouce可以找到编译后的class目录
		dataFile = XmlDataSource.class.getResource("/painting.xml").getPath();
		//getPath 会将c:\new file\1.xml
		//读为 c:\new%20file\1.xml
		URLDecoder decoder = new URLDecoder();
		try {
			decoder.decode(dataFile, "UTF-8");
			SAXReader reader = new SAXReader();
			Document document = reader.read(dataFile);
			List<Node> nodes =  document.selectNodes("/root/painting");
			for(Node node: nodes) {
				Element element = (Element) node;
				Integer id = Integer.parseInt(element.attributeValue("id"));
				String name = element.elementText("pname");
				Integer category = Integer.parseInt(element.elementText("category"));
				Integer price = Integer.parseInt(element.elementText("price"));
				String preview = element.elementText("preview");
				String description = element.elementText("description");
				Painting painting = new Painting(id, name, category, price, preview, description);
				dataList.add(painting);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static List<Painting> getRawData(){
		return dataList;
	}
	
	public static void main(String[] args) {
		List<Painting> ps = new XmlDataSource().getRawData();
		System.out.println(ps.toString());
	}
	
}
