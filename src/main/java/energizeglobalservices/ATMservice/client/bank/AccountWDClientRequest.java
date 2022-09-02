package energizeglobalservices.ATMservice.client.bank;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountWDClientRequest {

    private double amount;
    private String fingerPrint;

}
