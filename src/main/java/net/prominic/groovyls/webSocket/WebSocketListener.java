package net.prominic.groovyls.webSocket;

import org.springframework.stereotype.Component;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebListener
@Component
public class WebSocketListener implements ServletRequestListener {
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		HttpSession session = ((HttpServletRequest) sre.getServletRequest()).getSession();
		session.setAttribute(WebSocketConfig.IP,sre.getServletRequest().getRemoteAddr());
	}
}
