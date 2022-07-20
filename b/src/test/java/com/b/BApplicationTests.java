package com.b;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

@SpringBootTest
class BApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Test
    public void t1() {
        Session session = null;
        try (InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\12.jpeg");) {
            int available = is.available();
            byte[] byt = new byte[available];
            is.read(byt);
            SessionFactory factory = hibernateTemplate.getSessionFactory();
            session = factory.openSession();
            Blob blob = Hibernate.getLobCreator(session).createBlob(byt);
            System.out.println(blob.toString());

        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
