package rachni.masqueradb.backend.chronicles.read;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChronicleReadRepository {
    private Connection connection;

    public ChronicleReadRepository(Connection connection) {
        this.connection = connection;
    }

    public ChronicleEntity findChronicleByID(int id) throws Exception {
        String query = "SELECT name FROM chronicles WHERE id = ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new Exception("Chronicle with ID " + id + "not found.");
                }
                return new ChronicleEntity(id, resultSet.getString(1));
            }
        }
    }

    public int findChronicleByName(String name) throws Exception {
        String query = "Select id FROM chronicles WHERE name = ?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new Exception("Chronicle with name " + name + "not found.");
                }
                return resultSet.getInt(1);
            }
        }
    }
}