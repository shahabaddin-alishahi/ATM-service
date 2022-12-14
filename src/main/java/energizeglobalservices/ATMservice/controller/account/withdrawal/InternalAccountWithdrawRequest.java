package energizeglobalservices.ATMservice.controller.account.withdrawal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InternalAccountWithdrawRequest {

    private double amount;
    private String fingerPrint;
}
