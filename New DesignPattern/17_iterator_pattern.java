//步骤 1
//创建接口。
//	Iterator.java
public interface Iterator {
   public boolean hasNext();
   public Object next();
}
//	Container.java
public interface Container {
   public Iterator getIterator();
}
//步骤 2
//创建实现了 Container 接口的实体类。该类有实现了 Iterator 接口的内部类 NameIterator。
//	NameRepository.java
public class NameRepository implements Container {
   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};

   @Override
   public Iterator getIterator() {
      return new NameIterator();
   }

   private class NameIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {
         if(index < names.length){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
         if(this.hasNext()){
            return names[index++];
         }
         return null;
      }		
   }
}
//步骤 3
//使用 NameRepository 来获取迭代器，并打印名字。
//	IteratorPatternDemo.java
public class IteratorPatternDemo {
	
   public static void main(String[] args) {
      NameRepository namesRepository = new NameRepository();

      for(Iterator iter = namesRepository.getIterator(); iter.hasNext();){
         String name = (String)iter.next();
         System.out.println("Name : " + name);
      } 	
   }
}
//步骤 4
验证输出。
Name : Robert
Name : John
Name : Julie
Name : Lora