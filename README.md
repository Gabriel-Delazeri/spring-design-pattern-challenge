
# Spring Design Patterns Challenge

That project refers to the Design Patterns project challenge proposed in the Java Bootcamp promoted by Santander and DIO in 2023.

The challenge consists in develop an api and apply design patterns in the code.

For the api, i decided to do a simple api who simulate orders administration.

In the first moment i decided to use the Strategy Pattern, present in the services implementations and the Observer pattern, present in the process of manage the entity Order, that when the status is updated, reflets in the StatusHistoric entity too.

## API Docs

#### Create Order

```http
  POST /api/orders
```

| Parameter   | Type      | Description                           |
| :---------- | :--------- | :---------------------------------- |
| `amount` | `number` | **obrigatory** |
| `Description` | `text` | **obrigatory** |

#### Complete order

```http
  put /api/orders/${id}/complete
```

| Paramater   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **obrigatory** |

#### Cancel order

```http
  put /api/orders/${id}/cancel
```

| Paramater   | Type       | Description                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | **obrigatory** |
