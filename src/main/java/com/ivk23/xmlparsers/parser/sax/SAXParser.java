package com.ivk23.xmlparsers.parser.sax;

import com.ivk23.xmlparsers.model.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivk23
 */
public class SAXParser {

    private final javax.xml.parsers.SAXParser saxParser;

    public SAXParser() throws ParserConfigurationException, SAXException {
        saxParser = SAXParserFactory.newInstance().newSAXParser();
    }

    public List<Food> parse(final File xmlFile) throws IOException, SAXException {
        final BreakfastMenuHandler handler = new BreakfastMenuHandler();
        saxParser.parse(xmlFile, handler);
        return handler.foods;
    }

    private static class BreakfastMenuHandler extends DefaultHandler {

        private boolean isName;
        private boolean isPrice;
        private boolean isDescription;
        private boolean isCalories;

        public List<Food> foods = new ArrayList<>();

        @Override
        public void startElement(String uri,
                                 String localName,
                                 String qName,
                                 Attributes attributes) {
            if (qName.equalsIgnoreCase("food")) {
                foods.add(new Food());
            }
            isName = qName.equalsIgnoreCase("name");
            isPrice = qName.equalsIgnoreCase("price");
            isDescription = qName.equalsIgnoreCase("description");
            isCalories = qName.equalsIgnoreCase("calories");
        }

        @Override
        public void characters(char[] ch,
                               int start,
                               int length) {
            var val = new String(ch, start, length).trim();

            if (isName && !val.isBlank()) {
                foods.get(foods.size() - 1).name = val;
            } else if (isPrice && !val.isBlank()) {
                foods.get(foods.size() - 1).price = val;
            } else if (isDescription && !val.isBlank()) {
                foods.get(foods.size() - 1).description = val;
            } else if (isCalories && !val.isBlank()) {
                foods.get(foods.size() - 1).calories = val;
            }
        }
    }
}
