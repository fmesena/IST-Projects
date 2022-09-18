
package com.forkexec.hub.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFood complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFood">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foodId" type="{http://ws.hub.forkexec.com/}foodId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFood", propOrder = {
    "foodId"
})
public class GetFood {

    protected FoodId foodId;

    /**
     * Gets the value of the foodId property.
     * 
     * @return
     *     possible object is
     *     {@link FoodId }
     *     
     */
    public FoodId getFoodId() {
        return foodId;
    }

    /**
     * Sets the value of the foodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodId }
     *     
     */
    public void setFoodId(FoodId value) {
        this.foodId = value;
    }

}
