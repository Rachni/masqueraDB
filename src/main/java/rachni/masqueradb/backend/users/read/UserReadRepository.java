package rachni.masqueradb.backend.users.read;

import rachni.masqueradb.backend.users.UserEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserReadRepository {
    Connection connection;

    public UserReadRepository(Connection connection) {
        this.connection = connection;
    }

    public UserEntity findUser(int id) throws Exception {
        String query = "SELECT name, email, password FROM users WHERE id = ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new Exception("User with ID " + id + " not found.");
                }
                return new UserEntity(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        }
    } //todo: not show pass.
}
