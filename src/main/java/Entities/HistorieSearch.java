package Entities;

import java.util.Date;
import java.util.Objects;

public class HistorieSearch {


    private Integer id;
    private String title;
    private String url;
    private String tag;
    private Boolean isread;
    private Date date;
    private String notes;

     HistorieSearch(Integer id, String title, String url, String tag, Boolean isread, Date date, String notes) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.tag = tag;
        this.isread = isread;
        this.date = date;
        this.notes = notes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setIsread(Boolean isread) {
        this.isread = isread;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorieSearch that = (HistorieSearch) o;
        return Objects.equals(title, that.title) && Objects.equals(url, that.url) && Objects.equals(tag, that.tag) && Objects.equals(isread, that.isread) && Objects.equals(date, that.date) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url, tag, isread, date, notes);
    }
}
