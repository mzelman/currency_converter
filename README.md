# Currency converter

App available [here]([currencyconverter-production.up.railway.app](https://currencyconverter-production.up.railway.app/) "Currency converter").

The project allows to convert currencies (USD, EUR, CHF, GBP, JPY, TRY) to PLN. 
The data about exchange rates is collected from [NBP Web API]( http://api.nbp.pl/ "NBP Web API") 
and updated every work day at noon and 1pm (NBP provides data every work day around 11.45 to 12.15).
The result is rounded to 2 decimal places.

## Built with
- Java version 17
- Apache Maven 4.0.0
- Spring Boot 2.7.8

## Running

Go to **/currency-converter** directory and run:

```bash
mvn clean spring-boot:run
```
