package com.ivk23.xmlparsers.parser.stax;

import com.ivk23.xmlparsers.model.Food;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivk23
 */
public class STAXParser {

    private final XMLEventReader eventReader;

    public STAXParser(final InputStream is) throws XMLStreamException {
        this.eventReader = XMLInputFactory
                .newInstance()
                .createXMLEventReader(is);
    }

    public List<Food> parse() throws XMLStreamException {
        final List<Food> foods = new ArrayList<>();
        boolean isName = false;
        boolean isPrice = false;
        boolean isDescription = false;
        boolean isCalories = false;

        while (eventReader.hasNext()) {
            // PULL next event
            var event = eventReader.nextEvent();

            switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT -> {
                    final var start = event.asStartElement();
                    final var tagName = start.getName().getLocalPart();
                    if (tagName.equalsIgnoreCase("food")) {
                        foods.add(new Food());
                    }
                    isName = tagName.equalsIgnoreCase("name");
                    isPrice = tagName.equalsIgnoreCase("price");
                    isDescription = tagName.equalsIgnoreCase("description");
                    isCalories = tagName.equalsIgnoreCase("calories");
                }
                case XMLStreamConstants.CHARACTERS -> {
                    final var data = event.asCharacters().getData().trim();
                    if (isName && !data.isBlank()) {
                        foods.get(foods.size() - 1).name = data;
                    } else if (isPrice && !data.isBlank()) {
                        foods.get(foods.size() - 1).price = data;
                    } else if (isDescription && !data.isBlank()) {
                        foods.get(foods.size() - 1).description = data;
                    } else if (isCalories && !data.isBlank()) {
                        foods.get(foods.size() - 1).calories = data;
                    }
                }
            }
        }

        eventReader.close();
        return foods;
    }
}
