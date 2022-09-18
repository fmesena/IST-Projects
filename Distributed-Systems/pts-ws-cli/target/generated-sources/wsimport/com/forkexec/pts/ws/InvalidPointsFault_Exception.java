
package com.forkexec.pts.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidPointsFault", targetNamespace = "http://ws.pts.forkexec.com/")
public class InvalidPointsFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidPointsFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InvalidPointsFault_Exception(String message, InvalidPointsFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public InvalidPointsFault_Exception(String message, InvalidPointsFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.forkexec.pts.ws.InvalidPointsFault
     */
    public InvalidPointsFault getFaultInfo() {
        return faultInfo;
    }

}
