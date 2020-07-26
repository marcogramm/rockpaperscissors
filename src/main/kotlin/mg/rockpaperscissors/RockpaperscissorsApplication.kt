package mg.rockpaperscissors

import mg.rockpaperscissors.domain.Action
import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.strategy.RandomChoiceStrategy
import mg.rockpaperscissors.domain.strategy.StubbornStrategy
import mg.rockpaperscissors.game.Game
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RockpaperscissorsApplication(private val game: Game) : CommandLineRunner {
    val roundsToPlay: Int = 100

    override fun run(vararg args: String?) {
        // register 2 Players to the game and play the game for 100 rounds

        val player1 = Player("Max", RandomChoiceStrategy())
        val player2 = Player("Petra", StubbornStrategy(Action.ROCK))

        game.registerPlayer1(player1)
        game.registerPlayer2(player2)
        game.startGame(roundsToPlay)
    }
}

fun main(args: Array<String>) {
    runApplication<RockpaperscissorsApplication>(*args)
}
