package rachni.masqueradb.backend.chronicles.delete;

public class ChronicleDeleteService implements IChronicleDeleteService {
    ChronicleDeleteRepository chronicleDeleteRepository;

    public ChronicleDeleteService(ChronicleDeleteRepository chronicleDeleteRepository) {
        this.chronicleDeleteRepository = chronicleDeleteRepository;
    }

    @Override
    public boolean chronicleDelete(int id) throws Exception {
        return this.chronicleDeleteRepository.chronicleDelete(id);
    }
}
