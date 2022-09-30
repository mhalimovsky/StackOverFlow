package api;

public class Items {
    private Owner owner;
    private Boolean is_accepted;
    private Integer score;
    private Integer last_activity_date;
    private Integer last_edit_date;
    private Integer creation_date;
    private Integer answer_id;
    private Integer question_id;
    private String content_license;

    public Items(Owner owner, Boolean is_accepted, Integer score, Integer last_activity_date, Integer last_edit_date, Integer creation_date, Integer answer_id, Integer question_id, String content_license) {
        this.owner = owner;
        this.is_accepted = is_accepted;
        this.score = score;
        this.last_activity_date = last_activity_date;
        this.last_edit_date = last_edit_date;
        this.creation_date = creation_date;
        this.answer_id = answer_id;
        this.question_id = question_id;
        this.content_license = content_license;
    }

    public Items() {
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean getIs_accepted() {
        return is_accepted;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getLast_activity_date() {
        return last_activity_date;
    }

    public Integer getLast_edit_date() {
        return last_edit_date;
    }

    public Integer getCreation_date() {
        return creation_date;
    }

    public Integer getAnswer_id() {
        return answer_id;
    }

    public Integer getQuestion_id() {
        return question_id;
    }

    public String getContent_license() {
        return content_license;
    }
}
