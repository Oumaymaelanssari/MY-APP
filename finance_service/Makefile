NETWORK_NAME:=student_portal_network

docker-create-network:
	@if ! docker network ls --filter name=^$(NETWORK_NAME)$$ --format "{{ .Name }}" | grep -q $(NETWORK_NAME); then \
		docker network create $(NETWORK_NAME); \
	fi
	
up: docker-create-network
	docker compose up -d

down: docker-create-network
	docker compose down

clean: down ## clean build-related resources to start build from scratch
