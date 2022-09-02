package energizeglobalservices.ATMservice.config.exception;

public class NotFoundException extends BusinessException {
    {
        super.logStackTrace = ExceptionSetting.StackTraceDecision.PARTIAL;
    }
}
