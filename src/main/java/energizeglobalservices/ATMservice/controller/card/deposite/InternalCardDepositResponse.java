package energizeglobalservices.ATMservice.controller.card.deposite;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InternalCardDepositResponse {

    private String balance;
    private String amount;
    private String accountId;
    private String cardId;
    private String cardNumber;
    private String transactionKey;
    private String costumerId;
    private String costumerFullName;

}
