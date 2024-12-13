package rachni.masqueradb.backend.characters.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CharacterDeleteRepository {
    Connection connection;

    public CharacterDeleteRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean deleteCharacter(int id) throws SQLException {
        String query = "DELETE from characters where id = ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
