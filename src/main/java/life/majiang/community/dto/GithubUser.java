package life.majiang.community.dto;

public class GithubUser {
    private String name;
    private  long id;
    private  String bio;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }

    public GithubUser(String name, long id, String bio) {
        this.name = name;
        this.id = id;
        this.bio = bio;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
