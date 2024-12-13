package rachni.masqueradb.backend.characters.create;

import rachni.masqueradb.backend.characters.CharacterEntity;

import java.sql.*;

public class CharacterCreateRepository {
    private Connection connection;

    public CharacterCreateRepository(Connection connection) {
        this.connection = connection;
    }

    public int createCharacter(CharacterEntity characterEntity) throws SQLException {
        String query = "insert into characters(name, description, sire, predator, clan, concept, ambition, desire, generation, chronicle_id) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, characterEntity.getName());
            preparedStatement.setString(2, characterEntity.getDescription());
            preparedStatement.setString(3, characterEntity.getSire());
            preparedStatement.setString(4, characterEntity.getPredator());
            preparedStatement.setString(5, characterEntity.getClan());
            preparedStatement.setString(6, characterEntity.getConcept());
            preparedStatement.setString(7, characterEntity.getAmbition());
            preparedStatement.setString(8, characterEntity.getDesire());
            preparedStatement.setString(9, characterEntity.getGeneration());
            preparedStatement.setInt(10, characterEntity.getChronicleID());
            preparedStatement.executeUpdate();
            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                resultSet.next();
                return resultSet.getInt(1);
            }
        }
    }
}
