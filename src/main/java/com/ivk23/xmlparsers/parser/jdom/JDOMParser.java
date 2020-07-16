package com.ivk23.xmlparsers.parser.jdom;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;

/**
 * @author ivk23
 */
public class JDOMParser {

    private final SAXBuilder jdomBuilder;

    public JDOMParser() {
        this.jdomBuilder = new SAXBuilder();
    }

    public Document parse(final File xmlFile)
            throws JDOMException, IOException {
        return jdomBuilder.build(xmlFile);
    }

}
