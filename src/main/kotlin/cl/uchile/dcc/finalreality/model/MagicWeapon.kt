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
 * @property magicDamage Int
 *     The base magic damage done by the magic weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, it's type,
 *              and base magic damage.
 *
 * @author <a href="https://www.github.com/sven4">sven4</a>
 * @author ~Salvador Vasquez~
 */
class MagicWeapon(
    name: String,
    damage: Int,
    weight: Int,
    type: WeaponType,
    val magicDamage: Int
) : PhysicalWeapon(name, damage, weight, type) {
    override fun equals(other: Any?) = when {
        this === other -> true
        other !is MagicWeapon -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        type != other.type -> false
        magicDamage != other.magicDamage -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(MagicWeapon::class, name, damage, weight, type, magicDamage)

    override fun toString() = "MagicWeapon { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight, " +
        "type: $type, " +
        "magicDamage: $magicDamage " +
        "}"
}
