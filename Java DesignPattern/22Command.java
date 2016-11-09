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
	private List<Command> orders=new ArrayList<>();
	
	public void setOrder(Command command){
		if(command instanceof BakeChickenWingCommand){
			System.out.println("服务员:没有鸡翅了");
		}else{
			orders.add(command);
			System.out.println("增加订单，时间："+new Date());
		}
	}
	
	public void cancelOrder(Command command){
		orders.remove(command);
		System.out.println("取消订单，时间："+new Date());
	}
	
	public void execute(){
		for(Command c:orders){
			c.executeCommand();
		}
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
	}
}