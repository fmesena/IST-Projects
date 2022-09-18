
package com.forkexec.hub.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foodId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foodId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="restaurantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="menuId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foodId", propOrder = {
    "restaurantId",
    "menuId"
})
public class FoodId {

    protected String restaurantId;
    protected String menuId;

    /**
     * Gets the value of the restaurantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRestaurantId() {
        return restaurantId;
    }

    /**
     * Sets the value of the restaurantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRestaurantId(String value) {
        this.restaurantId = value;
    }

    /**
     * Gets the value of the menuId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * Sets the value of the menuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenuId(String value) {
        this.menuId = value;
    }

}
