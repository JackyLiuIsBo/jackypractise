package excatalyTest.auditadjust;/**
 * @program: jackypractise
 * @description:
 * @author: liubo
 * @date: 2022-01-31 00:45
 **/

/**
 @ClassName AbstractAuditService
 @Description
 @Author liubo
 @Date 2022/1/31 上午12:45
 **/
public abstract class AbstractAuditService {
    Boolean auditTemplate(AuditVO auditVO){
        boolean auditItem = auditItem(auditVO);
        addLog(auditVO);
        sendMessage(auditVO);
        return auditItem;
    }

    protected abstract boolean sendMessage(AuditVO auditVO);

    protected abstract boolean addLog(AuditVO auditVO);

    abstract  boolean auditItem(AuditVO auditVO) ;

}
