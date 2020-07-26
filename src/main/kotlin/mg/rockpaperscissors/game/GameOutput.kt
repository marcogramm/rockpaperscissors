package mg.rockpaperscissors.game

import mg.rockpaperscissors.domain.Round

interface GameOutput {
    /**
     * Output the given round to a Device (e.g. to the Console) depending on the Implementation
     * @param round The Round to be outputted
     */
    fun outputRound(round: Round)

    /**
     * Output a summary of the given rounds to a device (e.g. to the Console) depending on the Implementation
     * @param rounds The List of rounds to be summarized
     */
    fun outputSummary(rounds: List<Round>)
}