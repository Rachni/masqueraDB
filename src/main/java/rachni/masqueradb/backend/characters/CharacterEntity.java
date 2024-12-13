package rachni.masqueradb.backend.characters;

import rachni.masqueradb.backend.chronicles.ChronicleEntity;

public class CharacterEntity {
    private int id;
    private String name;
    private String description;
    private String sire;
    private String predator;
    private String clan;
    private String concept;
    private String ambition;
    private String desire;
    private String generation;

    //    private int inventory_id;
    private ChronicleEntity chronicle;
    private int chronicle_id;


    public CharacterEntity(String name, String description, String sire, String predator, String clan, String concept, String ambition, String desire, String generation, int chronicle_id) {
        this.name = name;
        this.description = description;
        this.sire = sire;
        this.predator = predator;
        this.clan = clan;
        this.concept = concept;
        this.ambition = ambition;
        this.desire = desire;
        this.generation = generation;
        this.chronicle_id = chronicle_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getSire() {
        return sire;
    }

    public String getPredator() {
        return predator;
    }

    public String getClan() {
        return clan;
    }

    public String getConcept() {
        return concept;
    }

    public String getAmbition() {
        return ambition;
    }

    public String getDesire() {
        return desire;
    }

    public String getGeneration() {
        return generation;
    }

    public int getChronicleID() {
        return chronicle != null ? chronicle.getId() : 0;
    }

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sire='" + sire + '\'' +
                ", predator='" + predator + '\'' +
                ", clan='" + clan + '\'' +
                ", concept='" + concept + '\'' +
                ", ambition='" + ambition + '\'' +
                ", desire='" + desire + '\'' +
                ", generation='" + generation + '\'' +
                ", chronicle=" + chronicle +
                ", chronicle_id=" + chronicle_id +
                '}';
    }
}
