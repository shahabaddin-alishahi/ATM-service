package energizeglobalservices.ATMservice.config.exception;

public class InvalidTokenException extends SecurityException {
    {
        super.logStackTrace = ExceptionSetting.StackTraceDecision.FIRST;
    }
}
