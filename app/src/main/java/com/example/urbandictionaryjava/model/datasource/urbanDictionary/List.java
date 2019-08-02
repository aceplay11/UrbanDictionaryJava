
package com.example.urbandictionaryjava.model.datasource.urbanDictionary;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class List {

    @Expose
    private String author;
    @SerializedName("current_vote")
    private String currentVote;
    @Expose
    private Long defid;
    @Expose
    private String definition;
    @Expose
    private String example;
    @Expose
    private String permalink;
    @SerializedName("sound_urls")
    private java.util.List<Object> soundUrls;
    @SerializedName("thumbs_down")
    private Long thumbsDown;
    @SerializedName("thumbs_up")
    private Long thumbsUp;
    @Expose
    private String word;
    @SerializedName("written_on")
    private String writtenOn;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCurrentVote() {
        return currentVote;
    }

    public void setCurrentVote(String currentVote) {
        this.currentVote = currentVote;
    }

    public Long getDefid() {
        return defid;
    }

    public void setDefid(Long defid) {
        this.defid = defid;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public java.util.List<Object> getSoundUrls() {
        return soundUrls;
    }

    public void setSoundUrls(java.util.List<Object> soundUrls) {
        this.soundUrls = soundUrls;
    }

    public Long getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(Long thumbsDown) {
        this.thumbsDown = thumbsDown;
    }

    public Long getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(Long thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWrittenOn() {
        return writtenOn;
    }

    public void setWrittenOn(String writtenOn) {
        this.writtenOn = writtenOn;
    }

}
