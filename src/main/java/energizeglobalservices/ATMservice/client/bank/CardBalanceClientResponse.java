package energizeglobalservices.ATMservice.client.bank;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CardBalanceClientResponse {

    private Double balance;
//    Double totalBalance;
//    Double freezeAmount;
//    Double availableBalance;

    private Long accountId;
    private Long cardId;
    private String cardNumber;
    private String transactionKey;
    private Long costumerId;
    private String costumerFullName;
}
