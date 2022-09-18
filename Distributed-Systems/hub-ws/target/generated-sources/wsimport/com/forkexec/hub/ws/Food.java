
package com.forkexec.hub.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for food complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="food">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://ws.hub.forkexec.com/}foodId" minOccurs="0"/>
 *         &lt;element name="entree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dessert" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="preparationTime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "food", propOrder = {
    "id",
    "entree",
    "plate",
    "dessert",
    "price",
    "preparationTime"
})
public class Food {

    protected FoodId id;
    protected String entree;
    protected String plate;
    protected String dessert;
    protected int price;
    protected int preparationTime;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link FoodId }
     *     
     */
    public FoodId getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoodId }
     *     
     */
    public void setId(FoodId value) {
        this.id = value;
    }

    /**
     * Gets the value of the entree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntree() {
        return entree;
    }

    /**
     * Sets the value of the entree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntree(String value) {
        this.entree = value;
    }

    /**
     * Gets the value of the plate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlate() {
        return plate;
    }

    /**
     * Sets the value of the plate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlate(String value) {
        this.plate = value;
    }

    /**
     * Gets the value of the dessert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDessert() {
        return dessert;
    }

    /**
     * Sets the value of the dessert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDessert(String value) {
        this.dessert = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the preparationTime property.
     * 
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * Sets the value of the preparationTime property.
     * 
     */
    public void setPreparationTime(int value) {
        this.preparationTime = value;
    }

}
