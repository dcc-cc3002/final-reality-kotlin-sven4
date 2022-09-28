package cl.uchile.dcc.finalreality.model

import java.util.Objects

/**
 * A class that holds all the information of a weapon.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 * @property type WeaponType
 *     The type of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, and it's type.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
open class PhysicalWeapon(
    val name: String,
    val damage: Int,
    val weight: Int,
    val type: WeaponType
) {
    override fun equals(other: Any?) = when {
        this === other -> true
        other !is PhysicalWeapon -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        type != other.type -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(PhysicalWeapon::class, name, damage, weight, type)

    override fun toString() = "Weapon { name: $name, damage: $damage, weight: $weight, type: $type }"
}
