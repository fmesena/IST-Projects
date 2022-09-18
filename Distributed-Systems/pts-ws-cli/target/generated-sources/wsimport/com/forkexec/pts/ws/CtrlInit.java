
package com.forkexec.pts.ws;

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
 *         &lt;element name="startPoints" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "startPoints"
})
public class CtrlInit {

    protected int startPoints;

    /**
     * Gets the value of the startPoints property.
     * 
     */
    public int getStartPoints() {
        return startPoints;
    }

    /**
     * Sets the value of the startPoints property.
     * 
     */
    public void setStartPoints(int value) {
        this.startPoints = value;
    }

}
