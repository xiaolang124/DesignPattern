//1
//Ϊ��״����һ���ӿڡ�
//	Shape.java
public interface Shape {
   void draw();
}
//2
//����ʵ�ֽӿڵ�ʵ���ࡣ
//	Rectangle.java
public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}

//	Square.java
public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}

//	Circle.java
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Circle::draw() method.");
   }
}

//3
//Ϊ��ɫ����һ���ӿڡ�
//	Color.java
public interface Color {
   void fill();
}

//4
//����ʵ�ֽӿڵ�ʵ���ࡣ
//	Red.java
public class Red implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}

//	Green.java
public class Green implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}

//	Blue.java
public class Blue implements Color {

   @Override
   public void fill() {
      System.out.println("Inside Blue::fill() method.");
   }
}

//5
//Ϊ Color �� Shape ���󴴽�����������ȡ������
//	AbstractFactory.java
public abstract class AbstractFactory {
   abstract Color getColor(String color);
   abstract Shape getShape(String shape) ;
}

//6
//������չ�� AbstractFactory �Ĺ����࣬���ڸ�������Ϣ����ʵ����Ķ���
//	ShapeFactory.java
public class ShapeFactory extends AbstractFactory {
	
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }		
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
   
   @Override
   Color getColor(String color) {
      return null;
   }
}

//	ColorFactory.java
public class ColorFactory extends AbstractFactory {
	
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   Color getColor(String color) {
      if(color == null){
         return null;
      }		
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      } else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      } else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      return null;
   }
}

//7
//����һ������������/�������࣬ͨ��������״����ɫ��Ϣ����ȡ������
//	FactoryProducer.java
public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}

//8
//ʹ�� FactoryProducer ����ȡ AbstractFactory��ͨ������������Ϣ����ȡʵ����Ķ���
//	AbstractFactoryPatternDemo.java
public class AbstractFactoryPatternDemo {
   public static void main(String[] args) {

      //��ȡ��״����
      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

      //��ȡ��״Ϊ Circle �Ķ���
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //���� Circle �� draw ����
      shape1.draw();

      //��ȡ��״Ϊ Rectangle �Ķ���
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //���� Rectangle �� draw ����
      shape2.draw();
      
      //��ȡ��״Ϊ Square �Ķ���
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //���� Square �� draw ����
      shape3.draw();

      //��ȡ��ɫ����
      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

      //��ȡ��ɫΪ Red �Ķ���
      Color color1 = colorFactory.getColor("RED");

      //���� Red �� fill ����
      color1.fill();

      //��ȡ��ɫΪ Green �Ķ���
      Color color2 = colorFactory.getColor("Green");

      //���� Green �� fill ����
      color2.fill();

      //��ȡ��ɫΪ Blue �Ķ���
      Color color3 = colorFactory.getColor("BLUE");

      //���� Blue �� fill ����
      color3.fill();
   }
}

//9
//��֤�����
Inside Circle::draw() method.
Inside Rectangle::draw() method.
Inside Square::draw() method.
Inside Red::fill() method.
Inside Green::fill() method.
Inside Blue::fill() method.