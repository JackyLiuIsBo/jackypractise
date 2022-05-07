package SimpleDesign.Builder.other;/**
 * @program: jackypractise
 * @description: 建造者类
 * @author: liubo
 * @date: 2022-03-19 23:42
 **/

/**
 @ClassName Builder
 @Description
 @Author liubo
 @Date 2022/3/19 11:42 下午
 **/
public class Builder {
    private String name;

    private Integer code;

    public Builder appendName(String name){
        this.name = name;
        return this;
    }

    public Builder appendCode(Integer code){
        this.code = code;
        return this;
    }

    public String getDetail(){
        System.out.println(name + code);
        return name+code;
    }

    public static void main(String[] args) {
        Builder builder = new Builder().appendCode(12).appendName("builder");
        builder.getDetail();
    }
}
