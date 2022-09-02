package energizeglobalservices.ATMservice.client.bank;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResolveTokenClientResponse {

    @NotBlank
    private String token;
}
