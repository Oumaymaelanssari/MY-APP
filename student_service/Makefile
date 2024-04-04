show-env: ## print build environment properties
	./gradlew --version
	java --version
	echo "JAVA_HOME: $(JAVA_HOME)"

build-jar:  ## build and run the application locally
	./gradlew bootJar

build-docker:
	docker build -t student_service_image:latest .

up: build-jar build-docker
	docker compose up -d

down:
	docker compose down

clean-docker:
	docker rmi student_service_image:latest 

app-clean:
	rm -rf .gradle build
	./gradlew clean

clean: down clean-docker app-clean ## clean build-related resources to start build from scratch
