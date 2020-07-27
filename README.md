# Shopping Cart Application

## Biblioteki wykorzystane przy budowie aplikacji:
- Spring Boot
- Hibernate
- MySQL

## Dostępne serwisy REST
- GET
- POST
- PUT
- DELETE

## Przykład POST
- http://localhost:8080/shopping-cart-app/orders
```json
{
    "product": {
        "id": 2
    },
    "quantity": 2,
    "order": {
        "id": 10,
        "firstName": "Grzegorz",
        "lastName": "W",
        "dateCreated": "27/07/2020",
        "status": "PAID"
    }
}
```
