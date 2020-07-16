package com.ivk23.xmlparsers.parser.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

/**
 * @author ivk23
 */
public class DOM4JParser {

    // DOM4J's reader to read xml file
    private final SAXReader saxReader;

    public DOM4JParser() {
        this.saxReader = new SAXReader();
    }

    public Document parse(final File xmlFile) throws DocumentException {
        return this.saxReader.read(xmlFile);
    }
}
