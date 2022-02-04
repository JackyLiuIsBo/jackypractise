package excatalyTest.auditadjust;/**
 * @program: jackypractise
 * @description:
 * @author: liubo
 * @date: 2022-01-31 00:44
 **/

/**
 @ClassName IComService
 @Description
 @Author liubo
 @Date 2022/1/31 上午12:44
 **/
public interface ICommonAuditService {
    void hander(AuditVO auditVO);
    AuditEnum getCompanyEnum();

}
