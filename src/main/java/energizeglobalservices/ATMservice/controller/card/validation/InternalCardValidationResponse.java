package energizeglobalservices.ATMservice.controller.card.validation;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class InternalCardValidationResponse {

    private String accountId;
    private String cardId;
    private String cardNumber;
    private String costumerId;
    private int failureRetryCount;
    private boolean suspended;
    private boolean blocked;
}
