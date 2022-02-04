package designs.pattern.structural.proxy.staticproxy;

import designs.pattern.structural.proxy.IOrderDao;
import designs.pattern.structural.proxy.IOrderService;
import designs.pattern.structural.proxy.Order;

/**
 * @ClassName staticProxy
 * @Description
 * @Author liubo
 * @Date 2021/7/3 9:30 下午
 **/
public class staticProxy {
    private IOrderService orderService;

    public staticProxy(IOrderService service){
        this.orderService = service;
    }

    public void saveOrder(Order order){

        int i = orderService.saveOrder(order);
    }


}
