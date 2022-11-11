package cl.uchile.dcc.finalreality.exceptions

/**
 * This error is used to represent an invalid weapon equipped.
 *
 * @constructor Creates a new `InvalidWeaponEquipped` with a `description` of the
 * error.
 *
 * @author <a href="https://github.com/sven4">sven4</a>
 */
class InvalidWeaponEquipped(description: String) :
    Exception("This character cant equipped that weapon. $description")
