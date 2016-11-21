public abstract class Flyweight {
	public abstract void operation(int extrinsicstate);
}

public class ConcreteFlyweight extends Flyweight{

	@Override
	public void operation(int extrinsicstate) {
		System.out.println("具体Flyweight:"+extrinsicstate);
	}
}

public class UnsharedConcreteFlyweight extends Flyweight{

	@Override
	public void operation(int extrinsicstate) {
		System.out.println("不共享的Flyweight:"+extrinsicstate);
	}
}

public class FlyweightFactory {
	private Hashtable<String, Flyweight> flyweights=new Hashtable<>();
	
	public FlyweightFactory(){
		flyweights.put("X", new ConcreteFlyweight());
		flyweights.put("Y", new ConcreteFlyweight());
		flyweights.put("Z", new ConcreteFlyweight());
	}
	
	public Flyweight getFlyweight(String key){
		return (Flyweight)flyweights.get(key);
	}
}

public class Test {

	public static void main(String[] args) {
		int extrinsicstate=22;
		
		FlyweightFactory factory=new FlyweightFactory();
		
		Flyweight fx=factory.getFlyweight("X");
		fx.operation(--extrinsicstate);
	}
}
