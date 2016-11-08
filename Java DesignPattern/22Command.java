public class Barbecuer {
	public void bakeMutton(){
		System.out.println("烤羊肉串");
	}
	
	public void bakeChickenWing(){
		System.out.println("烤鸡翅");
	}
}

public abstract class Command {
	protected Barbecuer receiver;
	
	public Command(Barbecuer barbecuer){
		this.receiver=barbecuer;
	}
	
	public abstract void executeCommand();
}

public class BakeChickenWingCommand extends Command{

	public BakeChickenWingCommand(Barbecuer barbecuer) {
		super(barbecuer);
	}

	@Override
	public void executeCommand() {
		receiver.bakeChickenWing();
	}
}

public class BakeMuttonCommand extends Command{

	public BakeMuttonCommand(Barbecuer barbecuer) {
		super(barbecuer);
	}

	@Override
	public void executeCommand() {
		receiver.bakeMutton();
	}
}

public class Waiter {
	private Command command;
	
	public void setOrder(Command command){
		this.command=command;
	}
	
	public void execute(){
		command.executeCommand();
	}
}

public class Test {

	public static void main(String[] args) {
		Barbecuer boy=new Barbecuer();
		
		Command bakeMuttonCommand1=new BakeMuttonCommand(boy);
		Command bakeChickenCommand1=new BakeChickenWingCommand(boy);
		
		Waiter girl=new Waiter();
		
		girl.setOrder(bakeMuttonCommand1);
		girl.execute();
		girl.setOrder(bakeChickenCommand1);;
		girl.execute();
	}
}