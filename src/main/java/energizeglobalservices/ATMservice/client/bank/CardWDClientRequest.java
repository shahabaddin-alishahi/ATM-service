package energizeglobalservices.ATMservice.client.bank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CardWDClientRequest {

    private double amount;
    private Boolean pin1Check;
    private String pin1;
    private String fingerPrint;
    private Boolean fingerPrintCheck;

}
