package rachni.masqueradb.backend.users.LogInTODO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class UserLoginRepository implements IUserLoginService {
    Connection connection;
    UserLoginService userLoginService;

    public UserLoginRepository(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }


}
//PENDIENTE

