
package com.forkexec.rst.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ctrlInit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ctrlInit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="initialMenus" type="{http://ws.rst.forkexec.com/}menuInit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ctrlInit", propOrder = {
    "initialMenus"
})
public class CtrlInit {

    protected List<MenuInit> initialMenus;

    /**
     * Gets the value of the initialMenus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the initialMenus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInitialMenus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MenuInit }
     * 
     * 
     */
    public List<MenuInit> getInitialMenus() {
        if (initialMenus == null) {
            initialMenus = new ArrayList<MenuInit>();
        }
        return this.initialMenus;
    }

}
