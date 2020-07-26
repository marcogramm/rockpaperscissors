package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Result
import mg.rockpaperscissors.domain.Round

class ConsoleGameOutput : GameOutput {
    companion object {
        private const val SEPERATOR = "============================================"
    }

    override fun outputRound(round: Round) {
        reportActionsForRound(round);
        reportResultsForRound(round)
        println(SEPERATOR)
    }

    private fun reportActionsForRound(round: Round) {
        println("Ready, Steady, Go! Show your actions!")
        round.actions
                .forEach { (player, action) -> println("${player.name} shows... $action! ") }
    }

    private fun reportResultsForRound(round: Round) {
        println("The round is over! The results are:")
        round.results
                .forEach { (player, result) -> println("${player.name}: $result") }
    }

    override fun outputSummaryForPlayers(players: List<Player>, rounds: List<Round>) {
        println("The round is over! Overall results are:")
        players.forEach { outSummaryForPlayer(it, rounds) }
    }

    private fun outSummaryForPlayer(player: Player, rounds: List<Round>) {
        var winCount: Int = 0
        var drawCount: Int = 0
        var lossCount: Int = 0

        rounds.forEach {
            when (it.results[player]){
                Result.WIN -> winCount++
                Result.LOSS -> lossCount++
                Result.DRAW -> drawCount++
            }
        }
        println(player.name)
        println("Wins: $winCount Draws: $drawCount Losses: $lossCount")
    }
}