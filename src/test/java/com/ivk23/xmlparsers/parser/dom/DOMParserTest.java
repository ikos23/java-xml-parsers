package com.ivk23.xmlparsers.parser.dom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DOMParserTest {

    private DOMParser classUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        classUnderTest = new DOMParser();
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

        final NodeList foodNodes = document.getElementsByTagName("food");
        assertEquals(5, foodNodes.getLength());

        final Element food = (Element) foodNodes.item(0);
        assertEquals("true", food.getAttribute("primary"));
        assertEquals("Belgian Waffles",
                food.getElementsByTagName("name").item(0).getTextContent());
        assertEquals("$5.95",
                food.getElementsByTagName("price").item(0).getTextContent());
        assertEquals("Two of our famous Belgian Waffles with plenty of real maple syrup",
                food.getElementsByTagName("description").item(0).getTextContent().trim());
        assertEquals("650",
                food.getElementsByTagName("calories").item(0).getTextContent());
    }
}