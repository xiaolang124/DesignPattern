public abstract class Iterator {
	public abstract Object first();
	public abstract Object next();
	public abstract boolean isDone();
	public abstract Object currentItem();
}

public abstract class Aggregate {
	public abstract Iterator createIterator();
}

public class ConcreteIterator extends Iterator{
	private ConcreteAggregate aggregate;
	private int current=0;
	
	public ConcreteIterator(ConcreteAggregate aggregate){
		this.aggregate=aggregate;
	}

	@Override
	public Object first() {
		return aggregate.getIndex(0);
	}

	@Override
	public Object next() {
		Object ret=null;
		++current;
		if(current<aggregate.getCount()){
			ret=aggregate.getIndex(current);
		}
		return ret;
	}

	@Override
	public boolean isDone() {
		return current>=aggregate.getCount()?true:false;
	}

	@Override
	public Object currentItem() {
		return aggregate.getIndex(current);
	}
}

public class ConcreteAggregate extends Aggregate{
	private List<Object> items=new ArrayList<Object>();

	@Override
	public Iterator createIterator() {
		return new ConcreteIterator(this);
	}
	
	public int getCount(){
		return items.size();
	}
	
	public Object getIndex(int index){
		return items.get(index);
	}
	
	public void insertIndex(int index,Object value){
		items.add(index,value);
	}
}

public class Test {

	public static void main(String[] args) {
		ConcreteAggregate aggregate=new ConcreteAggregate();
		
		int count=0;
		aggregate.insertIndex(count++, "1");
		aggregate.insertIndex(count++, "2");
		aggregate.insertIndex(count++, "3");
		
		Iterator iterator=new ConcreteIterator(aggregate);
		
		Object item=iterator.first();
		while(!iterator.isDone()){
			System.out.println(iterator.currentItem());
			iterator.next();
		}
	}
}

1
2
3
