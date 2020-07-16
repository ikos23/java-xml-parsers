package com.ivk23.xmlparsers.parser.stax;

import com.ivk23.xmlparsers.model.Food;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLStreamException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class STAXParserTest {

    @Test
    void parse() throws XMLStreamException {
        var is = this.getClass()
                .getClassLoader()
                .getResourceAsStream("breakfast_menu.xml");

        final STAXParser classUnderTest = new STAXParser(is);
        final List<Food> foods = classUnderTest.parse();

        assertEquals(5, foods.size());

        assertEquals("Strawberry Belgian Waffles", foods.get(1).name);
        assertEquals("$7.95", foods.get(1).price);
        assertEquals("Light Belgian waffles covered with strawberries and whipped cream", foods.get(1).description);
        assertEquals("900", foods.get(1).calories);
    }
}