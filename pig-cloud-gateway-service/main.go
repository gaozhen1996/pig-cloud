package main

import (
	"fmt"
	"net/http"

	"github.com/gaozhen1996/pig-cloud/middleware/regiscenter"
	"github.com/gaozhen1996/pig-cloud/pkg/setting"
	"github.com/gaozhen1996/pig-cloud/routers"
)

func main() {
	start()
}

func start() {
	//注册中心注册
	regiscenter.RegisterServer()

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
