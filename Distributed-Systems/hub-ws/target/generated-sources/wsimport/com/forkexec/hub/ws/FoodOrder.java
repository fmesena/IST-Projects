
package com.forkexec.hub.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foodOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foodOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foodOrderId" type="{http://ws.hub.forkexec.com/}foodOrderId" minOccurs="0"/>
 *         &lt;element name="items" type="{http://ws.hub.forkexec.com/}foodOrderItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foodOrder", propOrder = {
    "foodOrderId",
    "items"
})
public class FoodOrder {

    protected FoodOrderId foodOrderId;
    @XmlElement(nillable = true)
    protected List<FoodOrderItem> items;

    /**
     * Gets the value of the foodOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link FoodOrderId }
     *     
     */
    public FoodOrderId getFoodOrderId() {
        return foodOrderId;
    }

    /**
     * Sets the value of the foodOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodOrderId }
     *     
     */
    public void setFoodOrderId(FoodOrderId value) {
        this.foodOrderId = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FoodOrderItem }
     * 
     * 
     */
    public List<FoodOrderItem> getItems() {
        if (items == null) {
            items = new ArrayList<FoodOrderItem>();
        }
        return this.items;
    }

}
