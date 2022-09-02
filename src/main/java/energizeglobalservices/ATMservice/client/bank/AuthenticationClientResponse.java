package energizeglobalservices.ATMservice.client.bank;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationClientResponse {

    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpirationTimeInMilliSeconds;
    private Long refreshTokenExpirationTimeInMilliSeconds;
}
