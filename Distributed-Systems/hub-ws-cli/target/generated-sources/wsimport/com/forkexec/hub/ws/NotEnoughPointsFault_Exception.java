
package com.forkexec.hub.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NotEnoughPointsFault", targetNamespace = "http://ws.hub.forkexec.com/")
public class NotEnoughPointsFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NotEnoughPointsFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NotEnoughPointsFault_Exception(String message, NotEnoughPointsFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NotEnoughPointsFault_Exception(String message, NotEnoughPointsFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.forkexec.hub.ws.NotEnoughPointsFault
     */
    public NotEnoughPointsFault getFaultInfo() {
        return faultInfo;
    }

}