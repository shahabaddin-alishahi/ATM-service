package energizeglobalservices.ATMservice.controller.account.deposite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternalAccountDepositRequest {

    private double amount;
    private String fingerPrint;

}
