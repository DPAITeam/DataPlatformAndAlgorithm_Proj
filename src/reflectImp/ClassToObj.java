package reflectImp;

public class ClassToObj 
{
	String className;
	public ClassToObj(String className)
	{
		this.className = className;
	}
	public Object Product2Obj() throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		Class<?> clazz = Class.forName(this.className);
		Object obj = clazz.newInstance();
		return obj;
	}
}
