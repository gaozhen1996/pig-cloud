package main

import (
	"fmt"
	"net/http"

	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	"github.com/gaozhen1996/pig-cloud/routers"
)

func main() {
	start()
	// fmt.Printf("%d\n", 1%1)
}

func start() {
	router := routers.InitRouter()
	s := &http.Server{
		Addr:           fmt.Sprintf(":%d", setting.HTTPPort),
		Handler:        router,
		ReadTimeout:    setting.ReadTimeout,
		WriteTimeout:   setting.WriteTimeout,
		MaxHeaderBytes: 1 << 20,
	}

	s.ListenAndServe()
}
