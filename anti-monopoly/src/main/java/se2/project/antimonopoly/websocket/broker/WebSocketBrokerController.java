package se2.project.antimonopoly.websocket.broker;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * This class is a controller for the WebSocket broker.
 * It handles messages sent to the broker and sends responses back.
 * WebSocket controller -> focus on real-time messages and events not RESTful API endpoints!
 **/
@Controller
public class WebSocketBrokerController {

    @MessageMapping("/hello")
    @SendTo("/topic/hello-response")
    public String handleHello(String message) {
        return "echo from broker: " + HtmlUtils.htmlEscape(message);
    }

}