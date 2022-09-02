package energizeglobalservices.ATMservice.controller.account.deposite;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InternalAccountDepositResponse {

    private String balance;
    private String amount;
    private String accountId;
    private String cardId;
    private String cardNumber;
    private String transactionKey;
    private String costumerFullName;
}
