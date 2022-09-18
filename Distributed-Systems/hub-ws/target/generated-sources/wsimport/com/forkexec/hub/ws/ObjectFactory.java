
package com.forkexec.hub.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.forkexec.hub.ws package. 
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

    private final static QName _OrderCartResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "orderCartResponse");
    private final static QName _ClearCartResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "clearCartResponse");
    private final static QName _InvalidFoodIdFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidFoodIdFault");
    private final static QName _AddFoodToCart_QNAME = new QName("http://ws.hub.forkexec.com/", "addFoodToCart");
    private final static QName _InvalidTextFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidTextFault");
    private final static QName _CtrlInitUserPointsResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlInitUserPointsResponse");
    private final static QName _ActivateAccount_QNAME = new QName("http://ws.hub.forkexec.com/", "activateAccount");
    private final static QName _GetFoodResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "getFoodResponse");
    private final static QName _AccountBalance_QNAME = new QName("http://ws.hub.forkexec.com/", "accountBalance");
    private final static QName _CartContentsResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "cartContentsResponse");
    private final static QName _ClearCart_QNAME = new QName("http://ws.hub.forkexec.com/", "clearCart");
    private final static QName _CtrlPing_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlPing");
    private final static QName _CtrlInitFoodResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlInitFoodResponse");
    private final static QName _SearchHungry_QNAME = new QName("http://ws.hub.forkexec.com/", "searchHungry");
    private final static QName _InvalidMoneyFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidMoneyFault");
    private final static QName _CtrlClearResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlClearResponse");
    private final static QName _AddFoodToCartResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "addFoodToCartResponse");
    private final static QName _LoadAccount_QNAME = new QName("http://ws.hub.forkexec.com/", "loadAccount");
    private final static QName _NotEnoughPointsFault_QNAME = new QName("http://ws.hub.forkexec.com/", "NotEnoughPointsFault");
    private final static QName _CtrlInitFood_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlInitFood");
    private final static QName _SearchDealResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "searchDealResponse");
    private final static QName _OrderCart_QNAME = new QName("http://ws.hub.forkexec.com/", "orderCart");
    private final static QName _GetFood_QNAME = new QName("http://ws.hub.forkexec.com/", "getFood");
    private final static QName _SearchDeal_QNAME = new QName("http://ws.hub.forkexec.com/", "searchDeal");
    private final static QName _SearchHungryResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "searchHungryResponse");
    private final static QName _EmptyCartFault_QNAME = new QName("http://ws.hub.forkexec.com/", "EmptyCartFault");
    private final static QName _AccountBalanceResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "accountBalanceResponse");
    private final static QName _InvalidUserIdFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidUserIdFault");
    private final static QName _CtrlClear_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlClear");
    private final static QName _InvalidCreditCardFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidCreditCardFault");
    private final static QName _ActivateAccountResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "activateAccountResponse");
    private final static QName _CtrlPingResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlPingResponse");
    private final static QName _LoadAccountResponse_QNAME = new QName("http://ws.hub.forkexec.com/", "loadAccountResponse");
    private final static QName _InvalidInitFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidInitFault");
    private final static QName _InvalidFoodQuantityFault_QNAME = new QName("http://ws.hub.forkexec.com/", "InvalidFoodQuantityFault");
    private final static QName _CartContents_QNAME = new QName("http://ws.hub.forkexec.com/", "cartContents");
    private final static QName _CtrlInitUserPoints_QNAME = new QName("http://ws.hub.forkexec.com/", "ctrlInitUserPoints");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.forkexec.hub.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CartContents }
     * 
     */
    public CartContents createCartContents() {
        return new CartContents();
    }

    /**
     * Create an instance of {@link InvalidFoodQuantityFault }
     * 
     */
    public InvalidFoodQuantityFault createInvalidFoodQuantityFault() {
        return new InvalidFoodQuantityFault();
    }

    /**
     * Create an instance of {@link InvalidInitFault }
     * 
     */
    public InvalidInitFault createInvalidInitFault() {
        return new InvalidInitFault();
    }

    /**
     * Create an instance of {@link ActivateAccountResponse }
     * 
     */
    public ActivateAccountResponse createActivateAccountResponse() {
        return new ActivateAccountResponse();
    }

    /**
     * Create an instance of {@link CtrlPingResponse }
     * 
     */
    public CtrlPingResponse createCtrlPingResponse() {
        return new CtrlPingResponse();
    }

    /**
     * Create an instance of {@link LoadAccountResponse }
     * 
     */
    public LoadAccountResponse createLoadAccountResponse() {
        return new LoadAccountResponse();
    }

    /**
     * Create an instance of {@link CtrlInitUserPoints }
     * 
     */
    public CtrlInitUserPoints createCtrlInitUserPoints() {
        return new CtrlInitUserPoints();
    }

    /**
     * Create an instance of {@link CtrlClear }
     * 
     */
    public CtrlClear createCtrlClear() {
        return new CtrlClear();
    }

    /**
     * Create an instance of {@link InvalidUserIdFault }
     * 
     */
    public InvalidUserIdFault createInvalidUserIdFault() {
        return new InvalidUserIdFault();
    }

    /**
     * Create an instance of {@link InvalidCreditCardFault }
     * 
     */
    public InvalidCreditCardFault createInvalidCreditCardFault() {
        return new InvalidCreditCardFault();
    }

    /**
     * Create an instance of {@link SearchDealResponse }
     * 
     */
    public SearchDealResponse createSearchDealResponse() {
        return new SearchDealResponse();
    }

    /**
     * Create an instance of {@link NotEnoughPointsFault }
     * 
     */
    public NotEnoughPointsFault createNotEnoughPointsFault() {
        return new NotEnoughPointsFault();
    }

    /**
     * Create an instance of {@link CtrlInitFood }
     * 
     */
    public CtrlInitFood createCtrlInitFood() {
        return new CtrlInitFood();
    }

    /**
     * Create an instance of {@link LoadAccount }
     * 
     */
    public LoadAccount createLoadAccount() {
        return new LoadAccount();
    }

    /**
     * Create an instance of {@link AddFoodToCartResponse }
     * 
     */
    public AddFoodToCartResponse createAddFoodToCartResponse() {
        return new AddFoodToCartResponse();
    }

    /**
     * Create an instance of {@link InvalidMoneyFault }
     * 
     */
    public InvalidMoneyFault createInvalidMoneyFault() {
        return new InvalidMoneyFault();
    }

    /**
     * Create an instance of {@link CtrlClearResponse }
     * 
     */
    public CtrlClearResponse createCtrlClearResponse() {
        return new CtrlClearResponse();
    }

    /**
     * Create an instance of {@link SearchHungry }
     * 
     */
    public SearchHungry createSearchHungry() {
        return new SearchHungry();
    }

    /**
     * Create an instance of {@link EmptyCartFault }
     * 
     */
    public EmptyCartFault createEmptyCartFault() {
        return new EmptyCartFault();
    }

    /**
     * Create an instance of {@link AccountBalanceResponse }
     * 
     */
    public AccountBalanceResponse createAccountBalanceResponse() {
        return new AccountBalanceResponse();
    }

    /**
     * Create an instance of {@link GetFood }
     * 
     */
    public GetFood createGetFood() {
        return new GetFood();
    }

    /**
     * Create an instance of {@link SearchDeal }
     * 
     */
    public SearchDeal createSearchDeal() {
        return new SearchDeal();
    }

    /**
     * Create an instance of {@link SearchHungryResponse }
     * 
     */
    public SearchHungryResponse createSearchHungryResponse() {
        return new SearchHungryResponse();
    }

    /**
     * Create an instance of {@link OrderCart }
     * 
     */
    public OrderCart createOrderCart() {
        return new OrderCart();
    }

    /**
     * Create an instance of {@link InvalidFoodIdFault }
     * 
     */
    public InvalidFoodIdFault createInvalidFoodIdFault() {
        return new InvalidFoodIdFault();
    }

    /**
     * Create an instance of {@link ClearCartResponse }
     * 
     */
    public ClearCartResponse createClearCartResponse() {
        return new ClearCartResponse();
    }

    /**
     * Create an instance of {@link OrderCartResponse }
     * 
     */
    public OrderCartResponse createOrderCartResponse() {
        return new OrderCartResponse();
    }

    /**
     * Create an instance of {@link CtrlInitFoodResponse }
     * 
     */
    public CtrlInitFoodResponse createCtrlInitFoodResponse() {
        return new CtrlInitFoodResponse();
    }

    /**
     * Create an instance of {@link CartContentsResponse }
     * 
     */
    public CartContentsResponse createCartContentsResponse() {
        return new CartContentsResponse();
    }

    /**
     * Create an instance of {@link ClearCart }
     * 
     */
    public ClearCart createClearCart() {
        return new ClearCart();
    }

    /**
     * Create an instance of {@link CtrlPing }
     * 
     */
    public CtrlPing createCtrlPing() {
        return new CtrlPing();
    }

    /**
     * Create an instance of {@link AccountBalance }
     * 
     */
    public AccountBalance createAccountBalance() {
        return new AccountBalance();
    }

    /**
     * Create an instance of {@link ActivateAccount }
     * 
     */
    public ActivateAccount createActivateAccount() {
        return new ActivateAccount();
    }

    /**
     * Create an instance of {@link GetFoodResponse }
     * 
     */
    public GetFoodResponse createGetFoodResponse() {
        return new GetFoodResponse();
    }

    /**
     * Create an instance of {@link InvalidTextFault }
     * 
     */
    public InvalidTextFault createInvalidTextFault() {
        return new InvalidTextFault();
    }

    /**
     * Create an instance of {@link CtrlInitUserPointsResponse }
     * 
     */
    public CtrlInitUserPointsResponse createCtrlInitUserPointsResponse() {
        return new CtrlInitUserPointsResponse();
    }

    /**
     * Create an instance of {@link AddFoodToCart }
     * 
     */
    public AddFoodToCart createAddFoodToCart() {
        return new AddFoodToCart();
    }

    /**
     * Create an instance of {@link FoodId }
     * 
     */
    public FoodId createFoodId() {
        return new FoodId();
    }

    /**
     * Create an instance of {@link FoodOrderId }
     * 
     */
    public FoodOrderId createFoodOrderId() {
        return new FoodOrderId();
    }

    /**
     * Create an instance of {@link FoodInit }
     * 
     */
    public FoodInit createFoodInit() {
        return new FoodInit();
    }

    /**
     * Create an instance of {@link FoodOrderItem }
     * 
     */
    public FoodOrderItem createFoodOrderItem() {
        return new FoodOrderItem();
    }

    /**
     * Create an instance of {@link Food }
     * 
     */
    public Food createFood() {
        return new Food();
    }

    /**
     * Create an instance of {@link FoodOrder }
     * 
     */
    public FoodOrder createFoodOrder() {
        return new FoodOrder();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "orderCartResponse")
    public JAXBElement<OrderCartResponse> createOrderCartResponse(OrderCartResponse value) {
        return new JAXBElement<OrderCartResponse>(_OrderCartResponse_QNAME, OrderCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "clearCartResponse")
    public JAXBElement<ClearCartResponse> createClearCartResponse(ClearCartResponse value) {
        return new JAXBElement<ClearCartResponse>(_ClearCartResponse_QNAME, ClearCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidFoodIdFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidFoodIdFault")
    public JAXBElement<InvalidFoodIdFault> createInvalidFoodIdFault(InvalidFoodIdFault value) {
        return new JAXBElement<InvalidFoodIdFault>(_InvalidFoodIdFault_QNAME, InvalidFoodIdFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFoodToCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "addFoodToCart")
    public JAXBElement<AddFoodToCart> createAddFoodToCart(AddFoodToCart value) {
        return new JAXBElement<AddFoodToCart>(_AddFoodToCart_QNAME, AddFoodToCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidTextFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidTextFault")
    public JAXBElement<InvalidTextFault> createInvalidTextFault(InvalidTextFault value) {
        return new JAXBElement<InvalidTextFault>(_InvalidTextFault_QNAME, InvalidTextFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInitUserPointsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlInitUserPointsResponse")
    public JAXBElement<CtrlInitUserPointsResponse> createCtrlInitUserPointsResponse(CtrlInitUserPointsResponse value) {
        return new JAXBElement<CtrlInitUserPointsResponse>(_CtrlInitUserPointsResponse_QNAME, CtrlInitUserPointsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "activateAccount")
    public JAXBElement<ActivateAccount> createActivateAccount(ActivateAccount value) {
        return new JAXBElement<ActivateAccount>(_ActivateAccount_QNAME, ActivateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "getFoodResponse")
    public JAXBElement<GetFoodResponse> createGetFoodResponse(GetFoodResponse value) {
        return new JAXBElement<GetFoodResponse>(_GetFoodResponse_QNAME, GetFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "accountBalance")
    public JAXBElement<AccountBalance> createAccountBalance(AccountBalance value) {
        return new JAXBElement<AccountBalance>(_AccountBalance_QNAME, AccountBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartContentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "cartContentsResponse")
    public JAXBElement<CartContentsResponse> createCartContentsResponse(CartContentsResponse value) {
        return new JAXBElement<CartContentsResponse>(_CartContentsResponse_QNAME, CartContentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "clearCart")
    public JAXBElement<ClearCart> createClearCart(ClearCart value) {
        return new JAXBElement<ClearCart>(_ClearCart_QNAME, ClearCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlPing }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlPing")
    public JAXBElement<CtrlPing> createCtrlPing(CtrlPing value) {
        return new JAXBElement<CtrlPing>(_CtrlPing_QNAME, CtrlPing.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInitFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlInitFoodResponse")
    public JAXBElement<CtrlInitFoodResponse> createCtrlInitFoodResponse(CtrlInitFoodResponse value) {
        return new JAXBElement<CtrlInitFoodResponse>(_CtrlInitFoodResponse_QNAME, CtrlInitFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHungry }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "searchHungry")
    public JAXBElement<SearchHungry> createSearchHungry(SearchHungry value) {
        return new JAXBElement<SearchHungry>(_SearchHungry_QNAME, SearchHungry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidMoneyFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidMoneyFault")
    public JAXBElement<InvalidMoneyFault> createInvalidMoneyFault(InvalidMoneyFault value) {
        return new JAXBElement<InvalidMoneyFault>(_InvalidMoneyFault_QNAME, InvalidMoneyFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlClearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlClearResponse")
    public JAXBElement<CtrlClearResponse> createCtrlClearResponse(CtrlClearResponse value) {
        return new JAXBElement<CtrlClearResponse>(_CtrlClearResponse_QNAME, CtrlClearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFoodToCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "addFoodToCartResponse")
    public JAXBElement<AddFoodToCartResponse> createAddFoodToCartResponse(AddFoodToCartResponse value) {
        return new JAXBElement<AddFoodToCartResponse>(_AddFoodToCartResponse_QNAME, AddFoodToCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "loadAccount")
    public JAXBElement<LoadAccount> createLoadAccount(LoadAccount value) {
        return new JAXBElement<LoadAccount>(_LoadAccount_QNAME, LoadAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotEnoughPointsFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "NotEnoughPointsFault")
    public JAXBElement<NotEnoughPointsFault> createNotEnoughPointsFault(NotEnoughPointsFault value) {
        return new JAXBElement<NotEnoughPointsFault>(_NotEnoughPointsFault_QNAME, NotEnoughPointsFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInitFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlInitFood")
    public JAXBElement<CtrlInitFood> createCtrlInitFood(CtrlInitFood value) {
        return new JAXBElement<CtrlInitFood>(_CtrlInitFood_QNAME, CtrlInitFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchDealResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "searchDealResponse")
    public JAXBElement<SearchDealResponse> createSearchDealResponse(SearchDealResponse value) {
        return new JAXBElement<SearchDealResponse>(_SearchDealResponse_QNAME, SearchDealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "orderCart")
    public JAXBElement<OrderCart> createOrderCart(OrderCart value) {
        return new JAXBElement<OrderCart>(_OrderCart_QNAME, OrderCart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "getFood")
    public JAXBElement<GetFood> createGetFood(GetFood value) {
        return new JAXBElement<GetFood>(_GetFood_QNAME, GetFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchDeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "searchDeal")
    public JAXBElement<SearchDeal> createSearchDeal(SearchDeal value) {
        return new JAXBElement<SearchDeal>(_SearchDeal_QNAME, SearchDeal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchHungryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "searchHungryResponse")
    public JAXBElement<SearchHungryResponse> createSearchHungryResponse(SearchHungryResponse value) {
        return new JAXBElement<SearchHungryResponse>(_SearchHungryResponse_QNAME, SearchHungryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmptyCartFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "EmptyCartFault")
    public JAXBElement<EmptyCartFault> createEmptyCartFault(EmptyCartFault value) {
        return new JAXBElement<EmptyCartFault>(_EmptyCartFault_QNAME, EmptyCartFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "accountBalanceResponse")
    public JAXBElement<AccountBalanceResponse> createAccountBalanceResponse(AccountBalanceResponse value) {
        return new JAXBElement<AccountBalanceResponse>(_AccountBalanceResponse_QNAME, AccountBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidUserIdFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidUserIdFault")
    public JAXBElement<InvalidUserIdFault> createInvalidUserIdFault(InvalidUserIdFault value) {
        return new JAXBElement<InvalidUserIdFault>(_InvalidUserIdFault_QNAME, InvalidUserIdFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlClear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlClear")
    public JAXBElement<CtrlClear> createCtrlClear(CtrlClear value) {
        return new JAXBElement<CtrlClear>(_CtrlClear_QNAME, CtrlClear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidCreditCardFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidCreditCardFault")
    public JAXBElement<InvalidCreditCardFault> createInvalidCreditCardFault(InvalidCreditCardFault value) {
        return new JAXBElement<InvalidCreditCardFault>(_InvalidCreditCardFault_QNAME, InvalidCreditCardFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivateAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "activateAccountResponse")
    public JAXBElement<ActivateAccountResponse> createActivateAccountResponse(ActivateAccountResponse value) {
        return new JAXBElement<ActivateAccountResponse>(_ActivateAccountResponse_QNAME, ActivateAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlPingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlPingResponse")
    public JAXBElement<CtrlPingResponse> createCtrlPingResponse(CtrlPingResponse value) {
        return new JAXBElement<CtrlPingResponse>(_CtrlPingResponse_QNAME, CtrlPingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoadAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "loadAccountResponse")
    public JAXBElement<LoadAccountResponse> createLoadAccountResponse(LoadAccountResponse value) {
        return new JAXBElement<LoadAccountResponse>(_LoadAccountResponse_QNAME, LoadAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidInitFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidInitFault")
    public JAXBElement<InvalidInitFault> createInvalidInitFault(InvalidInitFault value) {
        return new JAXBElement<InvalidInitFault>(_InvalidInitFault_QNAME, InvalidInitFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidFoodQuantityFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "InvalidFoodQuantityFault")
    public JAXBElement<InvalidFoodQuantityFault> createInvalidFoodQuantityFault(InvalidFoodQuantityFault value) {
        return new JAXBElement<InvalidFoodQuantityFault>(_InvalidFoodQuantityFault_QNAME, InvalidFoodQuantityFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartContents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "cartContents")
    public JAXBElement<CartContents> createCartContents(CartContents value) {
        return new JAXBElement<CartContents>(_CartContents_QNAME, CartContents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CtrlInitUserPoints }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.hub.forkexec.com/", name = "ctrlInitUserPoints")
    public JAXBElement<CtrlInitUserPoints> createCtrlInitUserPoints(CtrlInitUserPoints value) {
        return new JAXBElement<CtrlInitUserPoints>(_CtrlInitUserPoints_QNAME, CtrlInitUserPoints.class, null, value);
    }

}
