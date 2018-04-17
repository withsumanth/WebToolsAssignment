import java.util.HashSet;
import java.util.Set;


import com.me.dao.UserDAO;
import com.me.exception.UserException;
import com.me.pojo.User;

public class TestMain {

	public static void main(String[] args) throws UserException {
		
		UserDAO ud = new UserDAO();
		User u = ud.get(1);
		
		
		System.out.println("Finished Testing...");

	}

}
