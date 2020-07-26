package mg.rockpaperscissors.game

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

    override fun outputSummary(rounds: List<Round>) {
        TODO("Not yet implemented")
    }
}