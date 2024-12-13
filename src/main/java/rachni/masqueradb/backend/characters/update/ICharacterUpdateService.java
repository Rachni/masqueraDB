package rachni.masqueradb.backend.characters.update;

import rachni.masqueradb.backend.characters.CharacterEntity;

public interface ICharacterUpdateService {
   public boolean characterUpdate(CharacterEntity characterEntity) throws Exception;
}
