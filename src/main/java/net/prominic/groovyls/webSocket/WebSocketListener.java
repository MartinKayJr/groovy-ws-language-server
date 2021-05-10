package net.prominic.groovyls.webSocket;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebListener
@Component
public class WebSocketListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();
		session.setAttribute(WebSocketConfig.IP,sre.getServletRequest().getRemoteAddr());
	}
}
