public class YoungestEldestWorkers {
    private String youngest;
    private String name;
    private String birthday;

    public YoungestEldestWorkers(String youngest, String name, String birthday) {
        this.youngest = youngest;
        this.name = name;
        this.birthday = birthday;
    }

    public String getYoungest() {
        return youngest;
    }

    public void setYoungest(String youngest) {
        this.youngest = youngest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "-------------> " +
                "youngest= '" + youngest + '\'' +
                ", name= '" + name + '\'' +
                ", birthday= '" + birthday + '\'';
    }
}
