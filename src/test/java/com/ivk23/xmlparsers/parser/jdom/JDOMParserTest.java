package com.ivk23.xmlparsers.parser.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JDOMParserTest {

    private JDOMParser classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new JDOMParser();
    }

    @Test
    void parse() throws Exception {
        var file = new File(
                this.getClass()
                        .getClassLoader()
                        .getResource("breakfast_menu.xml")
                        .toURI()
        );

        final Document document = classUnderTest.parse(file);
        final Element root = document.getRootElement();
        final Element food = root.getChild("food");

        assertEquals("true", food.getAttributeValue("primary"));
        assertEquals("Belgian Waffles", food.getChild("name").getText());
        assertEquals("$5.95", food.getChild("price").getText());
    }
}