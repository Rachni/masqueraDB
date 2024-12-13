package rachni.masqueradb.backend.characters.create;

import rachni.masqueradb.backend.characters.CharacterEntity;

public class CharacterCreateService implements ICharacterCreateService {
    CharacterCreateRepository characterCreateRepository;

    public CharacterCreateService(CharacterCreateRepository characterCreateRepository) {
        this.characterCreateRepository = characterCreateRepository;
    }

    @Override
    public int createCharacter(CharacterEntity characterEntity) throws Exception {
        if (characterEntity == null) {
            throw new Exception("Character can't be null");
        }
        if (characterEntity.getName() == null || characterEntity.getName().isBlank()) {
            throw new Exception("Incorrect name");
        }
        return this.characterCreateRepository.createCharacter(characterEntity);
    }
}
