.PHONY: run test build

cross_build:
	rm -rdf build
	CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build  -o ./build/linux/$$(basename `pwd`) main.go
	CGO_ENABLED=0 GOOS=windows GOARCH=amd64 go build -o ./build/windows/$$(basename `pwd`).exe main.go
	go build -o ./build/mac/$$(basename `pwd`) main.go   

build:
	go build -o ./build/mac/$$(basename `pwd`) main.go   

wrun:
	watchexec -rce go "go run main.go"

run:
	go run main.go

test:
	go test


install:
	go install

profile:
	echo "wait for 10 secs"
	go tool pprof -http=:1234 http://localhost:8005/debug/pprof/profile\?seconds\=10

create_struct_from_json:
	mkdir model
	cat demo.json | gojson -name=Foo -pkg model > ./model/model.go

graph:
	go mod graph

show_dependency:
	go list -m all


show_updatable_dependency:
	go list -u -m all

update_all_dependency:
	go get -u

update_all_dependency_to_patch:
	go get -u=patch

clean_unused_dependency:
	go mod tidy

clean_mod_cache:
	go clean -modcache
