package cl.uchile.dcc.finalreality.states

class StatePoison : CharacterState() {
    override fun toNormal() {
        character.state = StateNormal()
    }

    override fun isPoison(): Boolean {
        return true
    }

}
