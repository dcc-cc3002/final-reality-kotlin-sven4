package cl.uchile.dcc.finalreality.model.weapon

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class StaffTest : FunSpec(
    {
        lateinit var baston1: Staff
        lateinit var baston2: Staff
        beforeEach {
            baston1 = Staff(
                "baston1", 10, 10, 9
            )
            baston2 = Staff(
                "baston2", 10, 25, 20
            )
        }
        test("An Staff should be equal to itself") {
            baston1 shouldBeSameInstanceAs baston1
            baston1 shouldBe baston1
        }

        test("Two Staffs should be equal if their stats and their names are the same") {
            val baston3 = Staff(
                "baston1", 10, 10, 9
            )
            baston1 shouldNotBeSameInstanceAs baston3
            baston1 shouldBe baston3
            baston1 should haveSameHashCodeAs(baston3)
        }

        test("Two Staffs should be different if their stats are different") {
            baston1 shouldNotBe baston2
        }

        test("The string representation should be correct") {
            "$baston1" shouldBe "Staff { name: baston1, damage: 10, weight: 10, magicDamage: 9 }"
        }
    })
