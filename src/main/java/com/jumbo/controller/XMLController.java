package com.jumbo.controller;

import com.jumbo.domain.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class XMLController {

    @GetMapping("/students")
    public List<Student> parseXML() {
        List<Student> students = new ArrayList();

        try {
            File inputFile = new File("studentsXXE.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    Student student = new Student();
                    student.setId(eElement.getElementsByTagName("id").item(0).getTextContent());
                    student.setFirstName(eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    student.setLastName(eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    student.setNickName(eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    student.setMarks(eElement.getElementsByTagName("marks").item(0).getTextContent());
                    students.add(student);
                }
            }
        } catch (Exception ex) {
            System.out.printf("exception: " + ex.getMessage());
        }
        return students;
    }
}
