/**
 * Интерфейс для поставщика
 * При помощи него поставщик взаимодействует со складом
 * Здесь можно определять только методы, общие для обоих поставщиков
 */
interface Supplier {
    val clientStorage: Storage
    val typeOfFurniture: List<String>
    val companyName: String

    fun getFurniture(){
        println("$typeOfFurniture")
    }

    fun addFurniture(itemToAdd: String){
        if (itemToAdd in typeOfFurniture) {
            clientStorage.stockRoom.add(itemToAdd)
        }
        else{
            println("Компания $companyName не поставляет $itemToAdd")
        }
    }

}

class Supplier2(x: List<String>, s: String, t: Storage) : Supplier {
    override val typeOfFurniture = x
    override val companyName = s
    override val clientStorage = t

    override fun toString(): String {
        return "$companyName поставляет $typeOfFurniture"
    }

    fun addNamedFurniture(name: String){
        clientStorage.stockRoom.add(typeOfFurniture[0] + " для $name от компании $companyName")
    }

}

class Supplier1(x: List<String>, s: String, t: Storage) : Supplier {
    override val typeOfFurniture = x
    override val companyName = s
    override val clientStorage = t

    override fun toString(): String {
        return "$companyName поставляет $typeOfFurniture"
    }
}