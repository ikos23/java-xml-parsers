package com.ivk23.xmlparsers.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author ivk23
 */
public class BreakfastMenuUnmarshaller {

    public BreakfastMenu unmarshall(final File xmlFile)
            throws JAXBException {
        final JAXBContext context = JAXBContext
                .newInstance(BreakfastMenu.class);
        final Unmarshaller u = context.createUnmarshaller();

        return (BreakfastMenu) u.unmarshal(xmlFile);
    }
}
