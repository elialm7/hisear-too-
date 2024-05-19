package Entities;

import java.util.Date;

public class HistorieSearchBuilder {


    private String title;
    private String url;
    private String tag;
    private Boolean isread;
    private Date date;
    private String notes;
    private Integer id;

    public HistorieSearchBuilder() {
    }

    public HistorieSearchBuilder withId(Integer id){
        this.id = id;
        return this;
    }


    public HistorieSearchBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public HistorieSearchBuilder withUrl(String url){
        this.url = url;
        return this;
    }
    public HistorieSearchBuilder withTag(String tag){
        this.tag = tag;
        return this;
    }
    public HistorieSearchBuilder withIsread(Boolean isread){
        this.isread = isread;
        return this;
    }

    public HistorieSearchBuilder withDate(Date date){
        this.date = date;
        return this;
    }

    public HistorieSearchBuilder withNotes(String notes){
        this.notes = notes;
        return this;
    }

    public HistorieSearch build(){
        return new HistorieSearch(
                this.id,
                this.title,
                this.url,
                this.tag,
                this.isread,
                this.date,
                this.notes
        );
    }


}
