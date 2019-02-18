package service;

import model.Document;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Maryam Ebrahimi
 */
public interface DocumentService {
    Document loadByUniqueIdentifier(String uniqueIdentifier);

    Document loadByName(String name);

    Document loadByNameAndType (String name, String type);

    public List<Document> loadByDateRange(Date date1, Date date2);

    List<Document> loadByTag(String tag);

    List<Document> loadByTags(Set<String> tags);

    void save(Document document);

    void update(Document document);

    void deleteByTags(Set<String> tags);

    void deleteByUniqueIdentifier(Document document);
}
