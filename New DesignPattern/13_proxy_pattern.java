//���� 1
//����һ���ӿڡ�
//	Image.java
public interface Image {
   void display();
}
//���� 2
//����ʵ�ֽӿڵ�ʵ���ࡣ
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
//���� 3
//��������ʱ��ʹ�� ProxyImage ����ȡ RealImage ��Ķ���
//	ProxyPatternDemo.java
public class ProxyPatternDemo {
	
   public static void main(String[] args) {
      Image image = new ProxyImage("test_10mb.jpg");

      //ͼ�񽫴Ӵ��̼���
      image.display(); 
      System.out.println("");
      //ͼ���޷��Ӵ��̼���
      image.display(); 	
   }
}
//���� 4
//��֤�����
Loading test_10mb.jpg
Displaying test_10mb.jpg

Displaying test_10mb.jpg