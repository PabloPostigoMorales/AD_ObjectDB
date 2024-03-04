package domain;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBUtil {


    private final static EntityManagerFactory entityManagerFactory;

    static{
        entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
    }

    static public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }


}
