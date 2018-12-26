package service;

import java.util.List;
import java.util.Set;

/**
 * @author Maryam Ebrahimi
 */
public interface TagService {
    void addTags (Set tags);
    List loadTags (Set tags);
    void updateTags (Set tags);
    void deleteTags (Set tags);
}
