package cl.uchile.dcc.finalreality.model.spells

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import kotlin.random.Random

class Trueno(override var cost: Int) : AbstractBlackMagic(cost) {
    override fun useSpell(blackMage: BlackMage, target: GameCharacter) {
        target.currentHp -= blackMage.equippedWeapon.magicDamage / 2
        val random = Random.nextInt(1, 10)
        if (random <= 3) {
            target.paralyze()
        }
    }
}