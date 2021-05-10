package net.prominic.groovyls.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

@Configuration
@EnableWebSocket
public class WebSocketConfig {
	public static final String USER_NAME = "user";
	public static final String IP = "ip";
	
	@Bean
	public ServerEndpointRegistration serverEndpointRegistration(){
		ServerEndpointRegistration serverEndpointRegistration = new ServerEndpointRegistration("/groovy", GroovyLspEndpoint.class){
			@Override
			public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
				sec.getUserProperties().put(IP, ((HttpSession) request.getHttpSession()).getAttribute(IP));
			}
		};
		
		return serverEndpointRegistration;
	}
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
}
