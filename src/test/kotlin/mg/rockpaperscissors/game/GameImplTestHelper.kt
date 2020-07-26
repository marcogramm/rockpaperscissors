package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Action
import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Round
import mg.rockpaperscissors.domain.strategy.RandomChoiceStrategy
import mg.rockpaperscissors.domain.strategy.StubbornStrategy

class GameImplTestHelper {

    companion object {
        fun getPlayer1(): Player {
            return Player("Player1", StubbornStrategy(Action.ROCK))
        }

        fun getGame(): GameImpl = GameImpl(SimpleGameOutputMock())

        fun getGameWithPlayers(): GameImpl {
            val game: GameImpl = GameImpl(SimpleGameOutputMock())
            game.registerPlayer1(getPlayer1())
            game.registerPlayer2(getPlayer2())
            return game
        }

        fun getPlayer2(): Player {
            return Player("Player2", RandomChoiceStrategy())
        }

        fun getGameWithOneRoundPlayed(player1: Player, player2: Player): Round {
            val game = getGame()
            game.registerPlayer1(player1)
            game.registerPlayer2(player2)
            game.startGame(1)
            return game.getLastRoundPlayed()
        }
    }
}