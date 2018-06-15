package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping6collection.Attachment;
import mapping.entity.mapping6collection.AttachmentEmbedded;
import mapping.entity.mapping6collection.News;
import mapping.entity.mapping6collection.News2;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class Mapping6Collections extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();

        List<String> list = new ArrayList<String>();
        list.add("tag1");
        list.add("tag2");
        list.add("tag3");
        list.add("tag4");

        List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("aaa1", "bbb1"));
        attachments.add(new Attachment("aaa2", "bbb2"));
        attachments.add(new Attachment("aaa3", "bbb3"));
        attachments.add(new Attachment("aaa4", "bbb4"));

        List<AttachmentEmbedded> attachmentEmbeddedList = new ArrayList<AttachmentEmbedded>();
        attachmentEmbeddedList.add(new AttachmentEmbedded("aaa1", "bbb1"));
        attachmentEmbeddedList.add(new AttachmentEmbedded("aaa2", "bbb2"));
        attachmentEmbeddedList.add(new AttachmentEmbedded("aaa3", "bbb3"));
        attachmentEmbeddedList.add(new AttachmentEmbedded("aaa4", "bbb4"));

        News news = new News();
        news.setTags(list);
        news.setAttachments(attachments);
        news.setAttachmentEmbedded(attachmentEmbeddedList);

        News2 news2 = new News2();
        news2.setTags(list);

        entityManager.getTransaction().begin();
        entityManager.merge(news);
        entityManager.merge(news2);
        entityManager.getTransaction().commit();
        entityManager.clear();

        executeJpaSql(entityManager, "select n from News n", "News");

        entityManager.close();
        EMF.close();
    }

}
