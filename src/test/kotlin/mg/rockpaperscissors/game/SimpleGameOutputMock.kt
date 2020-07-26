package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Player
import mg.rockpaperscissors.domain.Round

class SimpleGameOutputMock : GameOutput {
    override fun outputRound(round: Round) {
    }

    override fun outputSummaryForPlayers(players: List<Player>, rounds: List<Round>) {
    }
}