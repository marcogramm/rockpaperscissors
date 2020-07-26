package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Action
import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.strategy.RandomChoiceStrategy
import mg.rockpaperscissors.domain.strategy.StubbornStrategy

class GameImplTestHelper {

    companion object {
        fun getPlayer1(): Player {
            return Player("Player1", StubbornStrategy(Action.ROCK))
        }

        fun getGameWithPlayers(): Game {
            val game: Game = GameImpl()
            game.registerPlayer1(getPlayer1())
            game.registerPlayer2(getPlayer2())
            return game
        }

        fun getPlayer2(): Player {
            return Player("Player2", RandomChoiceStrategy())
        }
    }
}