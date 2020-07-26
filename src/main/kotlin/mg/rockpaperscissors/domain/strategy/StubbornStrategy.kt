package mg.rockpaperscissors.domain.strategy

import mg.rockpaperscissors.domain.Action

/**
 * Class implementing the Strategy Interface to determine a next Action according to
 * the "Stubborn Strategy".
 * The Stubburn Strategy simply returns the Action it was instatiated with, every single time
 * the method is called.
 */
class StubbornStrategy(private val action: Action) : Strategy {

    /**
     * @see Strategy.nextAction
     */
    override fun nextAction(): Action = action
}