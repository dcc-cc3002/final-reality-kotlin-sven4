package kotlin.cl.uchile.dcc.finalreality.model.weapon

import kotlin.cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import java.util.Objects

class Sword(
    name: String,
    damage: Int,
    weight: Int
) : CommonWeapon(name, damage, weight) {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Sword -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Sword::class, name, damage, weight)

    override fun toString() = "Sword { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight" +
        " }"

    override fun getEquiped(character: PlayerCharacter): Weapon {
        return character.equipSword(this)
    }
}
