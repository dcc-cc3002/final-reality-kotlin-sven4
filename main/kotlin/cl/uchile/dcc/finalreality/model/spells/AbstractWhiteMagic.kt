package cl.uchile.dcc.finalreality.model.spells

import cl.uchile.dcc.finalreality.exceptions.InvalidSpellForMageException
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage

abstract class AbstractWhiteMagic(override var cost: Int) : Spell {
    fun useSpell (blackMage: BlackMage, target: GameCharacter){
        throw InvalidSpellForMageException(blackMage)
    }

    abstract fun useSpell (whiteMage: WhiteMage, target: GameCharacter)
}