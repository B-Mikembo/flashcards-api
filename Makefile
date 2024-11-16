SHELL := /bin/bash
.PHONY: test install run help

test:
	@mvn clean verify

run-api:
	@mvn clean spring-boot:run

release: ## create release
	./scripts/create_release.sh

hotfix: ## create hotfix
	./scripts/create_hotfix.sh