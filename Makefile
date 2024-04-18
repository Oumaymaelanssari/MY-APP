NETWORK_NAME:=student_portal_network

install-docker:  # install docker on ubuntu
	echo "Installing docker"
	curl -fsSL https://get.docker.com -o get-docker.sh && sudo sh get-docker.sh
	sudo usermod -aG docker $(USER)
	docker --version
	echo "docker install successfully"

install-java:  # install java 11 and JDK on ubuntu
	echo "Installing java"
	sudo apt install openjdk-11-jdk -y
	sudo update-alternatives --set java /usr/lib/jvm/java-11-openjdk-amd64/bin/java
	java --version
	echo "export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64" >> $(HOME)/.bashrc
	echo "java install successfully"

install-system-deps: install-docker install-java

docker-create-network:
	@if ! docker network ls --filter name=^$(NETWORK_NAME)$$ --format "{{ .Name }}" | grep -q $(NETWORK_NAME); then \
		docker network create $(NETWORK_NAME); \
	fi

up-student:  ## make student microservice up and running
	make -C student_service up

down-student: ## stop student microservice down
	make -C student_service clean

up-finance: ## make finance microservice up and running
	make -C finance_service up

down-finance: ## stop student microservice
	make -C finance_service down

up-library: ## make library microservice up and running
	make -C library_service up

down-library: ## stop student microservice
	make -C library_service down
	
up: docker-create-network ## make app (all microservices) up and running 
	make up-finance
	make up-library
	make up-student

clean: ## clean app - remove microservices and temporary files to rebuild them from scratch
	make down-finance
	make down-library
	make down-student

down: clean ## stop app (all microservices)

apply-migrations: ## insert initial data into microservices databases
	make -C student_service apply-migrations

run-tests: ## run tests of microservices
	make -C student_service run-tests

test-report: run-tests ## open test report after running tests
	make -C student_service test-report
