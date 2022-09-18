
package com.forkexec.hub.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ctrlInitFood complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ctrlInitFood">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="initialFoods" type="{http://ws.hub.forkexec.com/}foodInit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ctrlInitFood", propOrder = {
    "initialFoods"
})
public class CtrlInitFood {

    protected List<FoodInit> initialFoods;

    /**
     * Gets the value of the initialFoods property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the initialFoods property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInitialFoods().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FoodInit }
     * 
     * 
     */
    public List<FoodInit> getInitialFoods() {
        if (initialFoods == null) {
            initialFoods = new ArrayList<FoodInit>();
        }
        return this.initialFoods;
    }

}
