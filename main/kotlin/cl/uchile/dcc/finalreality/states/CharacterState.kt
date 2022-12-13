package cl.uchile.dcc.finalreality.states

import cl.uchile.dcc.finalreality.exceptions.IllegalStateTransitionException
import cl.uchile.dcc.finalreality.model.character.GameCharacter

open class CharacterState {
    lateinit var character: GameCharacter

    private fun transitionError() {
        throw IllegalStateTransitionException(this.character)
    }

    open fun toNormal() { transitionError() }
    open fun toParalyze() { transitionError() }
    open fun toPoison() { transitionError() }
    open fun toBurned() { transitionError() }

    open fun isNormal() : Boolean{
        return false
    }

    open fun isParalyzed() : Boolean {
        return false
    }

    open fun isPoison() : Boolean {
        return false
    }

    open fun isBurned() : Boolean {
        return false
    }

}