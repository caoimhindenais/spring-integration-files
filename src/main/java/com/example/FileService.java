package com.example;

import com.example.entity.FileEntity;
import org.springframework.messaging.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by kevin on 14.12.17.
 */
@Transactional
public class FileService {

    @PersistenceContext(unitName = "punit")
    public EntityManager myEmf;

    public Message save (Message message) {
        FileEntity file = new FileEntity();
        file.setName(message.getPayload().toString());
        file.setCreated(LocalDateTime.now());
        file.setHost(this.toString());
        myEmf.persist(file);
        return message;
    }

}
