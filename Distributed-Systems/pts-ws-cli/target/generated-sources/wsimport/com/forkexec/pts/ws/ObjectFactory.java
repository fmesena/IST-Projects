
package com.forkexec.pts.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forkexec.pts.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Write_QNAME = new QName("http://ws.pts.forkexec.com/", "write");
    private final static QName _BadInitFault_QNAME = new QName("http://ws.pts.forkexec.com/", "BadInitFault");
    private final static QName _CtrlInit_QNAME = new QName("http://ws.pts.forkexec.com/", "ctrlInit");
    private final static QName _CtrlPing_QNAME = new QName("http://ws.pts.forkexec.com/", "ctrlPing");
    private final static QName _CtrlClear_QNAME = new QName("http://ws.pts.forkexec.com/", "ctrlClear");
    private final static QName _GetTag_QNAME = new QName("http://ws.pts.forkexec.com/", "getTag");
    private final static QName _WriteResponse_QNAME = new QName("http://ws.pts.forkexec.com/", "writeResponse");
    private final static QName _CtrlClearResponse_QNAME = new QName("http://ws.pts.forkexec.com/", "ctrlClearResponse");
    private final static QName _CtrlPingResponse_QNAME = new QName("http://ws.pts.forkexec.com/", "ctrlPingResponse");
    private final static QName _GetTagResponse_QNAME = new QName("http://ws.pts.forkexec.com/", "getTagResponse");
    private final static QName _ReadResponse_QNAME = new QName("http://ws.pts.forkexec.com/", "readResponse");
    private final static QName _CtrlInitResponse_QNAME = new QName("http://ws.pts.forkexec.com/", "ctrlInitResponse");
    private final static QName _Read_QNAME = new QName("http://ws.pts.forkexec.com/", "read");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forkexec.pts.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTagResponse }
     * 
     */
    public GetTagResponse createGetTagResponse() {
        return new GetTagResponse();
    }

    /**
     * Create an instance of {@link ReadResponse }
     * 
     */
    public ReadResponse createReadResponse() {
        return new ReadResponse();
    }

    /**
     * Create an instance of {@link CtrlInitResponse }
     * 
     */
    public CtrlInitResponse createCtrlInitResponse() {
        return new CtrlInitResponse();
    }

    /**
     * Create an instance of {@link Read }
     * 
     */
    public Read createRead() {
        return new Read();
    }

    /**
     * Create an instance of {@link CtrlClearResponse }
     * 
     */
    public CtrlClearResponse createCtrlClearResponse() {
        return new CtrlClearResponse();
    }

    /**
     * Create an instance of {@link CtrlPingResponse }
     * 
     */
    public CtrlPingResponse createCtrlPingResponse() {
        return new CtrlPingResponse();
    }

    /**
     * Create an instance of {@link WriteResponse }
     * 
     */
    public WriteResponse createWriteResponse() {
        return new WriteResponse();
    }

    /**
     * Create an instance of {@link GetTag }
     * 
     */
    public GetTag createGetTag() {
        return new GetTag();
    }

    /**
     * Create an instance of {@link CtrlClear }
     * 
     */
    public CtrlClear createCtrlClear() {
        return new CtrlClear();
    }

    /**
     * Create an instance of {@link CtrlPing }
     * 
     */
    public CtrlPing createCtrlPing() {
        return new CtrlPing();
    }

    /**
     * Create an instance of {@link Write }
     * 
     */
    public Write createWrite() {
        return new Write();
    }

    /**
     * Create an instance of {@link BadInitFault }
     * 
     */
    public BadInitFault createBadInitFault() {
        return new BadInitFault();
    }

    /**
     * Create an instance of {@link CtrlInit }
     * 
     */
    public CtrlInit createCtrlInit() {
        return new CtrlInit();
    }

    /**
     * Create an instance of {@link PointsView }
     * 
     */
    public PointsView createPointsView() {
        return new PointsView();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Write }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "write")
    public JAXBElement<Write> createWrite(Write value) {
        return new JAXBElement<Write>(_Write_QNAME, Write.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadInitFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "BadInitFault")
    public JAXBElement<BadInitFault> createBadInitFault(BadInitFault value) {
        return new JAXBElement<BadInitFault>(_BadInitFault_QNAME, BadInitFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "ctrlInit")
    public JAXBElement<CtrlInit> createCtrlInit(CtrlInit value) {
        return new JAXBElement<CtrlInit>(_CtrlInit_QNAME, CtrlInit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlPing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "ctrlPing")
    public JAXBElement<CtrlPing> createCtrlPing(CtrlPing value) {
        return new JAXBElement<CtrlPing>(_CtrlPing_QNAME, CtrlPing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlClear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "ctrlClear")
    public JAXBElement<CtrlClear> createCtrlClear(CtrlClear value) {
        return new JAXBElement<CtrlClear>(_CtrlClear_QNAME, CtrlClear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTag }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "getTag")
    public JAXBElement<GetTag> createGetTag(GetTag value) {
        return new JAXBElement<GetTag>(_GetTag_QNAME, GetTag.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "writeResponse")
    public JAXBElement<WriteResponse> createWriteResponse(WriteResponse value) {
        return new JAXBElement<WriteResponse>(_WriteResponse_QNAME, WriteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlClearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "ctrlClearResponse")
    public JAXBElement<CtrlClearResponse> createCtrlClearResponse(CtrlClearResponse value) {
        return new JAXBElement<CtrlClearResponse>(_CtrlClearResponse_QNAME, CtrlClearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlPingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "ctrlPingResponse")
    public JAXBElement<CtrlPingResponse> createCtrlPingResponse(CtrlPingResponse value) {
        return new JAXBElement<CtrlPingResponse>(_CtrlPingResponse_QNAME, CtrlPingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTagResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "getTagResponse")
    public JAXBElement<GetTagResponse> createGetTagResponse(GetTagResponse value) {
        return new JAXBElement<GetTagResponse>(_GetTagResponse_QNAME, GetTagResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "readResponse")
    public JAXBElement<ReadResponse> createReadResponse(ReadResponse value) {
        return new JAXBElement<ReadResponse>(_ReadResponse_QNAME, ReadResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "ctrlInitResponse")
    public JAXBElement<CtrlInitResponse> createCtrlInitResponse(CtrlInitResponse value) {
        return new JAXBElement<CtrlInitResponse>(_CtrlInitResponse_QNAME, CtrlInitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Read }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pts.forkexec.com/", name = "read")
    public JAXBElement<Read> createRead(Read value) {
        return new JAXBElement<Read>(_Read_QNAME, Read.class, null, value);
    }

}
