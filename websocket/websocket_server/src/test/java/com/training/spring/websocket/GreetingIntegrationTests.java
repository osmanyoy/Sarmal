package com.training.spring.websocket;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingIntegrationTests {

	@LocalServerPort
	private int port;

	private SockJsClient sockJsClient;

	private WebSocketStompClient stompClient;

	private final WebSocketHttpHeaders headers = new WebSocketHttpHeaders();

	@Before
	public void setup() {
		final List<Transport> transports = new ArrayList<>();
		transports.add(new WebSocketTransport(new StandardWebSocketClient()));
		this.sockJsClient = new SockJsClient(transports);

		this.stompClient = new WebSocketStompClient(this.sockJsClient);
		this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
	}

	@Test
	public void getGreeting() throws Exception {

		final CountDownLatch latch = new CountDownLatch(1);
		final AtomicReference<Throwable> failure = new AtomicReference<>();

		final StompSessionHandler handler = new TestSessionHandler(failure) {

			@Override
			public void afterConnected(final StompSession session,
			                           final StompHeaders connectedHeaders) {
				session.subscribe("/topic/greetings",
				                  new StompFrameHandler() {
					                  @Override
					                  public Type getPayloadType(final StompHeaders headers) {
						                  return Greeting.class;
					                  }

					                  @Override
					                  public void handleFrame(final StompHeaders headers,
					                                          final Object payload) {
						                  final Greeting greeting = (Greeting) payload;
						                  try {
							                  Assert.assertEquals("Hello, Spring!",
							                                      greeting.getContent());
						                  } catch (final Throwable t) {
							                  failure.set(t);
						                  } finally {
							                  session.disconnect();
							                  latch.countDown();
						                  }
					                  }
				                  });
				try {
					session.send("/app/hello",
					             new HelloMessage("Spring"));
				} catch (final Throwable t) {
					failure.set(t);
					latch.countDown();
				}
			}
		};

		this.stompClient.connect("ws://localhost:{port}/gs-guide-websocket",
		                         this.headers,
		                         handler,
		                         this.port);

		if (latch.await(3,
		                TimeUnit.SECONDS)) {
			if (failure.get() != null) {
				throw new AssertionError("",
				                         failure.get());
			}
		} else {
			Assert.fail("Greeting not received");
		}

	}

	private class TestSessionHandler extends StompSessionHandlerAdapter {

		private final AtomicReference<Throwable> failure;

		public TestSessionHandler(final AtomicReference<Throwable> failure) {
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
	}
}
