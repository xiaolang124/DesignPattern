//步骤 1
//创建一个接口。
//	Image.java
public interface Image {
   void display();
}
//步骤 2
//创建实现接口的实体类。
//	RealImage.java
public class RealImage implements Image {

   private String fileName;

   public RealImage(String fileName){
      this.fileName = fileName;
      loadFromDisk(fileName);
   }

   @Override
   public void display() {
      System.out.println("Displaying " + fileName);
   }

   private void loadFromDisk(String fileName){
      System.out.println("Loading " + fileName);
   }
}
//	ProxyImage.java
public class ProxyImage implements Image{

   private RealImage realImage;
   private String fileName;

   public ProxyImage(String fileName){
      this.fileName = fileName;
   }

   @Override
   public void display() {
      if(realImage == null){
         realImage = new RealImage(fileName);
      }
      realImage.display();
   }
}
//步骤 3
//当被请求时，使用 ProxyImage 来获取 RealImage 类的对象。
//	ProxyPatternDemo.java
public class ProxyPatternDemo {
	
   public static void main(String[] args) {
      Image image = new ProxyImage("test_10mb.jpg");

      //图像将从磁盘加载
      image.display(); 
      System.out.println("");
      //图像将无法从磁盘加载
      image.display(); 	
   }
}
//步骤 4
//验证输出。
Loading test_10mb.jpg
Displaying test_10mb.jpg

Displaying test_10mb.jpg