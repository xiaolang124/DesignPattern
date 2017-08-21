//步骤 1
//创建一个接口。
//	Shape.java
public interface Shape {
   void draw();
}
//步骤 2
//创建实现接口的实体类。
//	Rectangle.java
public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Rectangle::draw()");
   }
}
//	Square.java
public class Square implements Shape {

   @Override
   public void draw() {
      System.out.println("Square::draw()");
   }
}
//	Circle.java
public class Circle implements Shape {

   @Override
   public void draw() {
      System.out.println("Circle::draw()");
   }
}
//步骤 3
//创建一个外观类。
//	ShapeMaker.java
public class ShapeMaker {
   private Shape circle;
   private Shape rectangle;
   private Shape square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }

   public void drawCircle(){
      circle.draw();
   }
   public void drawRectangle(){
      rectangle.draw();
   }
   public void drawSquare(){
      square.draw();
   }
}
//步骤 4
//使用该外观类画出各种类型的形状。
//	FacadePatternDemo.java
public class FacadePatternDemo {
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();		
   }
}
//步骤 5
验证输出。
Circle::draw()
Rectangle::draw()
Square::draw()