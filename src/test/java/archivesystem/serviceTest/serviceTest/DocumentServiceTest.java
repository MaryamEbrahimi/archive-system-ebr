package archivesystem.serviceTest.serviceTest;

import model.Document;
import org.junit.Assert;
import org.junit.Test;
import repository.DocumentRepository;
import repository.InMemoryDocumentRepository;
import service.DocumentService;
import service.impl.DocumentServiceImpl;
import service.impl.MandatoryFieldIsNotDefinedException;
import sun.util.resources.TimeZoneNames_de;

import javax.print.Doc;
import java.util.Date;
import java.util.List;

/**
 * @author Maryam Ebrahimi
 */
public class DocumentServiceTest {
    Document document = new Document();
    //1. making an instance variable
    private DocumentService documentService = new DocumentServiceImpl();

    //2.adding test method: public , void, throws exception, without parameters
    //3. write @Test above the methods
    //4. call the target method with , keep the method output in a variable
    //5. compare ( assert) the output with the expected result
    /*@Test
    public void loadByUniqueIdentifier () throws Exception{
        Assert.assertNotNull(document.getUniqueIdentifier());
    }
    @Test
public void loadByName () throws Exception{
        Assert.assertNotNull(document.getName());
    }
    @Test
    public void updateDocumentByName() throws Exception {
        //save
        Document result = documentService.loadByName("PDF");
        Assert.assertNotNull(result);
        Assert.assertEquals("PDF", result.getName());
        result.setName("PDF1");
        documentService.update(result);
        Document updatedResult = documentService.loadByName("PDF1");
        Assert.assertNotNull(updatedResult);
        Assert.assertEquals("PDF1", result.getName());
    }

    @Test
    public void deleteDocumentByUniqueIdentifier() throws Exception {
        //save
        Document result = documentService.loadByUniqueIdentifier("pdf");
        Assert.assertNotNull(result);
        Assert.assertEquals("pdf",result);
        documentService.deleteByUniqueIdentifier(result);
        Document deletedDocument = documentService.loadByUniqueIdentifier("pdf");
        Assert.assertNull(deletedDocument);
    }

    @Test
    public void loadDocumentByTag() throws Exception {
        Document document1 = new Document();
        document1.setName("pdf");
        documentService.save(document1);
        Assert.assertEquals("pdf", document1);
        Document document2 = new Document();
        document2.setName("office");
        documentService.save(document2);
        Assert.assertEquals("office", document2);
        Document document3 = new Document();
        document3.setName("word");
        documentService.save(document3);
        Assert.assertEquals("word", document3);
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
        Assert.assertEquals("office", document1);
        Document document2 = new Document();
        document2.setName("excel");
        documentService.save(document2);
        Assert.assertEquals("excel", document2);
        Document document3 = new Document();
        document3.setName("word");
        documentService.save(document3);
        Assert.assertEquals("word", document3);
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
    @Test
    public void loadByNameAndType ()throws Exception{
        Document document = new Document();
        document.setName("document1");
        document.setType("pdf");
        documentService.save(document);
        try {
            Assert.assertNotNull(document.getName());
            Assert.assertNotNull(document.getType());
        }catch(Exception e){
            throw new IllegalArgumentException("Name or type is empty");
        }
        Assert.assertEquals("document1",document.getName());
        Assert.assertEquals("pdf",document.getType());
    }*/
    @Test
    public void saveDocument() throws Exception {
        Document document = new Document();
        Assert.assertNull(document.getDate());
        DocumentRepository documentRepository = new InMemoryDocumentRepository();
        //??  documentRepository.saveDocument();
        Assert.assertNotNull(document.getDate());
    }

    public void loadByDateRange() throws Exception {
        Document document1 = new Document();
        Document document2 = new Document();
        document1.setName("word");
        document2.setName("pdf");
        //List<Document> dateRange = documentService.loadByDateRange(Date.from(ZonedDateTime.now().minusWeeks(1).toInstant(), newDate());
        //Assert.assertEquals(2, dateRange);
        {

        }
    }

    public void createDocumentWithoutCreatedBy() throws Exception {
        Document document = new Document();
        try {
            document.setName("word");
            Assert.assertNotNull(document);
        } catch (Exception e) {
            throw new MandatoryFieldIsNotDefinedException();
        }
    }

    public void saveDocumentDocumentService() throws Exception {
        Document document = new Document();
        Assert.assertNull(document.getDate());
        DocumentService documentService = new DocumentServiceImpl();
        try {
            documentService.save(document);
            Assert.assertNotNull(document.getDate());
        } catch (Exception e) {
            throw new MandatoryFieldIsNotDefinedException();
        }
    }
}
