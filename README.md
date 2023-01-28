## Redis Spring Boot

hostname | port
------------- | -------------
springboot | 8081
redis | 6366

endpoint  | method | auth | request body
------------- | ------------- | ------------- | -------------
http://localhost:8081/api/v2/auth/login | POST | - | {"password":"password","phone":"08123456789"}
http://localhost:8081/books | GET | Bearer Token | 
http://localhost:8081/books/:id | GET | Bearer Token | 
http://localhost:8081/books | POST | Bearer Token | {"id":1,"isbn":"123123123","judul":"Buku baru","penulis":"Hendra","deskripsi":"Deskripsi buku","kategori":"Novel"}
http://localhost:8081/books/:id | PUT | Bearer Token | {"isbn":"123123123","judul":"Buku baru","penulis":"Hendra","deskripsi":"Deskripsi buku","kategori":"Novel"}
http://localhost:8081/books/:id | DELETE | Bearer Token | 
