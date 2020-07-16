package com.ivk23.xmlparsers.parser.dom;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @author ivk23
 */
public class DOMParser {

    private final DocumentBuilder docBuilder;

    public DOMParser() throws ParserConfigurationException {
        docBuilder = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder();
    }

    public Document parse(final File xmlFile)
            throws IOException, SAXException {
        return docBuilder.parse(xmlFile);
    }

}
