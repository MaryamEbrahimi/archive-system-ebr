package service.impl;

import model.Document;
import service.DocumentService;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Maryam Ebrahimi
 */
public class DocumentServiceImpl implements DocumentService {

    public Document loadByUniqueIdentifier(String uniqueIdentifier) {
        return null;
    }

    public Document loadByName(String name) {
        return null;
    }

    @Override
    public Document loadByNameAndType(String name, String type) {
        return null;
    }

    public List<Document> loadByDateRange(Date date1, Date date2) {
        return null;
    }

    public List<Document> loadByTag(String tag) {
        return null;
    }

    public List<Document> loadByTags(Set tags) {
        return null;
    }

    public void save(Document document) {

    }

    public void update(Document document) {
    }

    public void deleteByTags(Set tags) {
    }

    public void deleteByUniqueIdentifier(Document document) {
    }
}
