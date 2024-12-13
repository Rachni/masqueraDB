package rachni.masqueradb.backend.chronicles.read;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public interface IChronicleReadService {
    ChronicleEntity findChronicleByID(int id) throws Exception;

    int findChronicleByName(String name) throws Exception;
}
