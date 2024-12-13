package rachni.masqueradb.backend.characters.read;

import rachni.masqueradb.backend.characters.CharacterEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CharacterReadRepository {
    Connection connection;

    public CharacterReadRepository(Connection connection) {
        this.connection = connection;
    }

    public CharacterEntity findCharacter(int id) throws Exception {
        String query = "select name, description, sire, predator, clan, concept, ambition, desire, generation, chronicle_id FROM characters where id = ? ;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.next()) {
                    throw new Exception("Character with ID" + id + "not found.");
                }
                return new CharacterEntity(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getInt(10));
            }
        }
    }
}
