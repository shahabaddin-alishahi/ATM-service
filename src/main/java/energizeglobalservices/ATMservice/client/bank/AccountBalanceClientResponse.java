package energizeglobalservices.ATMservice.client.bank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AccountBalanceClientResponse {

    private Double balance;
    private Long accountId;
    private Long cardId;
    private String cardNumber;
    private String transactionKey;
    private Long costumerId;
    private String costumerFullName;
}
