show-env: ## print build environment properties
	./gradlew --version
	java --version
	echo "JAVA_HOME: $(JAVA_HOME)"

build-jar:  ## build and run the application locally
	./gradlew bootJar

up: build-jar
	docker compose up -d

down:
	docker compose down

run: build-jar up

app-clean:
	rm -rf .gradle build
	./gradlew clean

clean: down app-clean ## clean build-related resources to start build from scratch
