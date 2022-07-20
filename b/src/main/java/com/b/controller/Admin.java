package com.b.controller;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author zhangfx
 * @date 2022/7/20
 */
@RestController
public class Admin {
    @Autowired
    Session session;
    @GetMapping("/img")
    public void t1(HttpServletResponse response) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\12.jpeg");
        write(file, response);
    }


    public void write(Blob img, HttpServletResponse response) {
        Optional.ofNullable(img).ifPresent(blob -> {
                    response.setContentType("image/pjpeg");
                    try (InputStream is = blob.getBinaryStream();
                         OutputStream os = response.getOutputStream();) {
                        int len = -1;
                        byte[] buff = new byte[4 * 1024];
                        while ((len = is.read(buff)) != -1) {
                            os.write(buff, 0, len);
                        }
                        os.flush();
                    } catch (SQLException | IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
    public void write(File file,HttpServletResponse response) {
        response.setContentType("image/pjpeg");
        try (InputStream fis = new FileInputStream(file);OutputStream os = response.getOutputStream()) {
            int len = -1;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Blob fileToBlob(File file) {
        Blob blob = null;
        try (InputStream is = new FileInputStream(file);) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            blob = Hibernate.getLobCreator(session).createBlob(bytes);
        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return blob;
    }
}
