## Redis Spring Boot

hostname | port
------------- | -------------
http://54.249.152.230 | 8080

endpoint  | method | auth | request body
------------- | ------------- | ------------- | -------------
http://54.249.152.230:8080/api/v2/auth/login | POST | - | {"password":"password","phone":"08123456789"}
http://54.249.152.230:8080/api/v2/users | GET | Bearer Token | 
http://54.249.152.230:8080/api/v2/users/:id | GET | Bearer Token | 
http://54.249.152.230:8080/api/v2/users | POST | Bearer Token | {"name":"riko","email":"hendra@gmail.com","phone":"0891234567","password":"password"}
http://localhost:8081/books/:id | PUT | Bearer Token | {"id": 5,"name":"riko","email":"hendra@gmail.com","phone":"123123123","password":"password"}
http://54.249.152.230:8080/api/v2/users/:id | DELETE | Bearer Token | 
