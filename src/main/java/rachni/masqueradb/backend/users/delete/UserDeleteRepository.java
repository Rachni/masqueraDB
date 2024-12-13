package rachni.masqueradb.backend.users.delete;

import rachni.masqueradb.backend.users.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteRepository {
    Connection connection;

    public UserDeleteRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean userDelete(int id) throws SQLException {
        String query = "DELETE FROM users where id = ? limit 1;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
