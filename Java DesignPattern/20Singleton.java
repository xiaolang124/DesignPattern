//饿汉式
public class Singleton{
	private static Singleton instance=new Singleton();

	private Singleton(){

	}
	
	public static Singleton getInstance(){
		return instance;
	}
}


//懒汉式
public class Singleton {
	private static Singleton instance;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance(){
		if(instance==null){
			synchronized(Singleton.class){
				instance=new Singleton();
			}
		}
		
		return instance;
	}
}
/*
第一，饿汉式在加载类是就加载啦对象，懒汉式在加载类时对象为空，需要时加载。但是一般用到此方法是都是有对象的。
第二，懒汉式存在安全隐患，当多线程同时访问调用该类是会出现多个对象的可能，需要加入关键字synchronized(保证同时）,但是加入此关键字会使程序调用变慢。
*/
public static void main(String[] args) {
	Singleton s1=Singleton.getInstance();
	Singleton s2=Singleton.getInstance();
		
	if(s1==s2){
		System.out.println("---");
	}
}