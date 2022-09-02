package energizeglobalservices.ATMservice.controller.card.validation;


import energizeglobalservices.ATMservice.domain.Card;
import energizeglobalservices.ATMservice.service.BankServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InternalCardValidationController {

    private final BankServiceService bankServiceService;

    @GetMapping(path = "${apis.open}/cards/{cardNumber}/validation")
    public InternalCardValidationResponse handle(@PathVariable("cardNumber") String cardNumber){
        Card card = bankServiceService.getCard(cardNumber);

        return InternalCardValidationResponse.builder()
                .accountId(String.valueOf(card.getAccountId()))
                .cardId(String.valueOf(card.getId()))
                .cardNumber(card.getCardNumber())
                .costumerId(String.valueOf(card.getCustomerId()))
                .blocked(card.isBlocked())
                .suspended(card.isSuspended())
                .failureRetryCount(card.getFailureRetryCount())
                .build();
    }
}
