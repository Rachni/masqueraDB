package rachni.masqueradb.backend.chronicles.read;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public class ChronicleReadService implements IChronicleReadService {
    private ChronicleReadRepository chronicleReadRepository;

    public ChronicleReadService(ChronicleReadRepository chronicleReadRepository) {
        this.chronicleReadRepository = chronicleReadRepository;
    }

    @Override
    public ChronicleEntity findChronicleByID(int id) throws Exception {
        if (id < 1) {
            throw new Exception("ID can't be 0 or less.");
        }
        return this.chronicleReadRepository.findChronicleByID(id);
    }

    @Override
    public int findChronicleByName(String name) throws Exception {
        return this.chronicleReadRepository.findChronicleByName(name);
    }
}
