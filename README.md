# microservices
spring boot microservices
| Service Type    | Service Name                   | Port Deployed |
| --------------- | ------------------------------ | ------------- |
|Master Service   |currency-conversion-calculator  | 8000          |
|Client Service   | currency-conversion            | 10000         |
|Eureka Server    | service-registry               | 12000         |
|Config Server    | config-server                  | 11000         |
|Api Gateway      | api-gateway                    | 13000         |


```sh
http://localhost:13000/calculate-currency-conversion/{from}/{to}/{quantity}
```
