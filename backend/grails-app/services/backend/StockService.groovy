package backend

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import groovy.time.*

class StockService {

    void getStocks(String company, int numbersOfHoursUntilNow) 
    {
        def timeStart = new Date()
        int quantStocks=0
        Date now = new Date()
        
        for (Stock stock in Stock.where{company.name == company})
        {
                TimeDuration duration = TimeCategory.minus(now, stock.priceDate)
                double diferencaHoras = TimeUnit.MILLISECONDS.toHours(duration.toMilliseconds())
                if(diferencaHoras<=numbersOfHoursUntilNow)
                {
                    println("Stock Quote: " + new SimpleDateFormat("dd/MM/yyyy HH:mm").format(stock.priceDate) + " Price: R\$ " + String.format("%.2f",stock.price))
                    quantStocks++
                }
        }

        def timeStop = new Date()
        
        TimeDuration duration = TimeCategory.minus(timeStop, timeStart)
        println("Duration: " + duration.toMilliseconds() +" ms")
        println("Total Stocks: " + quantStocks)

    }
    
}
