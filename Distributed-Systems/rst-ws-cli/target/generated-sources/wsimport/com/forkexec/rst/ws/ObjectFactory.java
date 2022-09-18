
package com.forkexec.rst.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forkexec.rst.ws package. 
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

    private final static QName _CtrlPing_QNAME = new QName("http://ws.rst.forkexec.com/", "ctrlPing");
    private final static QName _SearchMenus_QNAME = new QName("http://ws.rst.forkexec.com/", "searchMenus");
    private final static QName _BadInitFault_QNAME = new QName("http://ws.rst.forkexec.com/", "BadInitFault");
    private final static QName _CtrlInit_QNAME = new QName("http://ws.rst.forkexec.com/", "ctrlInit");
    private final static QName _CtrlClear_QNAME = new QName("http://ws.rst.forkexec.com/", "ctrlClear");
    private final static QName _GetMenu_QNAME = new QName("http://ws.rst.forkexec.com/", "getMenu");
    private final static QName _InsufficientQuantityFault_QNAME = new QName("http://ws.rst.forkexec.com/", "InsufficientQuantityFault");
    private final static QName _OrderMenuResponse_QNAME = new QName("http://ws.rst.forkexec.com/", "orderMenuResponse");
    private final static QName _OrderMenu_QNAME = new QName("http://ws.rst.forkexec.com/", "orderMenu");
    private final static QName _SearchMenusResponse_QNAME = new QName("http://ws.rst.forkexec.com/", "searchMenusResponse");
    private final static QName _BadQuantityFault_QNAME = new QName("http://ws.rst.forkexec.com/", "BadQuantityFault");
    private final static QName _BadMenuIdFault_QNAME = new QName("http://ws.rst.forkexec.com/", "BadMenuIdFault");
    private final static QName _CtrlInitResponse_QNAME = new QName("http://ws.rst.forkexec.com/", "ctrlInitResponse");
    private final static QName _GetMenuResponse_QNAME = new QName("http://ws.rst.forkexec.com/", "getMenuResponse");
    private final static QName _CtrlClearResponse_QNAME = new QName("http://ws.rst.forkexec.com/", "ctrlClearResponse");
    private final static QName _CtrlPingResponse_QNAME = new QName("http://ws.rst.forkexec.com/", "ctrlPingResponse");
    private final static QName _BadTextFault_QNAME = new QName("http://ws.rst.forkexec.com/", "BadTextFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forkexec.rst.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMenuResponse }
     * 
     */
    public GetMenuResponse createGetMenuResponse() {
        return new GetMenuResponse();
    }

    /**
     * Create an instance of {@link BadQuantityFault }
     * 
     */
    public BadQuantityFault createBadQuantityFault() {
        return new BadQuantityFault();
    }

    /**
     * Create an instance of {@link BadMenuIdFault }
     * 
     */
    public BadMenuIdFault createBadMenuIdFault() {
        return new BadMenuIdFault();
    }

    /**
     * Create an instance of {@link CtrlInitResponse }
     * 
     */
    public CtrlInitResponse createCtrlInitResponse() {
        return new CtrlInitResponse();
    }

    /**
     * Create an instance of {@link BadTextFault }
     * 
     */
    public BadTextFault createBadTextFault() {
        return new BadTextFault();
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
     * Create an instance of {@link OrderMenu }
     * 
     */
    public OrderMenu createOrderMenu() {
        return new OrderMenu();
    }

    /**
     * Create an instance of {@link SearchMenusResponse }
     * 
     */
    public SearchMenusResponse createSearchMenusResponse() {
        return new SearchMenusResponse();
    }

    /**
     * Create an instance of {@link CtrlClear }
     * 
     */
    public CtrlClear createCtrlClear() {
        return new CtrlClear();
    }

    /**
     * Create an instance of {@link InsufficientQuantityFault }
     * 
     */
    public InsufficientQuantityFault createInsufficientQuantityFault() {
        return new InsufficientQuantityFault();
    }

    /**
     * Create an instance of {@link OrderMenuResponse }
     * 
     */
    public OrderMenuResponse createOrderMenuResponse() {
        return new OrderMenuResponse();
    }

    /**
     * Create an instance of {@link GetMenu }
     * 
     */
    public GetMenu createGetMenu() {
        return new GetMenu();
    }

    /**
     * Create an instance of {@link CtrlPing }
     * 
     */
    public CtrlPing createCtrlPing() {
        return new CtrlPing();
    }

    /**
     * Create an instance of {@link SearchMenus }
     * 
     */
    public SearchMenus createSearchMenus() {
        return new SearchMenus();
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
     * Create an instance of {@link Menu }
     * 
     */
    public Menu createMenu() {
        return new Menu();
    }

    /**
     * Create an instance of {@link MenuInit }
     * 
     */
    public MenuInit createMenuInit() {
        return new MenuInit();
    }

    /**
     * Create an instance of {@link MenuOrder }
     * 
     */
    public MenuOrder createMenuOrder() {
        return new MenuOrder();
    }

    /**
     * Create an instance of {@link MenuId }
     * 
     */
    public MenuId createMenuId() {
        return new MenuId();
    }

    /**
     * Create an instance of {@link MenuOrderId }
     * 
     */
    public MenuOrderId createMenuOrderId() {
        return new MenuOrderId();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlPing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "ctrlPing")
    public JAXBElement<CtrlPing> createCtrlPing(CtrlPing value) {
        return new JAXBElement<CtrlPing>(_CtrlPing_QNAME, CtrlPing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchMenus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "searchMenus")
    public JAXBElement<SearchMenus> createSearchMenus(SearchMenus value) {
        return new JAXBElement<SearchMenus>(_SearchMenus_QNAME, SearchMenus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadInitFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "BadInitFault")
    public JAXBElement<BadInitFault> createBadInitFault(BadInitFault value) {
        return new JAXBElement<BadInitFault>(_BadInitFault_QNAME, BadInitFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "ctrlInit")
    public JAXBElement<CtrlInit> createCtrlInit(CtrlInit value) {
        return new JAXBElement<CtrlInit>(_CtrlInit_QNAME, CtrlInit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlClear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "ctrlClear")
    public JAXBElement<CtrlClear> createCtrlClear(CtrlClear value) {
        return new JAXBElement<CtrlClear>(_CtrlClear_QNAME, CtrlClear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "getMenu")
    public JAXBElement<GetMenu> createGetMenu(GetMenu value) {
        return new JAXBElement<GetMenu>(_GetMenu_QNAME, GetMenu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsufficientQuantityFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "InsufficientQuantityFault")
    public JAXBElement<InsufficientQuantityFault> createInsufficientQuantityFault(InsufficientQuantityFault value) {
        return new JAXBElement<InsufficientQuantityFault>(_InsufficientQuantityFault_QNAME, InsufficientQuantityFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderMenuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "orderMenuResponse")
    public JAXBElement<OrderMenuResponse> createOrderMenuResponse(OrderMenuResponse value) {
        return new JAXBElement<OrderMenuResponse>(_OrderMenuResponse_QNAME, OrderMenuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderMenu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "orderMenu")
    public JAXBElement<OrderMenu> createOrderMenu(OrderMenu value) {
        return new JAXBElement<OrderMenu>(_OrderMenu_QNAME, OrderMenu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchMenusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "searchMenusResponse")
    public JAXBElement<SearchMenusResponse> createSearchMenusResponse(SearchMenusResponse value) {
        return new JAXBElement<SearchMenusResponse>(_SearchMenusResponse_QNAME, SearchMenusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadQuantityFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "BadQuantityFault")
    public JAXBElement<BadQuantityFault> createBadQuantityFault(BadQuantityFault value) {
        return new JAXBElement<BadQuantityFault>(_BadQuantityFault_QNAME, BadQuantityFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadMenuIdFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "BadMenuIdFault")
    public JAXBElement<BadMenuIdFault> createBadMenuIdFault(BadMenuIdFault value) {
        return new JAXBElement<BadMenuIdFault>(_BadMenuIdFault_QNAME, BadMenuIdFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "ctrlInitResponse")
    public JAXBElement<CtrlInitResponse> createCtrlInitResponse(CtrlInitResponse value) {
        return new JAXBElement<CtrlInitResponse>(_CtrlInitResponse_QNAME, CtrlInitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "getMenuResponse")
    public JAXBElement<GetMenuResponse> createGetMenuResponse(GetMenuResponse value) {
        return new JAXBElement<GetMenuResponse>(_GetMenuResponse_QNAME, GetMenuResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlClearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "ctrlClearResponse")
    public JAXBElement<CtrlClearResponse> createCtrlClearResponse(CtrlClearResponse value) {
        return new JAXBElement<CtrlClearResponse>(_CtrlClearResponse_QNAME, CtrlClearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlPingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "ctrlPingResponse")
    public JAXBElement<CtrlPingResponse> createCtrlPingResponse(CtrlPingResponse value) {
        return new JAXBElement<CtrlPingResponse>(_CtrlPingResponse_QNAME, CtrlPingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BadTextFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.rst.forkexec.com/", name = "BadTextFault")
    public JAXBElement<BadTextFault> createBadTextFault(BadTextFault value) {
        return new JAXBElement<BadTextFault>(_BadTextFault_QNAME, BadTextFault.class, null, value);
    }

}
