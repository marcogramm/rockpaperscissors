package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Round

/**
 * Game Interface for exposing the basic setUp and starting functions of
 * the RockPaperSc
 */
interface Game {
    fun registerPlayer1(player: Player)

    fun registerPlayer2(player: Player)

    fun startGame()

    fun getRoundsPlayed(): List<Round>
}