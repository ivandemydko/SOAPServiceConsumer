package laba.clients;


import laba.GetAddressRequest;
import laba.GetAddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class AddressClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(AddressClient.class);

    public GetAddressResponse getAddress(int id) {
        GetAddressRequest request = new GetAddressRequest();
        request.setId(id);

        log.info("Requesting an address for id:" + id);

        GetAddressResponse response = (GetAddressResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/addresses", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

        return response;
    }


}
