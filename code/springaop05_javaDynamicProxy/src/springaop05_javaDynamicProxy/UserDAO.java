package springaop05_javaDynamicProxy;
//目标类
public class UserDAO implements IDAO{

	@Override
	public String select(String username) {
		
		return "目标类UserDAO username="+username;
	}

}
