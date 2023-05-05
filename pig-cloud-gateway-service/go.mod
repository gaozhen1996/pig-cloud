module github.com/gaozhen1996/pig-cloud

go 1.14

require (
	github.com/StackExchange/wmi v1.2.1 // indirect
	github.com/alibaba/sentinel-golang v1.0.2
	github.com/dgrijalva/jwt-go v3.2.0+incompatible
	github.com/gin-gonic/gin v1.9.0
	github.com/go-ini/ini v1.62.0
	github.com/go-sql-driver/mysql v1.6.0 // indirect
	github.com/gopherjs/gopherjs v0.0.0-20181103185306-d547d1d9531e // indirect
	github.com/hashicorp/consul/api v1.8.1
	github.com/hashicorp/golang-lru v0.5.4 // indirect
	github.com/jinzhu/gorm v1.9.16
	github.com/lib/pq v1.2.0 // indirect
	github.com/mattn/go-sqlite3 v2.0.3+incompatible // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/smartystreets/assertions v0.0.0-20190116191733-b6c0e53d7304 // indirect
	github.com/smartystreets/goconvey v0.0.0-20190731233626-505e41936337 // indirect
	golang.org/x/xerrors v0.0.0-20200804184101-5ec99f83aff1 // indirect
	gopkg.in/ini.v1 v1.47.0 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
)

replace (
	github.com/gaozhen1996/pig-cloud/conf => ~/userapp/go/src/pig-cloud/pkg/conf v1.0.0
	github.com/gaozhen1996/pig-cloud/middleware => ~/userapp/go/src/pig-cloud/middleware v1.0.0
	github.com/gaozhen1996/pig-cloud/models => ~/userapp/go/src/pig-cloud/models v1.0.0
	github.com/gaozhen1996/pig-cloud/pkg/e => ~/userapp/go/src/pig-cloud/pkg/e v1.0.0
	github.com/gaozhen1996/pig-cloud/pkg/setting => ~/userapp/go/src/pig-cloud/pkg/setting v1.0.0
	github.com/gaozhen1996/pig-cloud/routers => ~/userapp/go/src/pig-cloud/routers v1.0.0
	github.com/gaozhen1996/pig-cloud/routers/api => ~/userapp/go/src/pig-cloud/routers/api v1.0.0
	github.com/gaozhen1996/pig-cloud/service => ~/userapp/go/src/pig-cloud/service v1.0.0
)
