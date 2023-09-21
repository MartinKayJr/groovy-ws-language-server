package net.prominic.groovyls.webSocket;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServerEndpointRegistration;

@Configuration
@EnableWebSocket
public class WebSocketConfig {
	public static final String USER_NAME = "user";
	public static final String IP = "ip";
	
	@Bean
	public ServerEndpointRegistration serverEndpointRegistration(){
		return new ServerEndpointRegistration("/groovy", GroovyLspEndpoint.class){
			@Override
			public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
				sec.getUserProperties().put(IP, ((HttpSession) request.getHttpSession()).getAttribute(IP));
			}
		};
	}
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
	
}
