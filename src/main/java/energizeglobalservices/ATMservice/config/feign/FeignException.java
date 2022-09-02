package energizeglobalservices.ATMservice.config.feign;

import energizeglobalservices.ATMservice.config.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeignException extends BusinessException {
    private int status;
    private String message;
}
