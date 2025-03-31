
# User Authentication

This project is an API made using **Java, Java Spring, My SQL with database, Spring Security and JWT for authentication control**.




## Installation

- Clone the repository

- Install dependences with maven

- Install mysql server





#### Get all Products

```http
  GET localhost:8080/products
```

| Parameter | Return     | Description                |
| :-------- | :------- | :------------------------- |
| `` | `List<Product>` | list the products in database// need a **user** access|

#### Post a new product

```http
  POST localhost:8080/products
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `product`      | `product` |saves a new product in the database// need a **admin** access |

#### User login

```http
  POST localhost:8080/auth/login
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username, password`      | `token` |logs in the user and returns a token// access for all |

#### User register

```http
  POST localhost:8080/auth/register
```

| Parameter | Return     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `username, password, role`      | `` |create a new user in database// need a **admin** access |


## Authors

- [@dmarqss](https://github.com/dmarqss)

