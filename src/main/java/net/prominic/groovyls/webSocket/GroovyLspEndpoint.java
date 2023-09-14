package net.prominic.groovyls.webSocket;

import lombok.extern.slf4j.Slf4j;
import net.prominic.groovyls.GroovyLanguageServer;
import net.prominic.groovyls.config.CompilationUnitFactory;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.lsp4j.services.LanguageClientAware;
import org.eclipse.lsp4j.websocket.WebSocketEndpoint;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnError;
import javax.websocket.Session;
import java.util.Arrays;
import java.util.Collection;

@Slf4j
public class GroovyLspEndpoint extends WebSocketEndpoint<LanguageClient> {

    @Override
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    protected void configure(Launcher.Builder<LanguageClient> builder) {
        builder.setRemoteInterface(LanguageClient.class);
        CompilationUnitFactory cuf = new CompilationUnitFactory();
        String[] args = {"C:\\Program Files\\Java\\jdk-1.8\\jre\\lib\\rt.jar"};
        cuf.setAdditionalClasspathList(Arrays.asList(args[0].split(",")));
        builder.setLocalService(new GroovyLanguageServer(cuf));
    }

    @Override
    protected void connect(Collection<Object> localServices, LanguageClient remoteProxy) {
        localServices.stream()
                .filter(LanguageClientAware.class::isInstance)
                .forEach(aware -> ((LanguageClientAware) aware).connect(remoteProxy));
    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        log.info("{}/{} connect...", config.getUserProperties().get(WebSocketConfig.IP), session.getId());
        super.onOpen(session, config);
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        log.info("{} disconnect...", session.getId());
        super.onClose(session, closeReason);
    }


}
