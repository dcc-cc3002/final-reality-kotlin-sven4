package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

/**
 * A sword class is a type of [CommonWeapon].
 *
 * @property name String
 *     The name of the sword.
 * @property damage Int
 *     The base damage done by the sword.
 * @property weight Int
 *     The weight of the sword.
 *
 * @constructor Creates a sword with a name, a base damage and speed.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
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
        "weight: $weight " +
        "}"
}
