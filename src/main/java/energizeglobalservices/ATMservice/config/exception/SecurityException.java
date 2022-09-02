package energizeglobalservices.ATMservice.config.exception;

public class SecurityException extends BusinessException {
    {
        super.logStackTrace = ExceptionSetting.StackTraceDecision.FULL;
    }
}
