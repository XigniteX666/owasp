package com.jumbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@RestController
public class XMLController {

    @GetMapping("/parse")
    public String parseXML() {
        String result = "";

        try {
            File inputFile = new File("studentsXXE2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //nputSource is = new InputSource(new StringReader(s));
            Document doc = dBuilder.parse(inputFile);
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                   result = "First Name : "
                            + eElement
                            .getElementsByTagName("firstname")
                            .item(0)
                            .getTextContent() + " - " +
                           "Last Name : "
                           + eElement
                           .getElementsByTagName("lastname")
                           .item(0)
                           .getTextContent();
                }
            }
        }catch(Exception ex){
            System.out.printf("exception: "+ex.getMessage());
        }
        return result;
    }
}
