# Database Term Project
### Contributers
* Komal Patel
* Shantisa Strowder
* Sabrina Hasnath


### Project Details
This project is about a  Brazilian ecommerce dataset, in which a user can interact with. 
The dataset contains information about 100,000 orders at multiple marketplaces over the course of 2 years in Brazil.
The dataset contains information regarding customers, 
sellers, products, reviews, and the location of both sellers and customers. 
We will use this data to find interesting relationships between the customer 
and sellers. These relationships can be anything from finding which products 
are selling better, how loyal customers are to sellers and how dependable sellers 
can be, whether good reviews correlate with sales and other kinds of 
fascinating facts that might help improve performance or inform customers.


### How to run this project
Run the python script provided in the project folder, titled 'python_script.py'. 
This script will create the database and install the data for the schema, "brazil_ecomm".
This process will take some time. After the data is finish installing, it will
run a pre-compiled jar file. Once the jar file is running, type "http://localhost:8080/" into your url. 
This will display the homepage of our web application. 

NOTE: All files needed to connect to the database in the project
folder are already set to the default credentials. Password and username are both set to 'root'. 

### To separately compile this project
Please follow these commands in order:
```
mvn clean install
mvn compile
./mvnw spring-boot:run
```
1. The first command will install all the necessary dependencies needed to build and run the project.
2. The second command will compile all the code and create executable files needed in order to run the program.
3. The third command will run the project over local host.

Copyright &copy; Komal Patel, Shantisa Strowder, and Sabrina Hasnath.

