package backend

class CompanyService {

    List<Company> getCompanies ()
    {
        List<Company> retorno = []
        for(Company comp in Company.findAll())
        {
            List<Double> list = comp.stocks.collect{stock -> return stock.price}
            double size = list.size() as double
            double sum = list.sum() as double
            double mean = sum/size
            double stdev = list.collect{ num -> Math.pow((num - mean),2) }.sum() as double
            comp.standardDeviation = Math.sqrt(stdev/(size -1)) as BigDecimal
            retorno.add(comp)
        }
        return retorno
    }
}
