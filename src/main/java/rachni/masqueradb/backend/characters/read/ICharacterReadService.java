package rachni.masqueradb.backend.characters.read;

import rachni.masqueradb.backend.characters.CharacterEntity;

public interface ICharacterReadService {
    CharacterEntity findCharacter(int id) throws Exception;
}
