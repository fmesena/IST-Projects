
package com.forkexec.hub.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addFoodToCart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addFoodToCart">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foodId" type="{http://ws.hub.forkexec.com/}foodId" minOccurs="0"/>
 *         &lt;element name="foodQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addFoodToCart", propOrder = {
    "userId",
    "foodId",
    "foodQuantity"
})
public class AddFoodToCart {

    protected String userId;
    protected FoodId foodId;
    protected int foodQuantity;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

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

    /**
     * Gets the value of the foodQuantity property.
     * 
     */
    public int getFoodQuantity() {
        return foodQuantity;
    }

    /**
     * Sets the value of the foodQuantity property.
     * 
     */
    public void setFoodQuantity(int value) {
        this.foodQuantity = value;
    }

}
