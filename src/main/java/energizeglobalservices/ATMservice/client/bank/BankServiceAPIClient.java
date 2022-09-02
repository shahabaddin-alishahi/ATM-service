package energizeglobalservices.ATMservice.client.bank;

import energizeglobalservices.ATMservice.config.feign.FallbackException;
import energizeglobalservices.ATMservice.config.feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Profile("!test & !development")
@FeignClient(name = "${services.bank-service.name}")
@Retry(name = "default-config")
public interface BankServiceAPIClient {
    Logger logger = LoggerFactory.getLogger(BankServiceAPIClient.class);

    default Throwable parseThrowable(Throwable t) {
        logger.error("Fallback Error : " + t.getMessage());

        if (t instanceof FeignException)
            return t;

        else
            return new FallbackException();
    }

    @PostMapping("${services.bank-service.resolve-tokens-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "resolveTokenFallBack")
    ResolveTokenClientResponse resolveToken(@RequestBody ResolveTokenRequest request);


    default ResolveTokenClientResponse resolveTokenFallBack(ResolveTokenRequest request, Throwable t) throws Throwable {
        throw parseThrowable(t);
    }

    @PostMapping("${services.bank-service.login-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "loginFallBack")
    AuthenticationClientResponse login (@RequestBody AuthenticationClientRequest request);

    default AuthenticationClientResponse loginFallBack(AuthenticationClientRequest request, Throwable t) throws Throwable {
        throw parseThrowable(t);
    }


    @PostMapping("${services.bank-service.get-balance-by-account-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "getBalanceByAccountFallBack")
    AccountBalanceClientResponse getBalanceByAccount(@RequestParam(value = "bankAccountId") String bankAccountId,
                                                    @RequestBody AccountBalanceClientRequest request);

    default AccountBalanceClientResponse getBalanceByAccountFallBack(String bankAccountId,
                                                                     AccountBalanceClientRequest request,
                                                                  Throwable t) throws Throwable {
        throw parseThrowable(t);
    }

    @PostMapping("${services.bank-service.get-balance-by-card-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "getBalanceByCardFallBack")
    CardBalanceClientResponse getBalanceByCard(@RequestParam(value = "bankAccountId") String bankAccountId,
                                                     @RequestBody CardBalanceClientRequest request);

    default CardBalanceClientResponse getBalanceByCardFallBack(String bankAccountId,
                                                                     CardBalanceClientRequest request,
                                                                     Throwable t) throws Throwable {
        throw parseThrowable(t);
    }

    @PostMapping("${services.bank-service.withdrawal-amout-by-account-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "withdrawalAmountWithAccountFallBack")
    AccountWDClientResponse withdrawalAmountWithAccount(@RequestParam(value = "bankAccountId") String bankAccountId,
                                                     @RequestBody AccountWDClientRequest request);

    default AccountWDClientResponse withdrawalAmountWithAccountFallBack(String bankAccountId,
                                                                             AccountWDClientRequest request,
                                                                     Throwable t) throws Throwable {
        throw parseThrowable(t);
    }

    @PostMapping("${services.bank-service.deposit-amount-by-account-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "depositAmountWithAccountFallBack")
    AccountWDClientResponse depositAmountWithAccount(@RequestParam(value = "bankAccountId") String bankAccountId,
                                                     @RequestBody AccountWDClientRequest request);

    default AccountWDClientResponse depositAmountWithAccountFallBack(String bankAccountId,
                                                                          AccountWDClientRequest request,
                                                                     Throwable t) throws Throwable {
        throw parseThrowable(t);
    }


    @PostMapping("${services.bank-service.withdrawal-amount-by-card-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "withdrawalAmountWithCardFallBack")
    CardWDClientResponse withdrawalAmountWithCard(@RequestParam(value = "cardId") String cardId,
                                                  @RequestBody CardWDClientRequest request);

    default CardWDClientResponse withdrawalAmountWithCardFallBack(String cardId,
                                                                        CardWDClientRequest request,
                                                                        Throwable t) throws Throwable {
        throw parseThrowable(t);
    }

    @PostMapping("${services.bank-service.deposit-amount-by-card-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "depositAmountWithCardFallBack")
    CardWDClientResponse depositAmountWithCard(@RequestParam(value = "cardId") String cardId,
                                                     @RequestBody CardWDClientRequest request);

    default CardWDClientResponse depositAmountWithCardFallBack(String cardId,
                                                                     CardWDClientRequest request,
                                                                     Throwable t) throws Throwable {
        throw parseThrowable(t);
    }

    @GetMapping("${services.bank-service.card-validation-url}")
    @CircuitBreaker(name = "default-config", fallbackMethod = "cardValidationFallBack")
    CardValidationClientResponse cardValidation(@RequestParam(value = "cardNumber") String cardNumber);

    default CardValidationClientResponse cardValidationFallBack(String cardNumber,
                                                                  Throwable t) throws Throwable {
        throw parseThrowable(t);
    }
}
