//���� 1
//��������ļ�¼���ࡣ
//	AbstractLogger.java
public abstract class AbstractLogger {
   public static int INFO = 1;
   public static int DEBUG = 2;
   public static int ERROR = 3;

   protected int level;

   //�������е���һ��Ԫ��
   protected AbstractLogger nextLogger;

   public void setNextLogger(AbstractLogger nextLogger){
      this.nextLogger = nextLogger;
   }

   public void logMessage(int level, String message){
      if(this.level <= level){
         write(message);
      }
      if(nextLogger !=null){
         nextLogger.logMessage(level, message);
      }
   }

   abstract protected void write(String message);
	
}
//���� 2
//������չ�˸ü�¼�����ʵ���ࡣ
//	ConsoleLogger.java
public class ConsoleLogger extends AbstractLogger {

   public ConsoleLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Standard Console::Logger: " + message);
   }
}
//	ErrorLogger.java
public class ErrorLogger extends AbstractLogger {

   public ErrorLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("Error Console::Logger: " + message);
   }
}
//	FileLogger.java
public class FileLogger extends AbstractLogger {

   public FileLogger(int level){
      this.level = level;
   }

   @Override
   protected void write(String message) {		
      System.out.println("File::Logger: " + message);
   }
}
//���� 3
//������ͬ���͵ļ�¼�����������ǲ�ͬ�Ĵ��󼶱𣬲���ÿ����¼����������һ����¼����ÿ����¼���е���һ����¼�������������һ���֡�
//	ChainPatternDemo.java
public class ChainPatternDemo {
	
   private static AbstractLogger getChainOfLoggers(){

      AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
      AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
      AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

      errorLogger.setNextLogger(fileLogger);
      fileLogger.setNextLogger(consoleLogger);

      return errorLogger;	
   }

   public static void main(String[] args) {
      AbstractLogger loggerChain = getChainOfLoggers();

      loggerChain.logMessage(AbstractLogger.INFO, 
         "This is an information.");

      loggerChain.logMessage(AbstractLogger.DEBUG, 
         "This is an debug level information.");

      loggerChain.logMessage(AbstractLogger.ERROR, 
         "This is an error information.");
   }
}
//���� 4
��֤�����
Standard Console::Logger: This is an information.
File::Logger: This is an debug level information.
Standard Console::Logger: This is an debug level information.
Error Console::Logger: This is an error information.
File::Logger: This is an error information.
Standard Console::Logger: This is an error information.