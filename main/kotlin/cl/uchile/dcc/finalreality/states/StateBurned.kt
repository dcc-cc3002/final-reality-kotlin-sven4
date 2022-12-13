package cl.uchile.dcc.finalreality.states

class StateBurned : CharacterState() {
    override fun toNormal() {
        character.state = StateNormal()
    }

    override fun isBurned() : Boolean{
        return true
    }
}
