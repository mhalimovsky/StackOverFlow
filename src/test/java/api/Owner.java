package api;

public class Owner {
    private Integer reputation;
    private Integer user_id;
    private String user_type;
    private String profile_image;
    private String display_name;
    private String link;

    public Integer accept_rate;

    public Owner(Integer reputation, Integer user_id, String user_type, String profile_image, String display_name, String link) {
        this.reputation = reputation;
        this.user_id = user_id;
        this.user_type = user_type;
        this.profile_image = profile_image;
        this.display_name = display_name;
        this.link = link;
    }

    public Owner() {
    }

    public Integer getReputation() {
        return reputation;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getLink() {
        return link;
    }
}
