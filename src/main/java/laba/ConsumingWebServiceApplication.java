package laba;


import laba.clients.AddressClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumingWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingWebServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(AddressClient quoteClient) {
        return args -> {
            GetAddressResponse response = quoteClient.getAddress(1);
            System.err.println(response.getAddress().getCity());
            System.err.println(response.getAddress().getBuilding());
            System.err.println(response.getAddress().getStreet());
            System.err.println(response.getAddress().getRoom());
        };
    }
}
