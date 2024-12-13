package rachni.masqueradb.backend.characters.read;

import rachni.masqueradb.backend.characters.CharacterEntity;

public class CharacterReadService implements ICharacterReadService {
    private CharacterReadRepository characterReadRepository;

    public CharacterReadService(CharacterReadRepository characterReadRepository) {
        this.characterReadRepository = characterReadRepository;
    }

    @Override
    public CharacterEntity findCharacter(int id) throws Exception {
        if (id < 1) {
            throw new Exception("ID can't be 0 or less.");
        }
        return this.characterReadRepository.findCharacter(id);
    }
}
