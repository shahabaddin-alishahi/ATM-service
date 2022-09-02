package energizeglobalservices.ATMservice.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
@Setter
public class Account {

    private Long id;

    private Long customerId;

    private int failureRetryCount;

    private Set<Card> cards;

    private boolean isEnabled;

    private Double balance;

    private LocalDateTime registrationDate;

    private LocalDateTime updateDate;

}
