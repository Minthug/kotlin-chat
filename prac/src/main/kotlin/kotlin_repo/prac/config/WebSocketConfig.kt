package kotlin_repo.prac.config

import kotlin_repo.prac.config.handler.WebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.*

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig: WebSocketMessageBrokerConfigurer{
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws").withSockJS()
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry) {
        config.setApplicationDestinationPrefixes("/app")
        config.enableSimpleBroker("/topic")
    }
}


//    private val webSocketHandler: WebSocketHandler
//) : WebSocketConfigurer {
//    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
//        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*")
//    }
//}


