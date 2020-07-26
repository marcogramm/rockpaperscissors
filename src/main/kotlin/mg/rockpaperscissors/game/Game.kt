package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Round

/**
 * Game Interface for exposing the basic setUp and starting functions of
 * the RockPaperSc
 */
interface Game {
    /**
     * registers Player1
     * @param player the Player to be registered
     */
    fun registerPlayer1(player: Player)

    /**
     * registers Player2
     * @param player the Player to be registered
     */
    fun registerPlayer2(player: Player)

    /**
     * Starts a game that lasts for the given number of rounds
     * @param roundsToPlay The number of rounds to play
     */
    fun startGame(roundsToPlay: Int)

    /**
     * Returns all rounds that have been played since the game was started
     * @return List of Rounds that have been played
     */
    fun getRoundsPlayed(): List<Round>

    /**
     * Return the last round played
     * @return the last Round played
     */
    fun getLastRoundPlayed(): Round

    /**
     * returns a List of the currently Registered Players
     * @return The List of all currently registered Players
     */
    fun getRegisteredPlayers(): List<Player>
}