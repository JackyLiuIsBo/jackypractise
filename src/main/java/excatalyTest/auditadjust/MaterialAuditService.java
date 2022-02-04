package excatalyTest.auditadjust;/**
 * @program: jackypractise
 * @description: 物料审核类
 * @author: liubo
 * @date: 2022-01-31 00:55
 **/

/**
 @ClassName MaterialAuditService
 @Description
 @Author liubo
 @Date 2022/1/31 上午12:55
 **/
public class MaterialAuditService extends AbstractAuditService implements ICommonAuditService {
    @Override
    protected boolean sendMessage(AuditVO auditVO) {
        System.out.println("send material message");
        return true;
    }

    @Override
    protected boolean addLog(AuditVO auditVO) {
        System.out.println("add material log");
        return true;
    }

    @Override
    boolean auditItem(AuditVO auditVO) {
        System.out.println("audit materials ");
        return true;
    }

    @Override
    public void hander(AuditVO auditVO) {
        auditItem(auditVO);
        sendMessage(auditVO);
        addLog(auditVO);
    }

    @Override
    public AuditEnum getCompanyEnum() {
        return AuditEnum.MATERIAL;
    }
}
