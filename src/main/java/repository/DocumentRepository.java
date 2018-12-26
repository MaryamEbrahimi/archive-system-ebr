package repository;

import model.Document;

import java.util.List;
import java.util.Set;

/**
 * @author Maryam Ebrahimi
 */
public interface DocumentRepository {
    void saveDocument(Document document);

    String loadByUniqueIdentifier(String UniqueIdentifier);

    List<Document> loadByTag(Document tag);

    List<Document> loadByTags(Set tags);

    void deleteByUniqueIdentifier (String uniqueIdentifier);
}
