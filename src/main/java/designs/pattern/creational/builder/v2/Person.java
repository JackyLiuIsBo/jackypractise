package designs.pattern.creational.builder.v2;

/**
 * @ClassName Person
 * @Description
 * @Author liubo
 * @Date 2021/4/20 5:31 下午
 **/
public class Person {
    int height;
    int weight;
    String name;

    private Person (builder builder){
        this.height = builder.height;
        this.weight  = builder.weight;
        this.name = builder.name;
    }

    @Override
    public String toString() {
        return "Person{" +
            "height=" + height +
            ", weight=" + weight +
            ", name='" + name + '\'' +
            '}';
    }

    private static class builder{
        int height;
        int weight;
        String name;
        public builder setHeight(int height){
            this.height = height;
            return this;
        }
        public builder setWeight(int height){
            this.weight = height;
            return this;
        }
        public builder setName(String height){
            this.name = height;
            return this;
        }
        public Person  build( ){
          return   new Person(this);
        }
    }

    public static void main(String[] args) {
        Person name = new builder().setHeight(18).setName("name").build();
        System.out.println(name.toString());
    }
}
