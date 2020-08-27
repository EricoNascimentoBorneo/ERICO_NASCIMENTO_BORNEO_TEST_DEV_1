package backend
import grails.transaction.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

class CompanyController {
    static responseFormats = ['json']

    def companyService  = new CompanyService()

    def getCompanies (){
        def retorno = companyService.getCompanies()
        respond retorno
    }
}
