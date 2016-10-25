public class DataAccess{
    public static IUser createUser(String db){
        IUser result=null;
        switch(db){
            case "Sqlserver":
                result=new SqlserverUser();
                break;
            case "Access":
                result=new AccessUser();
                break;
        }   
        return result;
    }

    public static IDepartment createDepartment(String db){
        IDepartment result=null;
        switch(db){
            case "Sqlserver":
                result=new SqlserverDepartment();
                break;
            case "Access":
                result=new AccessDepartment();
                break;
        }
        return result;
    }
}

static void Main(String[] args){
    User user=new User();
    Department dept=new Department();

    IUser iu=DataAccess.createUser("Sqlserver");

    iu.insert(user);
    iu.getUser(1);
}