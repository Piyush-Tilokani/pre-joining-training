package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class XMLDemo {
    public static void main(String[] args) {
        try {
            // 1. Create DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 2. Create new XML document
            Document doc = builder.newDocument();

            // 3. Create root element
            Element root = doc.createElement("employees");
            doc.appendChild(root);

            // 4. Create an employee element
            Element employee = doc.createElement("employee");
            root.appendChild(employee);

            // 5. Add child elements
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode("101"));
            employee.appendChild(id);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("Piyush"));
            employee.appendChild(name);

            Element department = doc.createElement("department");
            department.appendChild(doc.createTextNode("Engineering"));
            employee.appendChild(department);

            // 6. Write the content into an XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/xml/employee.xml"));
            transformer.transform(source, result);

            System.out.println("XML file created successfully: employee.xml");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 7. Read and parse the created XML file
        try {
            File inputFile = new File("src/xml/employee.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("\nRoot element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("employee");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("\nEmployee Details:");
                    System.out.println("ID: " + eElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Name: " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Department: " + eElement.getElementsByTagName("department").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}