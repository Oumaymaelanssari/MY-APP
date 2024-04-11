NETWORK_NAME:=student_portal_network

show-env: ## print build environment properties
	./gradlew --version
	java --version
	echo "JAVA_HOME: $(JAVA_HOME)"

build-jar:  ## build and run the application locally
	./gradlew bootJar

docker-create-network:
	@if ! docker network ls --filter name=^$(NETWORK_NAME)$$ --format "{{ .Name }}" | grep -q $(NETWORK_NAME); then \
		docker network create $(NETWORK_NAME); \
	fi
	
build-docker:
	docker build -t student-service-image:latest .

up: build-jar docker-create-network build-docker
	docker compose up -d

down: docker-create-network
	docker compose down

clean-docker:
	docker rmi student-service-image:latest || true

app-clean:
	rm -rf .gradle build
	./gradlew clean

clean: down clean-docker app-clean ## clean build-related resources to start build from scratch
