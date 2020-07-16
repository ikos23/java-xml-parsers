package com.ivk23.xmlparsers.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivk23
 */
@XmlRootElement(name = "breakfast_menu")
@XmlAccessorType(XmlAccessType.FIELD)
public class BreakfastMenu {

    @XmlElement(name = "food")
    private List<Food> foods = new ArrayList<>();

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
