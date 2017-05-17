package br.com.pasquantonio.walmart.frontshipping.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.pasquantonio.walmart.frontshipping.FrontShippingApplication;
import br.com.pasquantonio.walmart.frontshipping.dto.ShippingSchedule;

@Service
public class ShippingScheduleSender {
	 
    private static final Logger log = LoggerFactory.getLogger(ShippingScheduleSender.class);
 
    private final RabbitTemplate rabbitTemplate;
 
    @Autowired
    public ShippingScheduleSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
 
    @Scheduled(fixedDelay = 3000L)
    public void sendMessage() {
        final ShippingSchedule message = new ShippingSchedule();
        log.info("Sending message...");
        rabbitTemplate.convertAndSend("EXCHANGE_NAME", "ROUTING_KEY", message);
    }
}
