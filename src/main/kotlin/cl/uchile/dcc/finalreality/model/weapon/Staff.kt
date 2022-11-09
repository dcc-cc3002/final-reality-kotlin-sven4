package cl.uchile.dcc.finalreality.model.weapon

import java.util.Objects

class Staff(
    name: String,
    damage: Int,
    weight: Int,
    magicDamage: Int
) : MagicWeapon(name, damage, weight, magicDamage) {

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Staff -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        magicDamage != other.magicDamage -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Staff::class, name, damage, weight, magicDamage)

    override fun toString() = "Staff { " +
        "name: $name, " +
        "damage: $damage, " +
        "weight: $weight, " +
        "magicDamage: $magicDamage" +
        " }"
}
