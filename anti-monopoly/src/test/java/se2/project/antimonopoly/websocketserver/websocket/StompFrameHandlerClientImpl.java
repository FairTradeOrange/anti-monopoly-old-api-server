package se2.project.antimonopoly.websocketserver.websocket;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.concurrent.BlockingQueue;

public class StompFrameHandlerClientImpl implements StompFrameHandler {
    private BlockingQueue<String> messagesQueue;

    public StompFrameHandlerClientImpl(BlockingQueue<String> receivedMessagesQueue) {
        messagesQueue = receivedMessagesQueue;
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        try {
            String message = (String) payload;
            messagesQueue.add(message);
            // Optional: Logging der empfangenen Nachricht
            System.out.println("Received message: " + message);
        } catch (ClassCastException e) {
            System.err.println("Error casting the payload to String: " + e.getMessage());
        }
    }

}