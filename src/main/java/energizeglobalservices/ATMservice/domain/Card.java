package energizeglobalservices.ATMservice.domain;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class Card {

    private Long id;

    private Long customerId;

    private Long accountId;

    private String cardNumber;

    private int failureRetryCount;

    private boolean suspended;

    private boolean blocked;


}
