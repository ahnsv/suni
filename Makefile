local-server-build:
	./gradlew bootJar && docker build --build-arg JAR_FILE=build/libs/*.jar -t suni .

local-server-run:
	 docker run --rm -p 18080:18080 --rm suni

local-server-restart: local-server-build local-server-run

local-cluster-start:
	docker-compose -f compose/docker-compose.dev.yml -p local-cluster up -d