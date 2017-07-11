//1
//����һ���ӿڡ�
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
//����һ�����������ɻ��ڸ�����Ϣ��ʵ����Ķ���
//	ShapeFactory.java
public class ShapeFactory {
	
   //ʹ�� getShape ������ȡ��״���͵Ķ���
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
}

//4
//ʹ�øù�����ͨ������������Ϣ����ȡʵ����Ķ���
//	FactoryPatternDemo.java
public class FactoryPatternDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //��ȡ Circle �Ķ��󣬲��������� draw ����
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //���� Circle �� draw ����
      shape1.draw();

      //��ȡ Rectangle �Ķ��󣬲��������� draw ����
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //���� Rectangle �� draw ����
      shape2.draw();

      //��ȡ Square �Ķ��󣬲��������� draw ����
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //���� Square �� draw ����
      shape3.draw();
   }
}

//5
//��֤�����
Inside Circle::draw() method.
Inside Rectangle::draw() method.
Inside Square::draw() method.