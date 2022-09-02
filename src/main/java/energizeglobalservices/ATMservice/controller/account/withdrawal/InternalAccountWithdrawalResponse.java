package energizeglobalservices.ATMservice.controller.account.withdrawal;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InternalAccountWithdrawalResponse {

    private String balance;
    private String amount;
    private String accountId;
    private String cardId;
    private String cardNumber;
    private String transactionKey;
    private String costumerId;
    private String costumerFullName;
}
