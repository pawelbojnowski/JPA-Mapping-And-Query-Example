package mapping;

import connection.AbstractAction;
import connection.EMF;
import mapping.entity.mapping9inheritance.*;

import javax.persistence.EntityManager;
import java.util.Date;

public class Mapping9Inheritance extends AbstractAction {

    public static void main(String... arg) {
        EntityManager entityManager = EMF.instanceEntityManager();
        entityManager.getTransaction().begin();

        //----One class for subclasses---------------------------------------

        ClientEvent ClientEvent = new ClientEvent();
        ClientEvent.setDeadline(new Date());
        entityManager.merge(ClientEvent);

        ClientRegular clientRegular = new ClientRegular();
        clientRegular.setStartDate(new Date());
        clientRegular.setEndDate(new Date());
        entityManager.merge(clientRegular);

        executeJpaSql(entityManager, "select ce from ClientEvent ce", "ClientEvent");
        executeJpaSql(entityManager, "select ce from ClientEvent ce", "ClientRegular");
        //----Table per subclass---------------------------------------

        TicketEvent ticketEvent = new TicketEvent();
        ticketEvent.setDeadline(new Date());
        entityManager.merge(ticketEvent);

        TicketRegular ticketRegular = new TicketRegular();
        ticketRegular.setStartDate(new Date());
        ticketRegular.setEndDate(new Date());
        ticketRegular.setName(5);
        entityManager.merge(ticketRegular);

        executeJpaSql(entityManager, "select te from TicketEvent te", "TicketEvent");
        executeJpaSql(entityManager, "select te from TicketRegular te", "TicketRegular");
        //----Joined table---------------------------------------

        VignetteEvent vignetteEvent = new VignetteEvent();
        vignetteEvent.setDeadline(new Date());
        entityManager.merge(vignetteEvent);

        VignetteRegular VignetteRegular = new VignetteRegular();
        VignetteRegular.setStartDate(new Date());
        VignetteRegular.setEndDate(new Date());
        entityManager.merge(VignetteRegular);

        executeJpaSql(entityManager, "select ve from VignetteEvent ve", "VignetteEvent");
        executeJpaSql(entityManager, "select ve from VignetteRegular ve", "VignetteRegular");

        entityManager.getTransaction().commit();

        entityManager.close();
        EMF.close();
    }

}
