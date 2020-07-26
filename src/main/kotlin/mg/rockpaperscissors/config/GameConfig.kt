package mg.rockpaperscissors.config

import mg.rockpaperscissors.game.ConsoleGameOutput
import mg.rockpaperscissors.game.GameOutput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GameConfig {
    @Bean
    fun gameOutput(): GameOutput = ConsoleGameOutput()
}