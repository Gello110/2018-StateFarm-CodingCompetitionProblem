package com.codingcompetition.statefarm.utility;

import com.codingcompetition.statefarm.Category;
import com.codingcompetition.statefarm.model.PointOfInterest;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class PointOfInterestParser {


    // Stacks for storing the elements and objects.
    private Stack<String> elements = new Stack<>();
    private Stack<PointOfInterest> objects = new Stack<>();


    public List<PointOfInterest> parse(String fileName) throws IOException, SAXException {
        NodeList map = null;

        //loads the file into the program
        try {
            //finds and loads the file
            ClassLoader classLoader = getClass().getClassLoader();
            File input = new File(classLoader.getResource(fileName.substring(1)).getFile());

            //converts the file into a parsable format
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document metroMap = builder.parse(input);
            metroMap.getDocumentElement().normalize();
            map = metroMap.getElementsByTagName("node");
        } catch(Exception e) {
            e.printStackTrace();
        }//try catch

        //adds the points of interest into the arrayList
        for(int i = 0; i < map.getLength(); i++) {
            Element curr = (Element) map.item(i);
            PointOfInterest point = new PointOfInterest();

            //sets the point of interest's latitude and longitude
            point.setLatitude(curr.getAttribute("lat"));
            point.setLongitude(curr.getAttribute("lon"));

            //adds tags, if any, to the point of interest
            NodeList nodeTags = curr.getElementsByTagName("tag");
            HashMap<Object, String> tags = new HashMap<>();
            for(int j = 0; j < nodeTags.getLength(); j++) {
                Element tag = (Element) nodeTags.item(j);
                tags.put(tag.getAttribute("k"), tag.getAttribute("v"));
            } //for j 0 to tags.length
            point.setDescriptors(tags);

            objects.add(point);
        }//for int i 0 to map.getLength()
        System.out.println("reached");

        return objects;
    }//parse

}//PointOfInterestParser
