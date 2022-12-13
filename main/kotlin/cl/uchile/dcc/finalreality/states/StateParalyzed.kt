package cl.uchile.dcc.finalreality.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

class StateParalyzed () : CharacterState(){
    override fun toNormal() {
        character.state = StateNormal()
    }

    override fun isParalyzed(): Boolean {
        return true
    }
}