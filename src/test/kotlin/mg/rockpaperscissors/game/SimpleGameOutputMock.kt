package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Round

class SimpleGameOutputMock : GameOutput {
    override fun outputRound(round: Round) {
    }

    override fun outputSummary(rounds: List<Round>) {
    }
}