package net.prominic.groovyls.webSocket;

import lombok.extern.slf4j.Slf4j;
import net.prominic.groovyls.GroovyLanguageServer;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.websocket.WebSocketEndpoint;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;
import java.util.Collection;
@Slf4j
public class GroovyLspEndpoint extends WebSocketEndpoint<LanguageClient> {
	
	@Override
	protected void configure(Launcher.Builder<LanguageClient> builder) {
		builder.setRemoteInterface(LanguageClient.class);
		builder.setLocalService(new GroovyLanguageServer());
	}
	
	@Override
	protected void connect(Collection<Object> localServices, LanguageClient remoteProxy) {
		localServices.stream()
		             .filter(LanguageClientAware.class::isInstance)
		             .forEach(aware -> ((LanguageClientAware) aware).connect(remoteProxy));
	}
	
	@Override
	public void onOpen(Session session, EndpointConfig config) {
		log.info("{}/{} connect...",config.getUserProperties().get(WebSocketConfig.IP),session.getId());
		super.onOpen(session, config);
	}
	
	@Override
	public void onClose(Session session, CloseReason closeReason) {
		log.info("{} disconnect...",session.getId());
		super.onClose(session, closeReason);
	}
}
