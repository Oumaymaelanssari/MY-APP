NETWORK_NAME:=student_portal_network

docker-create-network:
	@if ! docker network ls --filter name=^$(NETWORK_NAME)$$ --format "{{ .Name }}" | grep -q $(NETWORK_NAME); then \
		docker network create $(NETWORK_NAME); \
	fi

build-docker:
	# based on the note in SESC SCCTE Assessment Moderation and Brief 202324
	# clone repo (if not already cloned) -> update requirements.txt -> rebuild docker image locally
	# then local image is used in docker-compose.yaml
	echo -e "Rebuilding ces-books:4.0 docker image with up-to-date cs50 in requirments.txt"
	[ -d /tmp/CESBooks ] || git clone https://github.com/tvergilio/CESBooks /tmp/CESBooks
	cd /tmp/CESBooks && \
	sed -i 's/cs50~=8.0.0/cs50~=9.3.0/g' requirements.txt && \
	docker build --tag ces-books:4.0 .

up: build-docker docker-create-network
	docker compose up -d

down: docker-create-network
	docker compose down

clean: down ## clean build-related resources to start build from scratch
