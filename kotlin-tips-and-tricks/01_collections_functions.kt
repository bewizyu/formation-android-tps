data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double) {
    override fun toString() = "'$name' for $price"
}

data class City(val name: String) {
    override fun toString() = name
}

// #################################
// TODO-1 : Implement extension functions
// Shop.getCitiesCustomersAreFrom() and
// Shop.getCustomersFrom() using functions map and filter.
//
// HINT :
//val numbers = listOf(1, -1, 2)
//numbers.filter { it > 0 } == listOf(1, 2)
//numbers.map { it * it } == listOf(1, 1, 4)


// Return the set of cities the customers are from
fun Shop.getCitiesCustomersAreFrom(): Set<City> = TODO()

// Return a list of the customers who live in the given city
fun Shop.getCustomersFrom(city: City): List<Customer> = TODO()


// #################################
// TODO-2 :  Implement all the functions below using all, any, count, find.
//
// HINT :
//val numbers = listOf(-1, 0, 2)
//val isZero: (Int) -> Boolean = { it == 0 }
//numbers.any(isZero) == true
//numbers.all(isZero) == false
//numbers.count(isZero) == 1
//numbers.find { it > 0 } == 2


// Return true if all customers are from the given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =  TODO()

// Return true if there is at least one customer from the given city
fun Shop.hasCustomerFrom(city: City): Boolean = TODO()

// Return the number of customers from the given city
fun Shop.countCustomersFrom(city: City): Int = TODO()

// Return a customer who lives in the given city, or null if there is none
fun Shop.findAnyCustomerFrom(city: City): Customer? = TODO()


// #################################
// TODO-3 :  Implement Shop.getCustomerWithMaximumNumberOfOrders() and Customer.getMostExpensiveOrderedProduct() using max, min, maxBy, or minBy.
//
// HINT :
// listOf(1, 42, 4).max() == 42
// listOf("a", "ab").minBy { it.length } == "a"


// Return a customer whose order count is the highest among all customers
fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? = TODO()

// Return the most expensive product which has been ordered
fun Customer.getMostExpensiveOrderedProduct(): Product? = TODO()


// #################################
// TODO-4 : Implement Shop.groupCustomersByCity() using groupBy.

// Return a map of the customers living in each city
fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = TODO()


// #################################
//TODO-5 : Implement Customer.getMostExpensiveDeliveredProduct() and Shop.getNumberOfTimesProductWasOrdered() 
// using functions from the Kotlin standard library.


// Return the most expensive product among all delivered products
// (use the Order.isDelivered flag)
fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // return TODO()
}

fun Customer.getOrderedProductsList(): List<Product> {
    // return TODO()
}

// Return how many times the given product was ordered.
// Note: a customer may order the same product for several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // return TODO()
}









fun main() {
    //products
    val idea = Product("IntelliJ IDEA Ultimate", 199.0)
    val reSharper = Product("ReSharper", 149.0)
    val dotTrace = Product("DotTrace", 159.0)
    val dotMemory = Product("DotTrace", 129.0)
    val phpStorm = Product("PhpStorm", 99.0)
    val rubyMine = Product("RubyMine", 99.0)
    val webStorm = Product("WebStorm", 49.0)

//customers
    val lucas = "Lucas"
    val cooper = "Cooper"
    val nathan = "Nathan"
    val reka = "Reka"
    val bajram = "Bajram"
    val asuka = "Asuka"
    val riku = "Riku"

//cities
    val Canberra = City("Canberra")
    val Vancouver = City("Vancouver")
    val Budapest = City("Budapest")
    val Ankara = City("Ankara")
    val Tokyo = City("Tokyo")

    fun customer(name: String, city: City, vararg orders: Order) =
        Customer(name, city, orders.toList())

    fun order(vararg products: Product, isDelivered: Boolean = true) =
        Order(products.toList(), isDelivered)

    fun shop(name: String, vararg customers: Customer) = Shop(name, customers.toList())

    val shop = shop(
        "jb test shop",
        customer(
            lucas, Canberra,
            order(reSharper),
            order(reSharper, dotMemory, dotTrace)
        ),
        customer(cooper, Canberra),
        customer(
            nathan, Vancouver,
            order(rubyMine, webStorm)
        ),
        customer(
            reka, Budapest,
            order(idea, isDelivered = false),
            order(idea, isDelivered = false),
            order(idea)
        ),
        customer(
            bajram, Ankara,
            order(reSharper)
        ),
        customer(
            asuka, Tokyo,
            order(idea)
        ),
        customer(
            riku, Tokyo,
            order(phpStorm, phpStorm),
            order(phpStorm)
        )

    )

    val customers: Map<String, Customer> = shop.customers.fold(hashMapOf<String, Customer>(), {
            map, customer ->
        map[customer.name] = customer
        map
    })

    val orderedProducts = setOf(idea, reSharper, dotTrace, dotMemory, rubyMine, webStorm, phpStorm)

    val sortedCustomers = listOf(cooper, nathan, bajram, asuka, lucas, riku, reka).map { customers[it] }

    val groupedByCities = mapOf(
        Canberra to listOf(lucas, cooper),
        Vancouver to listOf(nathan),
        Budapest to listOf(reka),
        Ankara to listOf(bajram),
        Tokyo to listOf(asuka, riku)
    ).mapValues { it.value.map { name -> customers[name] } }



    try {
        println("shop.getCitiesCustomersAreFrom()")
        println("ANSWER => " + shop.getCitiesCustomersAreFrom())
        println("CORRECT ANSWER => " + setOf(Canberra, Vancouver, Budapest, Ankara, Tokyo))
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()

    try {
        println("shop.getCustomersFrom(Canberra)")
        println("ANSWER => " + shop.getCustomersFrom(Canberra))
        println("CORRECT ANSWER => " + listOf(customers["Lucas"], customers["Cooper"]))

    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()

    try {
        println("shop.checkAllCustomersAreFrom(Canberra)")
        println("ANSWER => " + shop.checkAllCustomersAreFrom(Canberra))
        println("CORRECT ANSWER => FALSE")

    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()

    try {
        println("shop.hasCustomerFrom(Canberra)")
        println("ANSWER => " + shop.hasCustomerFrom(Canberra))
        println("CORRECT ANSWER => TRUE")
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")

    }

    println()

    try {
        println("shop.countCustomersFrom(Canberra)")
        println("ANSWER => " + shop.countCustomersFrom(Canberra))
        println("CORRECT ANSWER => 2")
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")

    }

    println()

    try {
        println("shop.findAnyCustomerFrom(Canberra)")
        println("ANSWER => " + shop.findAnyCustomerFrom(Canberra))
        println("CORRECT ANSWER => $lucas")
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()

    try {
        println("shop.getCustomerWithMaximumNumberOfOrders()")
        println("ANSWER => " + shop.getCustomerWithMaximumNumberOfOrders())
        println("CORRECT ANSWER => " + customers["Reka"])
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()

    try {
        println("customer.getMostExpensiveOrderedProduct()")
        println("ANSWER => " + shop.customers[0].getMostExpensiveOrderedProduct())
        println("CORRECT ANSWER => $dotTrace")
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()

    try {
        println("shop.groupCustomersByCity()")
        println("ANSWER => " + shop.groupCustomersByCity())
        println("CORRECT ANSWER => $groupedByCities")
        println(customers)
    } catch (err: NotImplementedError) {
        println("NOT IMPLEMENTED")
    }

    println()


}

