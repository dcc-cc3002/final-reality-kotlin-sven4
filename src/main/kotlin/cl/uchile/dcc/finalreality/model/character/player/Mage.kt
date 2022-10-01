package cl.uchile.dcc.finalreality.model.character.player

/**
 * A mage interface for [WhiteMage] and [BlackMage]
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */

interface Mage {
    val maxMp: Int
    var currentMp: Int
}
