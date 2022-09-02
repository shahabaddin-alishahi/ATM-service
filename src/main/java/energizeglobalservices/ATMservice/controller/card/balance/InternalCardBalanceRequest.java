package energizeglobalservices.ATMservice.controller.card.balance;

import lombok.Getter;

@Getter
public class InternalCardBalanceRequest {

    private double amount;
    private Boolean pin1Check;
    private String pin1;
    private String fingerPrint;
    private Boolean fingerPrintCheck;

}
