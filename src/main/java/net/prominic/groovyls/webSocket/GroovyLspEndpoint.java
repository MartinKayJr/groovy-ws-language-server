package net.prominic.groovyls.webSocket;

import net.prominic.groovyls.GroovyLanguageServer;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.websocket.WebSocketEndpoint;

import java.util.Collection;

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
}
