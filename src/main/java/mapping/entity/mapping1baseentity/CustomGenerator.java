package mapping.entity.mapping1baseentity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomGenerator implements IdentifierGenerator {
    public static int value = 0;

    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss.SSS" + "_" + value++);
        String id = simpleDateFormat.format(new Date());
        return id;
    }
}
