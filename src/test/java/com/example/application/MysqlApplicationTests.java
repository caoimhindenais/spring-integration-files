package com.example.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration({
        "classpath*:context.xml"})
public class MysqlApplicationTests {

    @Qualifier("Files Inbound Channel")
    @Autowired
    QueueChannel inputChannel;

    @Qualifier("Archive Channel")
    @Autowired
    QueueChannel archiveChannel;

    @Test
    public void workFlowTest() throws IOException {
        File testFile = File.createTempFile("message", "txt");
        inputChannel.send(MessageBuilder.withPayload(testFile).build());
        Message<?> archiveMessage = archiveChannel.receive(0);
        assertNull("Check Payload", archiveMessage.getPayload());
    }

}
