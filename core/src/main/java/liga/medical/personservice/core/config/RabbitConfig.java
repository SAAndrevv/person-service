package liga.medical.personservice.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfig {

    @Value("${sprint.rabbitmq.host:localhost}")
    private String host;
    @Value("${sprint.rabbitmq.port:5672}")
    private int port;

    @Value("${rabbit.queue.daily-queue}")
    private String dailyQueue;
    @Value("${rabbit.queue.alert-queue}")
    private String alertQueue;

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new
                CachingConnectionFactory(host);
        connectionFactory.setPort(port);

        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(producerJackson2MessageConverter());
        return factory;
    }

    @Bean("daily-queue")
    public Queue dailyQueue() {
        return new Queue(dailyQueue);
    }

    @Bean("alert-queue")
    public Queue alertQueue() {
        return new Queue(alertQueue);
    }

}
