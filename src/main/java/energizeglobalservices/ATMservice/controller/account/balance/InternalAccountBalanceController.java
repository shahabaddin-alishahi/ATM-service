package energizeglobalservices.ATMservice.controller.account.balance;



import energizeglobalservices.ATMservice.domain.Transaction;
import energizeglobalservices.ATMservice.service.BankServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InternalAccountBalanceController {

    private final BankServiceService bankServiceService;

    @PostMapping(path = "${apis.open}/bank-accounts/{bankAccountId}/balance")
    public InternalAccountBalanceResponse handle(@PathVariable("bankAccountId") String bankAccountId,
                                                 @RequestBody @Valid InternalAccountBalanceRequest request) {
        Transaction transaction = bankServiceService.getBalanceByAccount(bankAccountId, request.getFingerPrint());

        return InternalAccountBalanceResponse.builder()
                .accountId(bankAccountId)
                .cardNumber(transaction.getSourceCardNumber())
                .balance(String.valueOf(transaction.getBalance()))
                .cardId(String.valueOf(transaction.getCardId()))
                .transactionKey(transaction.getTransactionKey())
                .costumerFullName(transaction.getCostumerFullName())
                .build();
    }
}
