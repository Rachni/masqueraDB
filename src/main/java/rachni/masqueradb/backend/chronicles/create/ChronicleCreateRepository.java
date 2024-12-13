package rachni.masqueradb.backend.chronicles.create;


import rachni.masqueradb.backend.chronicles.ChronicleEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class ChronicleCreateRepository {

    private Connection connection;

    public ChronicleCreateRepository(Connection connection) {
        this.connection = connection;
    }

    public int ChronicleCreate(ChronicleEntity chronicleEntity) throws SQLException {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement("insert into chronicles (name) values (?);", PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, chronicleEntity.getName());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
                return resultSet.getInt(1);
            }
        }
    }
}
