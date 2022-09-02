package energizeglobalservices.ATMservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class Transaction {

    public enum TransactionType {
        CASH_DEPOSIT,
        CASH_WITHDRAW,
        TRANSFER_AMOUNT,
        CHECK_BALANCE
    }

    public enum TransactionStatus {
        SUCCEED, FAILED
    }

    private Long cardId;

    private Long accountId;

    private TransactionType requestType;

    private TransactionStatus statusType;

    private String sourceCardNumber;

    private String destinationCardNumber;

    private String transactionKey;

    private Double amount;

    private Double balance;

    private String costumerFullName;

}
