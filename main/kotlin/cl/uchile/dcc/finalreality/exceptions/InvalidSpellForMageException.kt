package cl.uchile.dcc.finalreality.exceptions

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.lang.Exception

/**
 * Error used for a mage using the wrong type of magic
 *
 * @constructor Creates a new `InvalidSpellForMageException`
 */
class InvalidSpellForMageException(mage: GameCharacter) :
    Exception("The mage '${mage.name}' cannot use this type of magic.")
