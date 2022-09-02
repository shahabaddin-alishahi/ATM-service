package energizeglobalservices.ATMservice.controller.account.balance;

import lombok.*;

@Getter
@Setter
@Builder
public class InternalAccountBalanceResponse {

    private String balance;
    private String accountId;
    private String cardId;
    private String  cardNumber;
    private String transactionKey;
    private String costumerId;
    private String costumerFullName;
}
