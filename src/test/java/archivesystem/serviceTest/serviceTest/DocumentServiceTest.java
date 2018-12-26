package archivesystem.serviceTest.serviceTest;

import service.impl.DocumentServiceImpl;
import model.Document;
import service.DocumentService;
import service.InvalidLetterException;
import service.InvalidTagsNumberException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Maryam Ebrahimi
 */
public class DocumentServiceTest {
    //1. making an instance variable
    private DocumentService documentService = new DocumentServiceImpl();

    //2.adding test method: public , void, throws exception, without parameters
    //3. write @Test above the methods
    //4. call the target method with , keep the method output in a variable
    //5. compare ( assert) the output with the expected result
    @Test
    public void createDocumentWithUniqueIdentifier() throws Exception {
        Document document = new Document();
        Assert.assertNotNull(document.getUniqueIdentifier());
    }

    @Test
    public void updateDocumentByName() throws Exception {
        Document result = documentService.loadByName("PDF");
        result.setName("PDF1");
        documentService.update(result);
        Document updatedResult = documentService.loadByName("PDF1");
        Assert.assertNotNull(updatedResult);
        Assert.assertEquals("PDF1", result.getName());
    }

    @Test
    public void deleteDocumentByUniqueIdentifier() throws Exception {
        Document result = documentService.loadByUniqueIdentifier("pdf");
        documentService.deleteByUniqueIdentifier(result);
        Document deletedDocument = documentService.loadByUniqueIdentifier("pdf");
        Assert.assertNull(deletedDocument);
    }

    @Test
    public void loadDocumentByTag() throws Exception {
        Document document1 = new Document();
        document1.setName("pdf");
        documentService.save(document1);
        Document document2 = new Document();
        document2.setName("office");
        documentService.save(document2);
        Document document3 = new Document();
        document3.setName("word");
        documentService.save(document3);
        List<Document> document = documentService.loadByTag("office");
        Assert.assertNotNull(document);
        Assert.assertFalse(document.isEmpty());
        Assert.assertEquals(1, document.size());
        Assert.assertEquals("office", document.get(0).getTags().get(0));
    }

    @Test
    public void loadDocumentByTags() throws Exception {
        Document document1 = new Document();
        document1.setName("office");
        documentService.save(document1);
        Document document2 = new Document();
        document2.setName("excel");
        documentService.save(document2);
        Document document3 = new Document();
        document3.setName("word");
        documentService.save(document3);
        Set tags = new HashSet();
        tags.add("word");
        tags.add("office");
        List<Document> documents = documentService.loadByTags(tags);
        Assert.assertNotNull(documents);
        Assert.assertFalse(documents.isEmpty());
        Assert.assertEquals(2, documents.size());

        List documentTags = new ArrayList();
        for (int i = 0; i < documents.size(); i++) {
            documentTags.add(documents.get(i).getTags().get(0));
        }
        Assert.assertTrue(documentTags.contains("office"));
        Assert.assertTrue(documentTags.contains("word"));
        Assert.assertFalse(documentTags.contains("excel"));
    }

    @Test (expected = InvalidLetterException.class)
    public void saveDocumentWithInvalidLetter(){
        Document document = new Document();
        document.setName("word");
    }
    @Test (expected = InvalidTagsNumberException.class)
    public void saveDocumentMoreThanValidLetter(){
        Document document = new Document();
        for (int i = 0 ; i <16; i++){
            document.setName("tag" + i);
        }
    }
}
