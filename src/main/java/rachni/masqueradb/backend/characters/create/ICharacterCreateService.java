package rachni.masqueradb.backend.characters.create;

import rachni.masqueradb.backend.characters.CharacterEntity;

import java.sql.SQLException;

public interface ICharacterCreateService {
    public int createCharacter(CharacterEntity characterEntity) throws SQLException, Exception;
}
