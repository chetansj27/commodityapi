# commodityapi

A simple REST API developed using spring boot.
In this we can get the montly price of 71 commodities of last 61 years.

## Code to get price of all commodities
```
https://csjcommodity.herokuapp.com/api/all
```
## Code to get price of all commodities from a particular range
```
https://csjcommodity.herokuapp.com/api/all?date=2020-08-01
```

## Code to get price of single commodity
```
https://csjcommodity.herokuapp.com/api/one?name=gold
```
## Code to get price of single commodity from a particular range
```
https://csjcommodity.herokuapp.com/api/one?date=2021-01-01&name=gold
```
## Code to get price of single commodity and sort the result according to price
```
https://csjcommodity.herokuapp.com/api/one?name=gold&sort=desc
```
<a href="https://docs.google.com/document/d/1fDyb4zAryFSzu6j3wqP__wpNpP7xKsFDxozczOYWQa0/edit?usp=sharing">Name of commodities</a>
      
We can also test the api.
## <a href="https://csjcommodity.herokuapp.com/swagger-ui.html">Try It</a>
