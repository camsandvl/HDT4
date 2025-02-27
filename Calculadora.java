public class Calculadora {
  private static Calculadora instance;

  private Calculadora() {
    public static Calculadora getInstance() {
      if (instance == null) {
        instance = new.Calculadora();
      }
      return instance
    } 
    
  }
}
