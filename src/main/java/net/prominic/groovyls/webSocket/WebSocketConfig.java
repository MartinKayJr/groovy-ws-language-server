package net.prominic.groovyls.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

@Configuration
public class WebSocketConfig {
	
	@Bean
	public ServerEndpointRegistration serverEndpointRegistration(){
		return new ServerEndpointRegistration("/groovy",GroovyLspEndpoint.class);
	}
	
	
}
