## Project template generation - used Spring Initializer

StudentPortal microservice template has been initialized using https://start.spring.io/. 

Following config and dependencies has been selected.

![Spring Initializer Configuration](./docs/spring_initializer.png)

Generate sources has been unzipped to `student_service` directory before
starting development.

### System requirements

Requirements:

* java 11
* docker

On Ubuntu OS, you can install below deps using command: 
```
make install-system-deps && source $HOME/.bashrc
```
On other OSes you need to install it manually other way before working with
this application.

### Getting started

## Quick start

Run all docker containers of the application using command:
```
make up
```

Make sure application is up and running using command:
```
docker ps
```
If application is up-and-running you should see following docker containers:
![Application containers](./docs/containers.png)

If you see **ALL** the above containers up-and-running open your web browser with this
URL: 

* **student_service** - [http://localhost:8080](http://localhost:8080)
* **finance_service** - [http://localhost:8081](http://localhost:8081)
* **library_service** - [http://localhost:8082](http://localhost:8082)

### Student service

Open **[http://localhost:8080](http://localhost:8080)** in your web browser

You should see login page. You can login into the application using
credentials:

* username: 'user'
* passoword: use `docker logs student_service | grep password` command to get autogenerated password

### Finance service

Open **[http://localhost:8081](http://localhost:8081)** in your web browser

You should see invoices search page. 
You can search invoice by it's reference. Sample invoice references you an find
in [./finance_service/migrations/mysql-migrations.sql](./finance_service/migrations/mysql-migrations.sql)

* type sample invoice reference: 'ABCD1234'
* click 'Find Invoice' 
* click 'Pay Invoice'
* search invoice again and see status of the invoice is 'Paid' 

### Library service

Open **[http://localhost:8082](http://localhost:8082)** in your web browser

You should see login page. You can login into the application using
credentials:

* create new student id using this command as described [here](https://github.com/tvergilio/CESBooks?tab=readme-ov-file#api):
```
curl -X POST http://localhost:8082/api/register -H "Content-Type: application/json" -d '{ "studentId": "c1234567" }'
```
* student id: 'c1234567'
* PIN: 000000

If you logged in properly you should see the library_service home page like this one:

![library_service home page](./docs/library_service_home_page.png)


## Using portal

If you see the above 6 containers up and running it means your application is
running properly. You can start to use it.

### Register user

* open register form: [http://localhost:8080/register](http://localhost:8080/register)
* register your user
* you should be redirected to login page

### Login registered user

* open register form: [http://localhost:8080/login](http://localhost:8080/login)
* login registered user
* you should be redirected to welcome home page
