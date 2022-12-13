package cl.uchile.dcc.finalreality.exceptions

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.lang.Exception

/**
 * This error is used to represent an error at doing the transition of states.
 *
 * @constructor Creates a new `IllegalStateTransitionException` with the `target` of the
 * error.
 *
 * @author <a href="https://github.com/sven4">sven4</a>
 */
class IllegalStateTransitionException(target: GameCharacter) :
    Exception("Error doing the state transition with given target: $target")
