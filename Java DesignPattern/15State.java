public interface State {
	public void handle(Context context);
}


public class ConcreteStateA implements State{
	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateB());
	}
}

public class ConcreteStateB implements State {
	@Override
	public void handle(Context context) {
		context.setState(new ConcreteStateA());
	}
}

public class Context {
	private State state;
	
	public Context(State state){
		this.state=state;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		System.out.println("state: "+state.toString());
	}
	
	public void Request(){
		state.handle(this);
	}
}

public static void main(String[] args) {
	Context context=new Context(new ConcreteStateA());
		
	context.Request();
	context.Request();
	context.Request();
}