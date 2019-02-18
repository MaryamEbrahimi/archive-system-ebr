package repository;

import model.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Maryam Ebrahimi
 */
public class InMemoryDocumentRepository implements DocumentRepository {

    private List<Document> documentList = new ArrayList<>();

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }


    @Override
    public void saveDocument(Document document) {
        Date currentDate = new Date();
        document.setDate(currentDate);
        documentList.add(document);

    }

    @Override
    public String loadByUniqueIdentifier(String UniqueIdentifier) {
        return null;
    }

    @Override
    public List<Document> loadByTag(Document tag) {
        return null;
    }

    @Override
    public List<Document> loadByTags(Set tags) {
        return null;
    }

    @Override
    public void deleteByUniqueIdentifier(String uniqueIdentifier) {
    }

}
