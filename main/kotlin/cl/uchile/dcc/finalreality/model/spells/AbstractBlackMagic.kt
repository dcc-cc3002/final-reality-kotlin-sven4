package cl.uchile.dcc.finalreality.model.spells

import cl.uchile.dcc.finalreality.exceptions.InvalidSpellForMageException
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage

abstract class AbstractBlackMagic(override var cost: Int) : Spell {
    abstract fun useSpell (blackMage: BlackMage, target: GameCharacter)

    fun useSpell (whiteMage: WhiteMage, target: GameCharacter) {
        throw InvalidSpellForMageException(whiteMage)
    }
}