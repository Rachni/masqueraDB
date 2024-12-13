package rachni.masqueradb.backend.users.update;

import rachni.masqueradb.backend.users.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserUpdateRepository {
    Connection connection;

    public UserUpdateRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean userUpdate(UserEntity userEntity) throws Exception {
        String query = "update users set name= ?, password= ?, email= ? where id= ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, userEntity.getUsername());
            preparedStatement.setString(2, userEntity.getPassword());
            preparedStatement.setString(3, userEntity.getEmail());
            preparedStatement.setInt(4, userEntity.getID());
            return preparedStatement.executeUpdate() > 0;
        }
    }
    public boolean userExists(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE name = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean emailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
