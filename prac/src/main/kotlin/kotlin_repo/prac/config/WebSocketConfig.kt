package kotlin_repo.prac.config

import kotlin_repo.prac.config.handler.WebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import java.net.http.WebSocket

@Configuration
@EnableWebSocket
class WebSocketConfig (
    private val webSocketHandler: WebSocketHandler
) : WebSocketConfigurer {
    
}