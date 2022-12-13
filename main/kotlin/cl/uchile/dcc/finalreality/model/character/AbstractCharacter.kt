package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.states.CharacterState
import cl.uchile.dcc.finalreality.states.StateNormal
import java.util.concurrent.BlockingQueue
import java.util.concurrent.ScheduledExecutorService

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @param name
 *    The name of the character.
 * @param maxHp
 *    The maximum health points of the character.
 * @param defense
 *    The defense of the character.
 * @param turnsQueue
 *    The queue with the characters waiting for their turn.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
abstract class AbstractCharacter(
    override val name: String,
    maxHp: Int,
    defense: Int,
    protected val turnsQueue: BlockingQueue<GameCharacter>,
) : GameCharacter {
    override var state: CharacterState = StateNormal()

    init {
        state.character = this
    }

    private lateinit var scheduledExecutor: ScheduledExecutorService
    override val maxHp = Require.Stat(maxHp, "Max Hp") atLeast 1
    override var currentHp = maxHp
        set(value) {
            field = Require.Stat(value, "Current Hp") inRange 0..maxHp
        }
    override val defense = Require.Stat(defense, "Defense") atLeast 0

    override fun paralyze() {
        state.toParalyze()
    }
    override fun poison() {
        state.toPoison()
    }
    override fun burned() {
        state.toBurned()
    }

    override fun isParalyzed() : Boolean {
        return state.isParalyzed()
    }

    override fun isPoison() : Boolean {
        return state.isBurned()
    }

    override fun isBurned() : Boolean {
        return state.isBurned()
    }
    abstract override fun waitTurn()
}