package springaop05_javaDynamicProxy;
//Ŀ����
public class UserDAO implements IDAO{

	@Override
	public String select(String username) {
		
		return "Ŀ����UserDAO username="+username;
	}

}
