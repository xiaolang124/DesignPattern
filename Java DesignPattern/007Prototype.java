public class Prototype implements Cloneable {
   private String name;

   public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public Object clone() {
      try {
         return super.clone();
     } catch (CloneNotSupportedException e) {   
         e.printStackTrace();
         return null;
     }
 } 
 
}

public class TestMain {

   public static void main(String[] args) {
      testPrototype();
  }
  
  private static void testPrototype(){
      Prototype pro = new Prototype();
      pro.setName("original object");
      Prototype pro1 = (Prototype)pro.clone();
      pro.setName("changed object1");
      
      System.out.println("original object:" + pro.getName());
      System.out.println("cloned object:" + pro1.getName());
      
  }

}