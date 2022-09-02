package energizeglobalservices.ATMservice.controller.account.deposite;

import energizeglobalservices.ATMservice.domain.Transaction;
import energizeglobalservices.ATMservice.service.BankServiceService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InternalAccountDepositController {

    private final BankServiceService bankServiceService;

    @PostMapping(path = "${apis.open}/bank-accounts/{bankAccountId}/deposit")
    public InternalAccountDepositResponse handle(@PathVariable("bankAccountId") String bankAccountId,
                                                 @RequestBody @Valid InternalAccountDepositRequest request){
        Transaction transaction = bankServiceService.depositOrWithdrawalAmountWithAccount(
                bankAccountId, request.getFingerPrint(),
                request.getAmount(), Transaction.TransactionType.CASH_DEPOSIT);

        return InternalAccountDepositResponse.builder()
                .balance(String.valueOf(transaction.getBalance()))
                .amount(String.valueOf(transaction.getAmount()))
                .accountId(String.valueOf(bankAccountId))
                .cardId(String.valueOf(transaction.getCardId()))
                .cardNumber(String.valueOf(transaction.getSourceCardNumber()))
                .transactionKey(transaction.getTransactionKey())
                .costumerFullName(transaction.getCostumerFullName())
                .build();
    }
}
