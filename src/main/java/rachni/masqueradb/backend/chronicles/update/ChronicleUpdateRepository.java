package rachni.masqueradb.backend.chronicles.update;

import rachni.masqueradb.backend.characters.CharacterEntity;
import rachni.masqueradb.backend.chronicles.ChronicleEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChronicleUpdateRepository {
    Connection connection;

    public ChronicleUpdateRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean chronicleUpdate(ChronicleEntity chronicleEntity) throws SQLException {
        String query = "UPDATE chronicles set name=? where id=?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, chronicleEntity.getName());
            preparedStatement.setInt(2, chronicleEntity.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
