package energizeglobalservices.ATMservice.controller.card.balance;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InternalCardBalanceResponse {

    private String balance;
//    Double totalBalance;
//    Double freezeAmount;
//    Double availableBalance;

    private String accountId;
    private String cardId;
    private String cardNumber;
    private String transactionKey;
    private String costumerId;
    private String costumerFullName;
}
