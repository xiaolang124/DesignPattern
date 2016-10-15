public class Prototype implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() {
        try { 
            return super.clone();
        } catch (CloneNotSupportedException e) {   
            e.printStackTrace();
            return null;
        }
    }    
}

public class NewPrototype implements Cloneable {
 
    private String id;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Prototype prototype;
    
    public Prototype getPrototype() {
        return prototype;
    }

    public void setPrototype(Prototype prototype) {
        this.prototype = prototype;
    }


    public Object clone(){
        NewPrototype ret = null;
        try {
            ret = (NewPrototype)super.clone();
            ret.prototype = (Prototype)this.prototype.clone();
            return ret;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }  
    }
}
public class TestMain {

    public static void main(String[] args) {
        testDeepCopy();
    }
    
    private static void testDeepCopy(){
        Prototype pro = new Prototype();
        pro.setName("original object");
        NewPrototype newObj = new NewPrototype();
        newObj.setId("test1");
        newObj.setPrototype(pro);
        
        NewPrototype copyObj = (NewPrototype)newObj.clone();
        copyObj.setId("testCopy");
        copyObj.getPrototype().setName("changed object");
        
        System.out.println("original object id:" + newObj.getId());
        System.out.println("original object name:" + newObj.getPrototype().getName());
        
        System.out.println("cloned object id:" + copyObj.getId());
        System.out.println("cloned object name:" + copyObj.getPrototype().getName());
        
    }

}

结果:
original object id:test1
original object name:original object
cloned object id:testCopy
cloned object name:changed object



public class PrototypeSe implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

public class NewPrototypeSe implements Serializable {
 
    private String id;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private PrototypeSe prototype;
    
    public PrototypeSe getPrototype() {
        return prototype;
    }

    public void setPrototype(PrototypeSe prototype) {
        this.prototype = prototype;
    }
    
    public Object deepClone(){
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);   
            oo.writeObject(this);   
            
            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            return oi.readObject(); 
        } catch (IOException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

}

public class TestDeepClone {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PrototypeSe po = new PrototypeSe();
        po.setName("test1");
        NewPrototypeSe se = new NewPrototypeSe();
        se.setPrototype(po);
        
        NewPrototypeSe deepClone = (NewPrototypeSe)se.deepClone();
        deepClone.getPrototype().setName("test2");
        
        System.out.println("original name:" + se.getPrototype().getName());
        System.out.println("cloned name:" + deepClone.getPrototype().getName());

    }
}

结果:
original name:test1
cloned name:test2