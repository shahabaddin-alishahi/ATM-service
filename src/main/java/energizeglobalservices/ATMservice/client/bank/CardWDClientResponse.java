package energizeglobalservices.ATMservice.client.bank;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CardWDClientResponse {

    private Double balance;
    private Double amount;
    private Long accountId;
    private Long cardId;
    private String cardNumber;
    private String transactionKey;
    private Long costumerId;
    private String costumerFullName;

}
