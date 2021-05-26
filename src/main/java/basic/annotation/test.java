package basic.annotation;

import java.lang.annotation.Annotation;

public class test {
    @myFirst(name = "jacky",age = 11)
    public void getMessage(){
            return;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //Annotation[] annotation = Class.forName("test").getMethod("getMessage").getAnnotations();
        //for (Annotation a:annotation
        //     ) {
        //    System.out.println(a);
        //}
        String url = "https://img.alicdn.com/imgextra/i1/2200800257627/O1CN0126DDKrxRWUwDdlM_!!2200800257627-0-koubei.jpg";
        String temp = "aaa" +  url.substring(url.lastIndexOf("."));
        System.out.println(temp);
    }



}
