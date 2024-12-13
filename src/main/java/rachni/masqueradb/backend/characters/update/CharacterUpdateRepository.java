package rachni.masqueradb.backend.characters.update;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import rachni.masqueradb.backend.characters.CharacterEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CharacterUpdateRepository {
    Connection connection;

    public CharacterUpdateRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean characterUpdate(CharacterEntity characterEntity) throws SQLException {
        String query = "UPDATE characters set name=?, description=?, sire =?, predator=?, clan=?, concept=?, ambition=?, desire=?, generation=? where id=?;";
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(query)) {
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
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
