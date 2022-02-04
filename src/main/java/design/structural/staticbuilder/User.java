package design.structural.staticbuilder;

/**
 * @ClassName User
 * @Description
 * @Author liubo
 * @Date 2021/7/3 10:01 下午
 **/
public class User {
    private Integer userId;

    private String name;

    private String shopId;

    private User(builder builder){
        userId = builder.userId;
        name = builder.name;
        shopId = builder.shopId;
    }

    public static class builder{
        private Integer userId;

        private String name;

        private String shopId;

        public builder setUserId(Integer userId){
            this.userId = userId;
            return this;
        }

        public builder setUserName(String userName){
            this.name = userName;
            return this;
        }
        public builder setShopId(String shopId){
            this.shopId = shopId;
            return this;
        }

        public User builder(){
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
            "userId=" + userId +
            ", name='" + name + '\'' +
            ", shopId='" + shopId + '\'' +
            '}';
    }

    public static void main(String[] args) {
        User jacky = new builder().setUserId(123).setUserName("jacky").builder();
        System.out.println( jacky.toString());
    }
}
