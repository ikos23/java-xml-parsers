package com.ivk23.xmlparsers.parser.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DOM4JParserTest {

    private DOM4JParser classUnderTest;

    @BeforeEach
    void setUp() {
        classUnderTest = new DOM4JParser();
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
        final List<Node> foodNodes = document
                .getRootElement()
                .selectNodes("/breakfast_menu/food");
        assertEquals(5, foodNodes.size());

        final Node food = foodNodes.get(0);
        assertEquals("true", food.valueOf("@primary")); // attribute
        assertEquals("Belgian Waffles", food.selectSingleNode("name").getText());
        assertEquals("$5.95", food.selectSingleNode("price").getText());

    }
}