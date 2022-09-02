package energizeglobalservices.ATMservice.service;

import energizeglobalservices.ATMservice.domain.Card;
import energizeglobalservices.ATMservice.domain.Transaction;

public interface BankServiceService {

    Transaction getBalanceByAccount(String accountId, String fingerPrint);

    Transaction depositOrWithdrawalAmountWithAccount(String accountId, String fingerPrint,
                                                     double amount, Transaction.TransactionType transactionType);

    Transaction depositOrWithdrawalAmountWithCard(String cardNumber, String pin1, Boolean pin1Check,
                                                  String fingerPrint, Boolean fingerPrintCheck,
                                                  double amount, Transaction.TransactionType transactionType);


    Transaction getAccountBalanceByCard(String cardNumber, String pin1, Boolean pin1Check,
                                        String fingerPrint, Boolean fingerPrintCheck);

    Card getCard(String cardNumber);
}
