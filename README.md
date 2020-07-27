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
        "id": 1
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
## Przykład odpowiedzi GET
- http://localhost:8080/shopping-cart-app/orders
```json
[
    {
        "orderProducts": [
            {
                "quantity": 2,
                "product": {
                    "id": 1,
                    "name": "TV",
                    "price": 1800.0,
                    "description": "FHD IPS"
                },
                "totalPrice": 3600.0
            },
            {
                "quantity": 2,
                "product": {
                    "id": 2,
                    "name": "PC",
                    "price": 2000.0,
                    "description": "IPS"
                },
                "totalPrice": 4000.0
            }
        ],
        "id": 1,
        "firstName": "Grzegorz",
        "lastName": "W",
        "dateCreated": "27/07/2020",
        "status": "PAID",
        "totalOrderPrice": 7600.0,
        "numberOfProducts": 2
    },
'''
