package Domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
import java.io.File;

public class DOMParseAndValidate {
    private static final Logger logger = LogManager.getLogger(DOMParseAndValidate.class);
    /**
     * Method to parse an XML File.
     * @param xmlFilePath XML File path.
     */
    public void parseXML(String xmlFilePath) {
        try {
            // Make an instance of DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Configuring the factory to validate if necessary
            factory.setNamespaceAware(true);

            // Make a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsing the XML file to get the document
            Document document = builder.parse(new File(xmlFilePath));

            // Normalizing the document
            document.getDocumentElement().normalize();

            // Process the document
            processNode(document.getDocumentElement(), 0);
            logger.info("Parsed "+xmlFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for validating an XML File against a XSD Schema.
     * @param xmlFilePath XML File path
     * @param xsdFilePath XSD File path.
     */
    public boolean validateXMLWithXSD(String xmlFilePath, String xsdFilePath) {
        try {
            // Make an instance of W3C XMLSchema SchemaFactory
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Load the schema from the XSD file.
            Schema schema = factory.newSchema(new File(xsdFilePath));

            // Configure DocumentBuilderFactory to use the specified schema.
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setSchema(schema);
            dbFactory.setNamespaceAware(true);

            // Create a DocumentBuilder to validate the XML.
            DocumentBuilder builder = dbFactory.newDocumentBuilder();

            // Parse and validate the XML.
            this.parseXML(xmlFilePath);
            logger.info("Xml "+xmlFilePath+" validated successfully against "+xsdFilePath+".");
            return true;
        } catch (Exception e) {
            logger.error("Error validating: " + e.getMessage());
            return false;
        }
    }

    /**
     * Recursive method to process nodes of an XML document
     * @param node Node to process
     * @param depth Depth level in the XML tree.
     */
    private void processNode(Node node, int depth) {
        // Indent depending on the depth of the node
        String indent = "  ".repeat(depth);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            logger.info(indent + "Element: " + element.getNodeName());

            // Display element's attributes
            if (element.hasAttributes()) {
                for (int i = 0; i < element.getAttributes().getLength(); i++) {
                    Node attr = element.getAttributes().item(i);
                    logger.info(indent + "  Attribute: " + attr.getNodeName() + " = " + attr.getNodeValue());
                }
            }

            // Go through a node's children
            NodeList nodeList = element.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                processNode(nodeList.item(i), depth + 1);
            }
        } else if (node.getNodeType() == Node.TEXT_NODE && !node.getNodeValue().trim().isEmpty()) {
            logger.info(indent+"Text: " + node.getNodeValue().trim());
        }
    }
}

