package cl.uchile.dcc.finalreality.states

class StateNormal : CharacterState() {
    override fun toParalyze() {
        character.state = StateParalyzed()
    }

    override fun toPoison() {
        character.state = StatePoison()
    }

    override fun toBurned() {
        character.state = StateBurned()
    }

    override fun isNormal(): Boolean {
        return true
    }
}