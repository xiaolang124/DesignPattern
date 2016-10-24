public class User{
    private int id;
    private String name;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setId(String name){
        this.name=name;
    }
}

public interface IUser{
    public void insert(User user);
    
    public User getUser(int id);
}

public class SqlServerUser implements IUser{
    public void insert(User user){
        //
    }

    public User getUser(int id){
        //
        return null;
    }
}

public class AccessUser implements IUser{
    public void insert(User user){
        System.out.println("向Access插入User");
    }

    public User getUser(int id){
        //
        return null;
    }
}

public class Department{
    private int id;
    private String name;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setId(String name){
        this.name=name;
    }
}

public interface IDepartment{
    public void insert(Department department);

    public Department getDepartment(int id);
}

public class SqlServerDepartment implements IDepartment{
    public void insert(Department department){
        //
    }

    public Department getDepartment(int id){
        //
        return null;
    }
}

public class AccessDepartment implements IDepartment{
        public void insert(Department department){
            System.out.println("向Access插入Apartment");
        }

        public Department getDepartment(int id){
            //
            return null;
        }
}

public interface IFacotry{
    public IUser createUser();
    public IDepartment createDepartment();
}

public SqlServerFactory implements IFacotry{
    public IUser createUser(){
        return new SqlServerUser();
    }

    public IDepartment createDepartment(){
        return new SqlServerDepartment();
    }
}

public AccessFactory implements IFacotry{
    public IUser createUser(){
        return new AccessUser();
    }

    public IDepartment createDepartment(){
        return new AccessDepartment();
    }
}

static void Main(String[] args){
    User user=new User();
    Department dept=new Department();

    IFactory factory=new AccessFactory();
    IUser iu=factory.createUser();

    iu.insert(user);
    iu.getUser(1);

    IDepartment id=factory.createDepartment();
    id.insert(dept);
    id.getDepartment(1);
}

