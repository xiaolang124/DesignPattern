
public abstract class Handler {
	protected Handler successor;
	
	public void setSuccessor(Handler successor){
		this.successor=successor;
	}
	
	public abstract void handleRequest(int request);
}

public class ConcreteHandler1 extends Handler{

	@Override
	public void handleRequest(int request) {
		if(request>=0&&request<10){
			System.out.println(this.getClass()+" "+request);
		}else if(successor!=null){
			successor.handleRequest(request);
		}
	}
}

public class ConcreteHandler2 extends Handler{
	
	@Override
	public void handleRequest(int request) {
		if(request>=10&&request<20){
			System.out.println(this.getClass()+" "+request);
		}else if(successor!=null){
			successor.handleRequest(request);
		}
	}
}

public class Test {

	public static void main(String[] args) {
		Handler h1=new ConcreteHandler1();
		Handler h2=new ConcreteHandler2();
		h1.setSuccessor(h2);
		
		int[] requests={2,12};
		
		for(int request:requests){
			h1.handleRequest(request);
		}
	}
}