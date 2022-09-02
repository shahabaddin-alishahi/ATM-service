package energizeglobalservices.ATMservice.client.mock;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

@Profile("development")
@Retry(name = "bank-service-repository")
@FeignClient(name = "${services.bank-service.name}" , url = "${services.bank-service.url}")
public interface BankServiceAPIClient extends energizeglobalservices.ATMservice.client.bank.BankServiceAPIClient {
}
