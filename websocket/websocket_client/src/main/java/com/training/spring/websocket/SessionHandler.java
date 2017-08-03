package com.training.spring.websocket;

import java.util.concurrent.atomic.AtomicReference;

import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class SessionHandler extends StompSessionHandlerAdapter {
	private final AtomicReference<Throwable> failure;

	public SessionHandler(final AtomicReference<Throwable> failure) {
		this.failure = failure;
	}

	@Override
	public void handleFrame(final StompHeaders headers,
	                        final Object payload) {
		this.failure.set(new Exception(headers.toString()));
	}

	@Override
	public void handleException(final StompSession s,
	                            final StompCommand c,
	                            final StompHeaders h,
	                            final byte[] p,
	                            final Throwable ex) {
		this.failure.set(ex);
	}

	@Override
	public void handleTransportError(final StompSession session,
	                                 final Throwable ex) {
		this.failure.set(ex);
	}

	@Override
	public void afterConnected(final StompSession session,
	                           final StompHeaders connectedHeaders) {
		session.subscribe("/topic/greetings",
		                  new FrameHandler());
		try {
			session.send("/app/hello",
			             new Greeting("Spring"));
		} catch (final Throwable t) {
			this.failure.set(t);
		}
	}

}
