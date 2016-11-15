public abstract class Mediator {
	public abstract void send(String message,Colleague colleague);
}

public abstract class Colleague {
	protected Mediator mediator;
	
	public Colleague(Mediator mediator){
		this.mediator=mediator;
	}
}

public class ConcreteMediator extends Mediator{
	private ConcreteColleague1 colleague1;
	private ConcreteColleague2 colleague2;
	
	public void setColleague1(ConcreteColleague1 colleague1) {
		this.colleague1 = colleague1;
	}
	
	public void setColleague2(ConcreteColleague2 colleague2) {
		this.colleague2 = colleague2;
	}

	@Override
	public void send(String message, Colleague colleague) {
		if(colleague==colleague1){
			colleague2.notify(message);
		}else{
			colleague1.notify(message);
		}
	}
}

public class ConcreteColleague1 extends Colleague{
	public ConcreteColleague1(Mediator mediator){
		super(mediator);
	}
	
	public void send(String message){
		mediator.send(message, this);
	}
	
	public void notify(String message){
		System.out.println("同事1得到消息:"+message);
	}
}

public class ConcreteColleague2 extends Colleague{
	public ConcreteColleague2(Mediator mediator){
		super(mediator);
	}
	
	public void send(String message){
		mediator.send(message, this);
	}
	
	public void notify(String message){
		System.out.println("同事2得到消息:"+message);
	}
}

public class Test {

	public static void main(String[] args) {
		ConcreteMediator m=new ConcreteMediator();
		ConcreteColleague1 c1=new ConcreteColleague1(m);
		ConcreteColleague2 c2=new ConcreteColleague2(m);
		
		m.setColleague1(c1);
		m.setColleague2(c2);
		
		c1.send("123");
	}
}