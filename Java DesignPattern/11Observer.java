public abstract class Subject{
    private List<Observer> list=new LinkedList<Observer>();

    public void attach(Observer observer){
        list.add(observer);
    }

    public vodi detach(Observer observer){
        list.remove(observer);
    }

    public void notifyObservers(String newState){
        for(Observer observer:list){
            observer.update(newState);
        }
    }
}

public class ConcreteSubject extends Subject{
    private String state;

    public String getState(){
        return state;
    }

    public void change(String newState){
        state=newState;
        this.notifyObservers(state);
    }
}

public interface Observer{
    public void update(String state);
}

pulblic class ConcreteObserver implements Observer{
    private String observerstate;

    @Override
    public void update(String state){
        observer=state;
        //
    }
}

public static void main(String args){
    ConcreteSubject subject=new ConcreteSubject();
    Observer observer=new ConcreteObserver();
    subject.attach(observer);
    subject.change("new state");
}