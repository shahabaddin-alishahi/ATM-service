package energizeglobalservices.ATMservice;

import energizeglobalservices.ATMservice.client.bank.AuthenticationClientRequest;
import energizeglobalservices.ATMservice.client.bank.AuthenticationClientResponse;
import energizeglobalservices.ATMservice.client.bank.BankServiceAPIClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ApplicationStartupConfig {

    private final BankServiceAPIClient bankServiceAPIClient;

    @Value("${services.bank-service.username}")
    private String bankServiceUsername;

    @Value("${services.bank-service.password}")
    private String bankServicePassword;
    @Bean
    public void loginATMServiceToBankService() {

        AuthenticationClientResponse response = bankServiceAPIClient.login(AuthenticationClientRequest.builder()
                        .username(bankServiceUsername)
                        .password(bankServicePassword)
                .build());

    }
}
