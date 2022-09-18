
package com.forkexec.rst.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMenu complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMenu">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="menuId" type="{http://ws.rst.forkexec.com/}menuId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMenu", propOrder = {
    "menuId"
})
public class GetMenu {

    protected MenuId menuId;

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

}
