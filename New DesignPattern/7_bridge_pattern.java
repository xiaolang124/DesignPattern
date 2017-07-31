//���� 1
//�����Ž�ʵ�ֽӿڡ�
//	DrawAPI.java
public interface DrawAPI {
   public void drawCircle(int radius, int x, int y);
}
//���� 2
//����ʵ���� DrawAPI �ӿڵ�ʵ���Ž�ʵ���ࡣ
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
//���� 3
//ʹ�� DrawAPI �ӿڴ��������� Shape��
//	Shape.java
public abstract class Shape {
   protected DrawAPI drawAPI;
   protected Shape(DrawAPI drawAPI){
      this.drawAPI = drawAPI;
   }
   public abstract void draw();	
}
//���� 4
//����ʵ���� Shape �ӿڵ�ʵ���ࡣ
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
//���� 5
//ʹ�� Shape �� DrawAPI �໭����ͬ��ɫ��Բ��
//	BridgePatternDemo.java
public class BridgePatternDemo {
   public static void main(String[] args) {
      Shape redCircle = new Circle(100,100, 10, new RedCircle());
      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());

      redCircle.draw();
      greenCircle.draw();
   }
}
//���� 6
��֤�����
Drawing Circle[ color: red, radius: 10, x: 100, 100]
Drawing Circle[  color: green, radius: 10, x: 100, 100]