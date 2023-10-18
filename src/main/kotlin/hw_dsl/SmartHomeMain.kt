package hw_dsl

class SmartHome() {
    var securitySystem: SecuritySystem? = null
    val rooms: MutableList<Room> = mutableListOf()

    fun room(name: String, init: Room.() -> Unit) {
        val _room = Room(name)
        _room.init()
        rooms.add(_room)
    }

    fun securitySystem(init: SecuritySystem.() -> Unit) {
        val _securitySystem = SecuritySystem()
        _securitySystem.init()
        securitySystem = _securitySystem
    }

    fun getConfig() = ""
}

class SecuritySystem(var status: String = "disabled", var mode: String = "") {
    fun enableSecurityMode(mode: String) {
        this.apply {
            this.mode = mode
            this.status = "enabled"
        }
    }

    fun getStatusOfsecuritySystem() = println("SecuritySystem = ${status}")


}

class Room(val name: String) {
    val devices: MutableList<Device> = mutableListOf()

    fun lights(name: String): Device {
        val _device = Device(name)
        devices.add(_device)
        return _device
    }

    fun tv(name: String): Device {
        val _device = Device(name)
        devices.add(_device)
        return _device
    }

    fun thermostat(name: String): Device {
        val _device = Device(name)
        devices.add(_device)
        return _device
    }
}


class Device(val name: String) {
    var status: String? = null
    var temperature: Int? = null
    var scheduleTurn: Int? = null
    fun turnOn() = this.apply { status = "On" }

    fun turnOff() = this.apply { status = "Off" }

    fun setTemperature(temperature: Int) = this.apply { this.temperature = temperature }
    fun scheduleTurnOff(time: Int) = this.apply { scheduleTurn = time }
}


fun smartHome(init: SmartHome.() -> Unit): SmartHome {
    val _smartHome = SmartHome()
    _smartHome.init()
    return _smartHome
}

fun main() {
    val myHome = smartHome {
        room("bedroom") {
            lights("mainLight").turnOn()
        }
    }

    val myHome2 = smartHome {
        room("bedroom") {
            thermostat("bedroomThermostat").setTemperature(22)
        }
    }

    val myHome3 = smartHome {
        securitySystem {
            enableSecurityMode("home")
        }
    }

    val myHome4 = smartHome {
        room("bathroom") {
            lights("bathroomLight").scheduleTurnOff(30)
        }
    }
    val securityStatus = smartHome {
        securitySystem {
            getStatusOfsecuritySystem()
        }
    }

    val currentConfiguration = smartHome {
        getConfig()
    }
    val myHomeFinal = smartHome {
        room("livingRoom") {
            lights("mainLight").turnOn()
            tv("tv").turnOn()
        }
        room("bedroom") {
            lights("bedroomLight").turnOff()
            thermostat("bedroomThermostat").setTemperature(22)

        }
        securitySystem {
            enableSecurityMode("home")
        }
    }
    print("lol")
}