package br.com.jmsstudio.camelwithspringboot.service;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:pedidos?noop=true&delay=5s")
        .log("Msg: ${body}")
        .to("activemq:queue:fila.pedidos");
    }
}
