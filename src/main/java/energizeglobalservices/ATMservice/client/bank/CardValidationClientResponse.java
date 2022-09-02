package energizeglobalservices.ATMservice.client.bank;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CardValidationClientResponse {

    private Double balance;
    private Long accountId;
    private Long cardId;
    private String cardNumber;
    private Long costumerId;
    private String costumerFullName;
    private int failureRetryCount;
    private boolean suspended;
    private boolean blocked;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
