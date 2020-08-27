package backend

class Company {

    String name
    String segment
    BigDecimal standardDeviation
    static hasMany = [stocks:Stock]
    static mappping = {
        stocks cascade: 'all-delete-orphan'
    }

    static constraints = {
    }
}
