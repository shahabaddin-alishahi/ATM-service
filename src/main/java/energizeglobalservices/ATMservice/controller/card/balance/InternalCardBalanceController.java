package energizeglobalservices.ATMservice.controller.card.balance;


import energizeglobalservices.ATMservice.domain.Transaction;
import energizeglobalservices.ATMservice.service.BankServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InternalCardBalanceController {

    private final BankServiceService bankServiceService;

    @PostMapping(path = "${apis.open}/cards/{cardNumber}/balance")
    public InternalCardBalanceResponse handle(@PathVariable("cardNumber") String cardNumber,
                                              @RequestBody InternalCardBalanceRequest request){
        Transaction transaction = bankServiceService.getAccountBalanceByCard(cardNumber,
                request.getPin1(),
                request.getPin1Check() !=null ? request.getPin1Check() : false,
                request.getFingerPrint(),
                request.getFingerPrintCheck() != null ? request.getFingerPrintCheck() : false);

        return InternalCardBalanceResponse.builder()
                .accountId(String.valueOf(transaction.getAccountId()))
                .cardNumber(transaction.getSourceCardNumber())
                .balance(String.valueOf(transaction.getBalance()))
                .cardId(String.valueOf(transaction.getCardId()))
                .transactionKey(transaction.getTransactionKey())
                .costumerFullName(transaction.getCostumerFullName())
                .build();
    }
}
