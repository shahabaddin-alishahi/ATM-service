package energizeglobalservices.ATMservice.service.impl;

import energizeglobalservices.ATMservice.client.bank.*;
import energizeglobalservices.ATMservice.config.exception.CardBlockedOrSuspendException;
import energizeglobalservices.ATMservice.domain.Card;
import energizeglobalservices.ATMservice.domain.Transaction;
import energizeglobalservices.ATMservice.service.BankServiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankServiceServiceImpl implements BankServiceService {

    private final BankServiceAPIClient bankServiceAPIClient;

    @Override
    public Transaction getBalanceByAccount(String accountId, String fingerPrint) {

        AccountBalanceClientResponse response = bankServiceAPIClient.getBalanceByAccount(accountId,
                AccountBalanceClientRequest.builder()
                        .fingerPrint(fingerPrint)
                        .build());

        return Transaction.builder()
                .balance(response.getBalance())
                .accountId(response.getAccountId())
                .cardId(response.getCardId())
                .sourceCardNumber(response.getCardNumber())
                .transactionKey(response.getTransactionKey())
                .statusType(Transaction.TransactionStatus.SUCCEED)
                .costumerFullName(response.getCostumerFullName())
                .requestType(Transaction.TransactionType.CHECK_BALANCE)
                .build();
    }

    @Override
    public Transaction depositOrWithdrawalAmountWithAccount(String accountId, String fingerPrint, double amount, Transaction.TransactionType transactionType) {

        AccountWDClientResponse response;
        if (transactionType.equals(Transaction.TransactionType.CASH_DEPOSIT)) {
            response = bankServiceAPIClient.depositAmountWithAccount(accountId, AccountWDClientRequest.builder()
                    .amount(amount)
                    .fingerPrint(fingerPrint)
                    .build());
        } else {
            response = bankServiceAPIClient.withdrawalAmountWithAccount(accountId, AccountWDClientRequest.builder()
                    .amount(amount)
                    .fingerPrint(fingerPrint)
                    .build());
        }
        return Transaction.builder()
                .amount(response.getAmount())
                .accountId(response.getAccountId())
                .balance(response.getBalance())
                .cardId(response.getCardId())
                .sourceCardNumber(response.getCardNumber())
                .transactionKey(response.getTransactionKey())
                .statusType(Transaction.TransactionStatus.SUCCEED)
                .costumerFullName(response.getCostumerFullName())
                .requestType(transactionType.equals(Transaction.TransactionType.CASH_DEPOSIT) ?
                        Transaction.TransactionType.CASH_DEPOSIT : Transaction.TransactionType.CASH_WITHDRAW)
                .build();
    }

    @Override
    public Card getCard(String cardNumber) {

        CardValidationClientResponse response = bankServiceAPIClient.cardValidation(cardNumber);

        return Card.builder()
                .cardNumber(response.getCardNumber())
                .id(response.getCardId())
                .accountId(response.getAccountId())
                .blocked(response.isBlocked())
                .suspended(response.isSuspended())
                .failureRetryCount(response.getFailureRetryCount())
                .customerId(response.getCostumerId())
                .build();
    }

    @Override
    public Transaction getAccountBalanceByCard(String cardNumber, String pin1, Boolean pin1Check,
                                               String fingerPrint, Boolean fingerPrintCheck) {

        CardBalanceClientResponse response = bankServiceAPIClient.getBalanceByCard(cardNumber,
                CardBalanceClientRequest.builder()
                        .pin1Check(pin1Check)
                        .pin1(pin1)
                        .fingerPrintCheck(fingerPrintCheck)
                        .fingerPrint(fingerPrint)
                        .build());

        return Transaction.builder()
                .balance(response.getBalance())
                .accountId(response.getAccountId())
                .cardId(response.getCardId())
                .sourceCardNumber(response.getCardNumber())
                .transactionKey(response.getTransactionKey())
                .statusType(Transaction.TransactionStatus.SUCCEED)
                .costumerFullName(response.getCostumerFullName())
                .requestType(Transaction.TransactionType.CHECK_BALANCE)
                .build();
    }

    @Override
    public Transaction depositOrWithdrawalAmountWithCard(String cardNumber, String pin1, Boolean pin1Check,
                                                         String fingerPrint, Boolean fingerPrintCheck,
                                                         double amount, Transaction.TransactionType transactionType) {
        CardValidationClientResponse cardValidationClientResponse = bankServiceAPIClient.cardValidation(cardNumber);

        if (cardValidationClientResponse.isBlocked() || cardValidationClientResponse.isSuspended()) {
            throw new CardBlockedOrSuspendException();
        }

        CardWDClientResponse response;
        if (transactionType.equals(Transaction.TransactionType.CASH_DEPOSIT)) {
            response = bankServiceAPIClient.depositAmountWithCard(String.valueOf(cardValidationClientResponse.getCardId()),
                    CardWDClientRequest.builder()
                            .amount(amount)
                            .pin1(pin1)
                            .pin1Check(pin1Check)
                            .fingerPrintCheck(fingerPrintCheck)
                            .fingerPrint(fingerPrint)
                            .build());
        } else {
            response = bankServiceAPIClient.withdrawalAmountWithCard(String.valueOf(cardValidationClientResponse.getCardId()),
                    CardWDClientRequest.builder()
                            .amount(amount)
                            .pin1(pin1)
                            .pin1Check(pin1Check)
                            .fingerPrintCheck(fingerPrintCheck)
                            .fingerPrint(fingerPrint)
                            .build());
        }
        return Transaction.builder()
                .amount(response.getAmount())
                .accountId(response.getAccountId())
                .balance(response.getBalance())
                .cardId(response.getCardId())
                .sourceCardNumber(response.getCardNumber())
                .transactionKey(response.getTransactionKey())
                .statusType(Transaction.TransactionStatus.SUCCEED)
                .costumerFullName(response.getCostumerFullName())
                .requestType(transactionType.equals(Transaction.TransactionType.CASH_DEPOSIT) ?
                        Transaction.TransactionType.CASH_DEPOSIT : Transaction.TransactionType.CASH_WITHDRAW)
                .build();
    }
}
