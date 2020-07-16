package com.ivk23.xmlparsers.jaxb;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BreakfastMenuUnmarshallerTest {

    @Test
    void unmarshall() throws Exception {
        var file = new File(
                this.getClass()
                        .getClassLoader()
                        .getResource("breakfast_menu.xml")
                        .toURI()
        );

        final BreakfastMenuUnmarshaller classUnderTest =
                new BreakfastMenuUnmarshaller();

        final BreakfastMenu breakfastMenu = classUnderTest
                .unmarshall(file);

        final List<Food> foods = breakfastMenu.getFoods();

        assertEquals(5, foods.size());

        assertEquals(Boolean.TRUE, foods.get(0).getPrimary());
        assertEquals("Strawberry Belgian Waffles",
                foods.get(1).getName());
        assertEquals("$7.95", foods.get(1).getPrice());
        assertEquals("Light Belgian waffles covered with strawberries and whipped cream",
                foods.get(1).getDescription().trim());
        assertEquals("900", foods.get(1).getCalories());

    }
}