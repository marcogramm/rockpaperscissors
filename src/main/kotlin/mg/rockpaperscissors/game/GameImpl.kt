package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Action
import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Result
import mg.rockpaperscissors.domain.Result.*
import mg.rockpaperscissors.domain.Round
import org.springframework.stereotype.Component

@Component
class GameImpl(private val output: GameOutput) : Game {
    private val roundsPlayed = mutableListOf<Round>()
    private lateinit var player1: Player
    private lateinit var player2: Player

    override fun registerPlayer1(player: Player) {
        player1 = player
    }

    override fun registerPlayer2(player: Player) {
        player2 = player
    }

    override fun startGame(roundsToPlay: Int) {
        validateStartGameConditions(roundsToPlay)

        for (x in 0 until roundsToPlay) {
            computeNewRound()
            outputLastRound()
        }

        outputSummary()
    }

    private fun validateStartGameConditions(roundsToPlay: Int) {
        if (roundsToPlay <= 0) {
            throw IllegalArgumentException("roundsToPlay should be greater than 0")
        }
        if (!this::player1.isInitialized || !this::player2.isInitialized) {
            throw IllegalStateException("Two Players need to be registered into the game before game can start")
        }
    }

    /*
    Computes a new Round according to both Players strategies and adds it to the list
    of played rounds
     */
    private fun computeNewRound() {
        val player1Action = player1.nextAction()
        val player2Action = player2.nextAction()
        val round = Round()

        round.addActionAndResultForPlayer(player1, player1Action, computeResult(player1Action, player2Action))
        round.addActionAndResultForPlayer(player2, player2Action, computeResult(player2Action, player1Action))

        roundsPlayed.add(round)
    }

    private fun computeResult(action1: Action, action2: Action): Result {
        return when {
            action1.beats(action2) -> WIN
            action2.beats(action1) -> LOSS
            else -> DRAW
        }
    }

    private fun outputLastRound() {
        output.outputRound(roundsPlayed.last())
    }

    private fun outputSummary() {
        output.outputSummaryForPlayers(listOf(player1, player2), roundsPlayed)
    }

    override fun getLastRoundPlayed(): Round = roundsPlayed.last()

    override fun getRoundsPlayed(): List<Round> = roundsPlayed

    override fun getRegisteredPlayers(): List<Player> = listOf(player1, player2)
}