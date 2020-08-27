package backend

class BootStrap {

    def init = { servletContext ->

        def comps = []
        Company tesla = new Company(name:'Tesla',segment:'automotiva',standardDeviation:0).save() 
        comps.add(tesla)
        Company cdProjekt = new Company(name:'CD Projekt',segment:'jogos eletrônicos',standardDeviation:0).save() 
        comps.add(cdProjekt)
        Company netflix = new Company(name:'Netflix',segment:'streaming',standardDeviation:0).save() 
        comps.add(netflix)

        for(Company comp in comps)
        {
            int dias =30

            while (dias>0)
            {
                int horas = 8

                while(horas>0)
                {
                    int minutos=60

                    while(minutos>=0)
                    {
                        Calendar calendar = Calendar.getInstance(); // this would default to now
                        int stockDia = 30 - dias
                        calendar.add(Calendar.DAY_OF_MONTH, -stockDia)
                        int stockHora = 18 - horas
                        int stockMinuto = 60 - minutos
                        calendar.set(Calendar.HOUR_OF_DAY, stockHora)
                        calendar.set(Calendar.MINUTE, stockMinuto)
                        calendar.set(Calendar.SECOND, 0)
                        
                        Stock stock = new Stock(price: 50,priceDate:calendar.getTime())
                        comp.addToStocks(stock)
                        stock.company = comp
                        stock.save()

                        minutos--
                    }

                    horas--
                }

                dias--
            }
            comp.save()
           
        }

        


    }
    def destroy = {
    }
}
