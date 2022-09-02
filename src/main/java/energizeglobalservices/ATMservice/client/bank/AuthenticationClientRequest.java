package energizeglobalservices.ATMservice.client.bank;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class AuthenticationClientRequest {
    private String username;
    private String password;
}
