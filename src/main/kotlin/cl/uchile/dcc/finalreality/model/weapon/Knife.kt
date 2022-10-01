package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

/**
 * A knife class is a type of [CommonWeapon].
 *
 * @property name String
 *     The name of the knife.
 * @property damage Int
 *     The base damage done by the knife.
 * @property weight Int
 *     The weight of the knife.
 *
 * @constructor Creates a knife with a name, a base damage and speed.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
class Knife(
    name: String,
    damage: Int,
    weight: Int
) : CommonWeapon(name, damage, weight) {
    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Knife -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Knife::class, name, damage, weight)

    override fun toString() = "Knife { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight " +
        "}"
}
