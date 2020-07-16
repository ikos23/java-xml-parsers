package com.ivk23.xmlparsers.parser.sax;

import com.ivk23.xmlparsers.model.Food;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SAXParserTest {

    @Test
    void parse() throws Exception {
        var file = new File(
                this.getClass()
                        .getClassLoader()
                        .getResource("breakfast_menu.xml")
                        .toURI()
        );

        var classUnderTest = new SAXParser();
        final List<Food> foods = classUnderTest.parse(file);

        assertEquals(5, foods.size());

        assertEquals("Strawberry Belgian Waffles", foods.get(1).name);
        assertEquals("$7.95", foods.get(1).price);
        assertEquals("Light Belgian waffles covered with strawberries and whipped cream", foods.get(1).description);
        assertEquals("900", foods.get(1).calories);
    }
}