package springaop04_javaDynamicProxy;

public class UserDAO implements IDAO{

	@Override
	public String select(String username) {
		return "Ŀ����UserDAO.select() "+username;
	}

}
