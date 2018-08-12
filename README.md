#SRM

MUM's local grocery store, the Golden Dome Market (GDM), has hired you to design and develop a Supplier Relationship Management (SRM) system for them, which they will be using to manage the inventory (list) of Products that they stock, along with the various Suppliers who do supply them with the products. They want you to implement a basic web application for this purpose.

Here is the simple solution model for the system:

A Product is supplied by a Supplier.
And, a Supplier supplies one or many Products.

Here are the attributes for the 2 entities:

Product: productId:long, productNumber:long, name:String, unitPrice:double, quantityInStock:int, dateSupplied:date

Supplier: supplierId:int, supplierNumber:int,  name:String, contactPhoneNumber:String

For this question, you are expected to do the following:

1. Sketch a simple UML Static (class) model for the solution.

2. Using the tools, technologies and frameworks we have learnt about in this CS425 course, including Spring Web MVC, JPA, etc., implement a working web application for GDM. You may use any database of your choice.

You are expected to implement only the following use-cases:

1. Add a new Supplier (Allows the store manager to add a new Supplier into the system)
2. Display list of Suppliers (Allows the store manager to view a list of all the suppliers in the system)
3. Add a new Product (Allows the store manager to add a new Product into the system) 
4. Display list of Products (Allows the store manager to view a list of all the products in the system)

Shown below are sample User Interfaces for the use-cases. Note: Your own UI design does NOT have to look exactly like these samples. But your UIs should contain all the necessary data fields, as shown.
