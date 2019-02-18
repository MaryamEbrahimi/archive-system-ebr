package model;

import service.InvalidTagsNumberException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Maryam Ebrahimi
 */
public class Document {
    private String uniqueIdentifier;
    private String name;
    private String type;
    private Date date;
    private String createdBy;
    private List<Document> attachments = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    Document(String createdBy){
     this.createdBy = createdBy;
    }

    public Document() {
        this.uniqueIdentifier = UUID.randomUUID().toString();
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<Document> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Document> attachments) {

        this.attachments = attachments;
    }

    public List<String> getTags() {
        return tags;
    }

    public void addToTags(String tags) {
        char[] chars = tags.toCharArray();
        if (chars.length > 15) {
            throw new InvalidTagsNumberException();
        }
        for (int i = 0; i < chars.length; i++) {
            if (!('a' <= chars[i] || chars[i] <= 'z') || !('A' <= chars[i] || chars[i] <= 'Z') ||
                    !('0' <= chars[i] || chars[i] <= '9')) {
                throw new InvalidTagsNumberException();
            }
        }
    }
}
