package rachni.masqueradb.backend.characters.delete;

public class CharacterDeleteService implements ICharacterDeleteService {
    CharacterDeleteRepository characterDeleteRepository;

    public CharacterDeleteService(CharacterDeleteRepository characterDeleteRepository) {
        this.characterDeleteRepository = characterDeleteRepository;
    }

    @Override
    public boolean deleteCharacter(int id) throws Exception {
        return this.characterDeleteRepository.deleteCharacter(id);
    }
}