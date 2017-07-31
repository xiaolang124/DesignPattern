//步骤 1
//创建桥接实现接口。
//	DrawAPI.java
public interface DrawAPI {
   public void drawCircle(int radius, int x, int y);
}
//步骤 2
//创建实现了 DrawAPI 接口的实体桥接实现类。
//	RedCircle.java
public class RedCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: red, radius: "
         + radius +", x: " +x+", "+ y +"]");
   }
}
//	GreenCircle.java
public class GreenCircle implements DrawAPI {
   @Override
   public void drawCircle(int radius, int x, int y) {
      System.out.println("Drawing Circle[ color: green, radius: "
         + radius +", x: " +x+", "+ y +"]");
   }
}
//步骤 3
//使用 DrawAPI 接口创建抽象类 Shape。
//	Shape.java
public abstract class Shape {
   protected DrawAPI drawAPI;
   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }
   public abstract void draw();	
}
//步骤 4
//创建实现了 Shape 接口的实体类。
//	Circle.java
public class Circle extends Shape {
   private int x, y, radius;

   public Circle(int x, int y, int radius, DrawAPI drawAPI) {
      super(drawAPI);
      this.x = x;  
      this.y = y;  
      this.radius = radius;
   }

   public void draw() {
      drawAPI.drawCircle(radius,x,y);
   }
}
//步骤 5
//使用 Shape 和 DrawAPI 类画出不同颜色的圆。
//	BridgePatternDemo.java
public class BridgePatternDemo {
   public static void main(String[] args) {
      Shape redCircle = new Circle(100,100, 10, new RedCircle());
      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
   }
}
//步骤 6
验证输出。
Drawing Circle[ color: red, radius: 10, x: 100, 100]
Drawing Circle[  color: green, radius: 10, x: 100, 100]