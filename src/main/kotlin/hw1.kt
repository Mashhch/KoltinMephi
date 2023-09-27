interface motor {
    abstract val typeOfMotor: String
    abstract val power: Double
    fun getInfoMotor() {
        println("type of motor: $typeOfMotor")
        println("power of motor: $power")
    }
}

sealed class transport(val speed: Double) : motor {
    abstract val numberOfWheels: Int
    abstract val numberOfPassengers: Int
    open fun getInfo() {
        soundOfSignal(this)
        getInfoMotor()
        println("number of wheels: $numberOfWheels")
        println("number of passengers: $numberOfPassengers")
        println("speed: $speed")
    }

    class bike(speed: Double) : transport(speed) {
        override val numberOfWheels: Int = 2
        override val numberOfPassengers: Int = 2
        override val typeOfMotor: String
            get() = "type1"
        override val power: Double
            get() = 1.0

        override fun getInfo() {
            super.getInfo()
        }
    }

    class auto(speed: Double) : transport(speed) {
        override val numberOfWheels: Int = 4
        override val numberOfPassengers: Int = 5
        override val typeOfMotor: String
            get() = "type2"
        override val power: Double
            get() = 2.0

        override fun getInfo() {
            super.getInfo()
            println("number of wheels: $numberOfWheels")
            println("number of passengers: $numberOfPassengers")
        }

    }

    class bus(speed: Double) : transport(speed) {

        override val numberOfWheels: Int = 4
        override val numberOfPassengers: Int = 50
        private var conductor = false
        override val typeOfMotor: String
            get() = "type3"
        override val power: Double
            get() = 3.0

        fun hasConductor(has: Boolean) {
            conductor = has
        }

        override fun getInfo() {
            super.getInfo()
            println("number of wheels: $numberOfWheels")
            println("number of passengers: $numberOfPassengers")
            println("Has conductor: $conductor")
        }
    }

    open class train(val numberOfCarrige: Int, speed: Double) : transport(speed) {

        var numberOfConductors: Int = 2
        override val numberOfWheels: Int = numberOfCarrige * 8
        override val numberOfPassengers: Int = numberOfCarrige * 54
        override val typeOfMotor: String
            get() = "type4"
        override val power: Double
            get() = 4.0

        fun changeNumberOfConductor(number: Int) {
            numberOfConductors = number
        }

        override fun getInfo() {
            super.getInfo()
            println("number of wheels: $numberOfWheels")
            println("number of passengers: $numberOfPassengers")
            println("number of conductors: $numberOfConductors")
            println("number of carrige: $numberOfCarrige")
        }
    }

    fun soundOfSignal(tran: transport) = when (tran) {
        is auto -> println("bip")
        is bike -> println("dzin")
        is bus -> println("tutu")
        is train -> println("tuuuuutuuuuu")
    }

    fun NumberOfWheels() {
        println("Number of wheels is $numberOfWheels")
    }
}


class lastochka(numberOfConductor: Int, numberOfCarrige: Int, speed: Double) : transport.train(
    numberOfCarrige,
    speed
) {
    fun hello() {
        println("this is lastochka!")
    }

    override val typeOfMotor: String
        get() = "type5"
    override val power: Double
        get() = 5.0

    override fun getInfo() {
        hello()
        super.getInfo()
    }
}

fun myinterface() {
    while (true) {
        println()
        println("transport: 1-auto, 2-train, 3-lastochka, 4-bike and 5-bus, 6-exit")
        println("select 1-6")
        when (readln()) {
            "1" -> {
                println("enter speed:")
                while (true) {
                    var input = readln()
                    if (input.toDoubleOrNull() == null) {
                        println("it's not number! enter again")
                        continue
                    } else {
                        val auto = transport.auto(input.toDouble())
                        auto.getInfo()
                        break
                    }
                }
            }

            "2" -> {
                val speed: Double
                println("enter speed:")
                while (true) {
                    val input = readln().toDoubleOrNull()
                    if (input == null) {
                        println("it's not number! enter again")
                        continue
                    } else {
                        speed = input
                        break
                    }
                }
                println("enter number Of Carrige")
                while (true) {
                    val input = readln().toIntOrNull()
                    if (input == null) {
                        println("it's not number! enter again")
                        continue
                    } else {
                        val train = transport.train(input, speed)
                        train.getInfo()
                        break
                    }
                }
            }

            "3" -> {
                val speed: Double
                println("enter speed:")
                while (true) {
                    val input = readln().toDoubleOrNull()
                    if (input == null) {
                        println("it's not number! enter again")
                        continue
                    } else {
                        speed = input
                        break
                    }
                }
                println("enter number Of Carrige")
                while (true) {
                    val input = readln().toIntOrNull()
                    if (input == null) {
                        print("it's not number! enter again")
                        continue
                    } else {
                        val train = transport.train(input, speed)

                    }
                }
            }

            "4" -> {
                println("enter speed:")
                while (true) {
                    var input = readln()
                    if (input.toDoubleOrNull() == null) {
                        println("it's not number! enter again")
                        continue
                    } else {
                        val bike = transport.bike(input.toDouble())
                        bike.getInfo()
                        break
                    }
                }
            }

            "5" -> {
                println("enter speed:")
                while (true) {
                    var input = readln()
                    if (input.toDoubleOrNull() == null) {
                        println("it's not number! enter again")
                        continue
                    } else {
                        val bus = transport.bus(input.toDouble())
                        bus.getInfo()
                        break
                    }
                }
            }

            "6" -> return
        }
    }
}

    fun main() {
        myinterface()
//        val train = transport.train(5, 4, 200.04)
//        train.getInfo()
//        val lastochka = lastochka(3, 10, 333.90)
//        lastochka.getInfo()
    }



