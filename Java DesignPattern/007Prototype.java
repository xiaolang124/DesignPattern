浅拷贝: 对值类型的成员变量进行值的复制,对引用类型的成员变量只复制引用,不复制引用的对象.
深拷贝: 对值类型的成员变量进行值的复制,对引用类型的成员变量也进行引用对象的复制.

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

结果:
original object:changed object1
cloned object:original object

public class Prototype{
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

}

public class NewPrototype implements Cloneable{
    private String id;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id=id;
    }
     private Prototype prototype;
 
    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }

    public Object clone(){ 
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
        // TODO Auto-generated method stub
        testPrototype();
    }
 
    private static void testPrototype(){
        Prototype pro = new Prototype();
        pro.setName("original object");
        NewPrototype newObj = new NewPrototype();
        newObj.setId("test1");
        newObj.setPrototype(pro);
        
        NewPrototype copyObj = (NewPrototype)newObj.clone();
        copyObj.setId("testCopy");
        copyObj.getPrototype().setName("changed object");
        
        System.out.println("original object id:" + newObj.getId());
        System.out.println("original object name:" + newObj.getPrototype().getName());
        
        System.out.println("cloned object id:" + copyObj.getId());
        System.out.println("cloned object name:" + copyObj.getPrototype().getName());
        
    }

}

original object id:test1
original object name:changed object
cloned object id:testCopy
cloned object name:changed object