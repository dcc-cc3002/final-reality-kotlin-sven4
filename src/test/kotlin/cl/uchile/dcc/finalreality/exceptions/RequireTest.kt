package cl.uchile.dcc.finalreality.exceptions

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class RequireTest : FunSpec(
    {
        test(
            "Creating a stat with negative damage should throw" +
                " an InvalidStatValueException"
        ) {
            shouldThrow<InvalidStatValueException> {
                Require.Stat(-1, "damage") atLeast 0
            }
        }

        test("Creating a stat out of range should throw and InvalidStatValueException") {
            shouldThrow<InvalidStatValueException> {
                Require.Stat(200, "currentMP") inRange 0..100
            }
        }
    }
)
