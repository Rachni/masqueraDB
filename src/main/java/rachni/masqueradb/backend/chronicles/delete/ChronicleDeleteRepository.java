package rachni.masqueradb.backend.chronicles.delete;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChronicleDeleteRepository {
    private Connection connection;

    public ChronicleDeleteRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean chronicleDelete(int id) throws SQLException {
        String query = "DELETE FROM chronicles where id = ? limit 1";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
