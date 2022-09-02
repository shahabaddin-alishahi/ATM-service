package energizeglobalservices.ATMservice.client.bank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class CardBalanceClientRequest {

    private Boolean pin1Check;
    private String pin1;
    private String fingerPrint;
    private Boolean fingerPrintCheck;

}
