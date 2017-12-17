package com.example;

import com.example.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;

/**
 * Created by kevin on 14.12.17.
 */
@Transactional
public class FileControl {

    @PersistenceContext(unitName = "punit")
    public EntityManager myEmf;


    public Message save (Message message) {
        File file = new File();
        file.setName(message.getPayload().toString());
        file.setCreated(LocalDateTime.now());
        file.setHost(this.toString());
        myEmf.persist(file);

        return message;
    }

}
