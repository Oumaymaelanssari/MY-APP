# include env vars from .env file
include .env
export 

NETWORK_NAME:=student_portal_network

build-jar:  ## build and run the application locally
	./gradlew bootJar

docker-create-network:  ## create docker network (if not alrady created), so the microservices to communicate
	@if ! docker network ls --filter name=^$(NETWORK_NAME)$$ --format "{{ .Name }}" | grep -q $(NETWORK_NAME); then \
		docker network create $(NETWORK_NAME); \
	fi
	
build-docker:  ## build docker image
	docker build -t student-service-image:latest .

up: build-jar docker-create-network build-docker  ## run service and it's database using docker compose
	docker compose up -d
	# applying migrations
	make apply-migrations

down: docker-create-network ## stop service and it's database using docker compose
	docker compose down

clean-docker:  ## remove old version of docker image
	docker rmi student-service-image:latest || true

app-clean:  ## clean temporary service resources so service can be rebuild from scratch
	rm -rf .gradle build
	./gradlew clean

apply-migrations:  ## apply database migrations
	# waiting for app to start and insert data to the 'student' db (courses, students etc.)
	@sleep 10
	docker exec -i student-service-db psql -U $(STUDENT_DB_USER) -d $(STUDENT_DB_NAME) -f - < ./migrations/insert_data.sql > /dev/null

clean: down clean-docker app-clean ## clean build-related resources to start build from scratch

run-tests: ## run tests (unit tests, functional tests, integration tests)
	./gradlew test

test-report:
	open build/reports/tests/test/index.html

