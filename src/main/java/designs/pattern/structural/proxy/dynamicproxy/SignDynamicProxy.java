package designs.pattern.structural.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName SignDynamicProxy
 * @Description
 * @Author liubo
 * @Date 2021/4/20 8:05 下午
 **/
public class SignDynamicProxy implements InvocationHandler {

    private Object person;

    public Object getInstance(Person person){
        this.person = person;
        Class<? extends Person> Class = person.getClass();
        return Proxy.newProxyInstance(Class.getClassLoader(),Class.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.person,args);
        return null;
    }

    private void before(){
        System.out.println("方法开始之前");
    }



    public static void main(String[] args) {
        Person person = (Person)new SignDynamicProxy().getInstance(new Teacher());
        person.makeLive();
    }

}
