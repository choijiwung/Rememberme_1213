package rememberme.io.rememberme.Trip;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by JW on 2017-12-10.
 */

@SuppressWarnings("serial")
public class Trip implements Serializable {

    private int thumb;
    private int id;
    private String title;
    private String description;
    private String region;
    private Date start;
    private Date end;

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
