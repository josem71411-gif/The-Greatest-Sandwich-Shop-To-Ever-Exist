# The Greatest Sandwich Shop to Ever Exist

## Overview

The Greatest Sandwich Shop to Ever Exist is a Java-based Point of Sale (POS) application that allows customers to create fully customizable sandwich orders. Customers can add sandwiches, drinks, and chips, customize toppings, review their order, and generate receipts that are saved for future viewing.

This project was built using Object-Oriented Programming (OOP) principles including encapsulation, inheritance, abstraction, interfaces, and polymorphism.

---

## Features

### Home Screen

* Create a New Order
* View Previous Receipts
* Exit Application

### Order Screen

* Add Sandwich
* Add Drink
* Add Chips
* Checkout
* Cancel Order

### Sandwich Customization

#### Bread Options

* White
* Wheat
* Rye
* Wrap

#### Sandwich Sizes

* 4 Inch
* 8 Inch
* 12 Inch

#### Premium Toppings

##### Meats

* Steak
* Ham
* Salami
* Roast Beef
* Chicken
* Bacon

##### Cheeses

* American
* Provolone
* Cheddar
* Swiss

Customers may add extra meat and extra cheese for an additional charge.

#### Regular Toppings

* Lettuce
* Peppers
* Onions
* Tomatoes
* Jalapeños
* Cucumbers
* Pickles
* Guacamole
* Mushrooms

#### Sauces

* Mayo
* Mustard
* Ketchup
* Ranch
* Thousand Islands
* Vinaigrette

#### Sides

* Au Jus
* Sauce

#### Toasted Option

Customers may choose whether their sandwich is toasted.

---

## Pricing

### Sandwich Base Prices

| Size | Price |
| ---- | ----- |
| 4"   | $5.50 |
| 8"   | $7.00 |
| 12"  | $8.50 |

### Meat Prices

| Size | Price |
| ---- | ----- |
| 4"   | $1.00 |
| 8"   | $2.00 |
| 12"  | $3.00 |

### Extra Meat

| Size | Price |
| ---- | ----- |
| 4"   | $0.50 |
| 8"   | $1.00 |
| 12"  | $1.50 |

### Cheese Prices

| Size | Price |
| ---- | ----- |
| 4"   | $0.75 |
| 8"   | $1.50 |
| 12"  | $2.25 |

### Extra Cheese

| Size | Price |
| ---- | ----- |
| 4"   | $0.30 |
| 8"   | $0.60 |
| 12"  | $0.90 |

### Drinks

| Size   | Price |
| ------ | ----- |
| Small  | $2.00 |
| Medium | $2.50 |
| Large  | $3.00 |

### Chips

| Item  | Price |
| ----- | ----- |
| Chips | $1.50 |

---

## Technologies Used

* Java
* IntelliJ IDEA
* Object-Oriented Programming (OOP)
* Java Collections Framework
* File I/O
* LocalDateTime
* Scanner

---

## Project Structure

```text
com.pluralsight.shop
│
├── Program
│
├── filemanagement
│   └── ReceiptFileManager
│
├── models
│   ├── Chip
│   ├── Drink
│   ├── Order
│   ├── OrderItem
│   └── Sandwich
│
├── toppings
│   ├── Cheese
│   ├── Meat
│   ├── RegularTopping
│   ├── Sauce
│   ├── Side
│   └── Topping
│
└── ui
    └── UserInterface
```

---

## OOP Concepts Demonstrated

### Encapsulation

Private fields and public methods are used throughout the application.

### Inheritance

The abstract `Topping` class serves as the parent class for:

* Meat
* Cheese
* RegularTopping
* Sauce
* Side

### Abstraction

`Topping` is implemented as an abstract class.

### Interfaces

`OrderItem` is implemented by:

* Sandwich
* Drink
* Chip

### Polymorphism

Orders store different item types using:

```java
ArrayList<OrderItem>
```

This allows sandwiches, drinks, and chips to be handled uniformly when calculating totals and displaying receipts.

---

## Receipt Storage

When an order is completed:

1. A receipt is generated.
2. The receipt is saved in the `receipts` folder.
3. The filename is automatically created using the date and time of the order.

Example:

```text
20260529-143522.txt
```

Users can also browse and view previously saved receipts through the **View Receipts** menu option.

---

## Future Improvements

* Receipt searching by date
* Receipt deletion/refunds
* Receipt sorting by newest first
* GUI version using JavaFX or Swing
* Online ordering support
* Inventory tracking
* Employee login system

---

## Author

Jose Martinez

Created as a Java Object-Oriented Programming project demonstrating interfaces, inheritance, abstraction, polymorphism, collections, and file management.


![mermaid-diagram (2).png](mermaid-diagram%20%282%29.png)
