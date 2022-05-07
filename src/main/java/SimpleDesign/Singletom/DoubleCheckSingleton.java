package SimpleDesign.Singletom;

public class DoubleCheckSingleton {
  private DoubleCheckSingleton(){

  }
  private static DoubleCheckSingleton doubleCheckSingleton ;

  public DoubleCheckSingleton getInstance(){
      if(doubleCheckSingleton == null){
          synchronized (DoubleCheckSingleton.class){
              if(doubleCheckSingleton == null){
                  doubleCheckSingleton = new DoubleCheckSingleton();
              }
          }
      }
      return  doubleCheckSingleton;
  }
}
