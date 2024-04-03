install-docker:
	echo "Installing docker"
	curl -fsSL https://get.docker.com -o get-docker.sh && sudo sh get-docker.sh
	sudo usermod -aG docker $(USER)
	docker --version
	echo "docker install successfully"

install-java:
	echo "Installing java"
	sudo apt install openjdk-11-jdk -y
	sudo update-alternatives --set java /usr/lib/jvm/java-11-openjdk-amd64/bin/java
	java --version
	echo "export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64" >> $(HOME)/.bashrc
	echo "java install successfully"

install-system-deps: install-docker install-java

make up:
	make -C student_service up
