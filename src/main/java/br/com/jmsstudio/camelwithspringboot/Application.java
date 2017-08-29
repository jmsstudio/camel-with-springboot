package br.com.jmsstudio.camelwithspringboot;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
	private CamelContext camelContext;

    @PostConstruct
    public void init() {
        camelContext.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));
    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
