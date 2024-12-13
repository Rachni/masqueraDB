package rachni.masqueradb.backend.chronicles.delete;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public interface IChronicleDeleteService {
    boolean chronicleDelete(int id) throws Exception;
}
