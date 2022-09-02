package energizeglobalservices.ATMservice.controller.card.withdrawal;

import energizeglobalservices.ATMservice.domain.Transaction;
import energizeglobalservices.ATMservice.service.BankServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InternalCardWithdrawalController {

    private final BankServiceService bankServiceService;

    @PostMapping(path = "${apis.open}/cards/{cardNumber}/withdrawal")
    public InternalCardWithdrawalResponse handle(@PathVariable("cardNumber") String cardNumber,
                                                 @RequestBody @Valid InternalWithdrawAccountRequest request) {

        Transaction transaction = bankServiceService.depositOrWithdrawalAmountWithCard(
                cardNumber, request.getPin1(), request.getPin1Check(), request.getFingerPrint(), request.getFingerPrintCheck(),
                request.getAmount(), Transaction.TransactionType.CASH_WITHDRAW);

        return InternalCardWithdrawalResponse.builder()
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
