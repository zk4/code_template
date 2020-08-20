package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	_ "net/http/pprof"
	"os"

	"github.com/akamensky/argparse"
	"github.com/zk4/cmd/hello"
	"github.com/zk4/cmd/model"
)

func jsontest() {
	msg, err := ioutil.ReadFile("./demo.json")
	if err != nil {
		return
	}
	e := model.Foo{}
	if err := json.Unmarshal(msg, &e); err != nil {
		panic(err)
	}

	fmt.Println(e.Name)
}
func main() {

	jsontest()
	hello.Hello()

	go func() {
		log.Println(http.ListenAndServe("0.0.0.0:8005", nil))
	}()

	log.SetFlags(log.Ltime | log.Lshortfile)
	log.Println("hello,golang log")

	// Create new parser object
	parser := argparse.NewParser("print", "Prints provided string to stdout")
	// Create string flag
	s := parser.String("s", "string", &argparse.Options{Required: true, Help: "String to print"})
	// Parse input
	err := parser.Parse(os.Args)
	if err != nil {
		// In case of error print error and print usage
		// This can also be done by passing -h or --help flags
		log.Print(parser.Usage(err))
	}
	// Finally print the collected string
	log.Println(*s)
}
