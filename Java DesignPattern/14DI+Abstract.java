//大话设计模式，C#例子

using System.Reflection;

public class DataAccess{
    private static readonly string AssemblyName="抽象工厂模式";
    private static readonly string db="Sqlserver";

    public static IUser CreateUser(){
        string className=AssemblyName+"."+db+"User";
        return (IUser)Assembly.Load(AssemblyName).CreateInstance(className);
    }

    public static IDepartment CreateDepartment(){
        string className=AssemblyName+"."+db+"Department";
        return (IDepartment)Assembly.Load(AssemblyName).CreateInstance(className);
    }
}

<?xml version="1.0" encoding="utf-8" ?>
<configuration>
    <appSettings>
        <add key="DB" value="Sqlserver"/>
    </appSettings>
<?configuration>

//读配置文件
private static readonly string db=configurationManager.appSettings["DB"];