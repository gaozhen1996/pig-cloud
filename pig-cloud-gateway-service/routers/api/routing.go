package api

import (
	"fmt"
	"net/http"
	"net/http/httputil"
	"net/url"

	"github.com/gaozhen1996/pig-cloud/pkg/logging"
	"github.com/gaozhen1996/pig-cloud/service"
	"github.com/gin-gonic/gin"
)

func Router(c *gin.Context) {
	target := service.GateWayRouter(c.Request.URL.Path)
	logging.Info(target)
	u, _ := url.Parse(c.Request.URL.String())

	var proxy = httputil.ReverseProxy{
		Director: func(req *http.Request) {
			req.URL.Scheme = "http"
			req.URL.Host = target.HostPort
			req.URL.RawQuery = u.RawQuery
			req.URL.Path = target.ResouceUrl
			req.Host = target.HostPort
			req.Header = c.Request.Header
		},
	}

	proxy.ErrorHandler = func(rw http.ResponseWriter, req *http.Request, err error) {
		ret := fmt.Sprintf("{\"code\":500,\"msg\":\"网关路由异常： %v\"}", err)
		logging.Info(ret)
		rw.WriteHeader(200)
		rw.Write([]byte(ret))
	}

	proxy.ServeHTTP(c.Writer, c.Request)

	c.Next()
}
