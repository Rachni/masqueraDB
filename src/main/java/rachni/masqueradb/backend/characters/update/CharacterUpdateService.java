package rachni.masqueradb.backend.characters.update;

import rachni.masqueradb.backend.characters.CharacterEntity;

public class CharacterUpdateService implements ICharacterUpdateService{
    CharacterUpdateRepository characterUpdateRepository;

    public CharacterUpdateService(CharacterUpdateRepository characterUpdateRepository) {
        this.characterUpdateRepository = characterUpdateRepository;
    }

    @Override
    public boolean characterUpdate(CharacterEntity characterEntity) throws Exception {
        if (characterEntity == null) {
            throw new Exception("Character can't be null.");
        }
        if (characterEntity.getName() == null || characterEntity.getName().isBlank()) {
            throw new Exception("Name field can't be empty.");
        }
        return this.characterUpdateRepository.characterUpdate(characterEntity);
    }
}
