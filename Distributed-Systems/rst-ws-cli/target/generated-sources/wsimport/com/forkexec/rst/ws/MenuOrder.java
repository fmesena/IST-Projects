
package com.forkexec.rst.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for menuOrder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="menuOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://ws.rst.forkexec.com/}menuOrderId" minOccurs="0"/>
 *         &lt;element name="menuId" type="{http://ws.rst.forkexec.com/}menuId" minOccurs="0"/>
 *         &lt;element name="menuQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "menuOrder", propOrder = {
    "id",
    "menuId",
    "menuQuantity"
})
public class MenuOrder {

    protected MenuOrderId id;
    protected MenuId menuId;
    protected int menuQuantity;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link MenuOrderId }
     *     
     */
    public MenuOrderId getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link MenuOrderId }
     *     
     */
    public void setId(MenuOrderId value) {
        this.id = value;
    }

    /**
     * Gets the value of the menuId property.
     * 
     * @return
     *     possible object is
     *     {@link MenuId }
     *     
     */
    public MenuId getMenuId() {
        return menuId;
    }

    /**
     * Sets the value of the menuId property.
     * 
     * @param value
     *     allowed object is
     *     {@link MenuId }
     *     
     */
    public void setMenuId(MenuId value) {
        this.menuId = value;
    }

    /**
     * Gets the value of the menuQuantity property.
     * 
     */
    public int getMenuQuantity() {
        return menuQuantity;
    }

    /**
     * Sets the value of the menuQuantity property.
     * 
     */
    public void setMenuQuantity(int value) {
        this.menuQuantity = value;
    }

}
