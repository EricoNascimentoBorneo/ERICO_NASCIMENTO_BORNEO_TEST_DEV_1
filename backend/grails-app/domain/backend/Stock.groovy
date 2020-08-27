package backend

class Stock {

    double price
    Date priceDate
    static belongsTo = [company:Company]

    static constraints = {
    }
    
}
