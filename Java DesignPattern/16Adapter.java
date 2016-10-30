public abstract class Target {
	public void request(){
		System.out.println("Request!");
	}
}

public class Adaptee {
	public void specificRequest(){
		System.out.println("Special Request!");
	}
}

public class Adapter extends Target{
	private Adaptee adaptee=new Adaptee();
	
	@Override
	public void request() {
		adaptee.specificRequest();
	}
}