package energizeglobalservices.ATMservice.controller.card.deposite;

import energizeglobalservices.ATMservice.domain.Transaction;
import energizeglobalservices.ATMservice.service.BankServiceService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InternalCardDepositController {

    private final BankServiceService bankServiceService;

    @PostMapping(path = "${apis.open}/cards/{cardNumber}/deposit")
    public InternalCardDepositResponse handle(@PathVariable("cardNumber") String cardNumber,
                                              @RequestBody @Valid InternalDepositCardRequest request){

        Transaction transaction = bankServiceService.depositOrWithdrawalAmountWithCard(
                cardNumber, request.getPin1(), request.getPin1Check(), request.getFingerPrint(), request.getFingerPrintCheck(),
                request.getAmount(), Transaction.TransactionType.CASH_DEPOSIT);

        return InternalCardDepositResponse.builder()
                .balance(String.valueOf(transaction.getBalance()))
                .amount(String.valueOf(transaction.getAmount()))
                .accountId(String.valueOf(transaction.getAccountId()))
                .cardId(String.valueOf(transaction.getCardId()))
                .cardNumber(String.valueOf(transaction.getSourceCardNumber()))
                .transactionKey(transaction.getTransactionKey())
                .costumerFullName(transaction.getCostumerFullName())
                .build();

    }
}
