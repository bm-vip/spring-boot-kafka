package behrooz.kafka.springbootkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class SpringBootKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Value("${spring-boot-kafka.topic-name}")
    private String topicName;
    private int id;

    @Scheduled(fixedRate = 5000, initialDelay = 10000)
    public void send() {
        kafkaTemplate.send(topicName, new MessageDto(++id, new Date().toString()));
    }

    @KafkaListener(topics = "${spring-boot-kafka.topic-name}")
    public void listenAsObject(@Payload MessageDto messageDto) {
        System.out.println("Received <" + messageDto.toString() + ">");
    }

}
