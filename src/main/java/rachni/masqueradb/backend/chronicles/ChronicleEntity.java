package rachni.masqueradb.backend.chronicles;

public class ChronicleEntity {
    private int id;
    private String name;

    public ChronicleEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChronicleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
