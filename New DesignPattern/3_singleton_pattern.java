//���� 1
//����һ�� Singleton �ࡣ
//	SingleObject.java
public class SingleObject {

   //���� SingleObject ��һ������
   private static SingleObject instance = new SingleObject();

   //�ù��캯��Ϊ private����������Ͳ��ᱻʵ����
   private SingleObject(){}

   //��ȡΨһ���õĶ���
   public static SingleObject getInstance(){
      return instance;
   }

   public void showMessage(){
      System.out.println("Hello World!");
   }
}

//���� 2
//�� singleton ���ȡΨһ�Ķ���
//	SingletonPatternDemo.java
public class SingletonPatternDemo {
   public static void main(String[] args) {

      //���Ϸ��Ĺ��캯��
      //����ʱ���󣺹��캯�� SingleObject() �ǲ��ɼ���
      //SingleObject object = new SingleObject();

      //��ȡΨһ���õĶ���
      SingleObject object = SingleObject.getInstance();

      //��ʾ��Ϣ
      object.showMessage();
   }
}