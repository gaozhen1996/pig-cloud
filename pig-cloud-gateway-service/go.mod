module github.com/gaozhen1996/pig-cloud

go 1.14

require (
	github.com/dgrijalva/jwt-go v3.2.0+incompatible
	github.com/gin-gonic/gin v1.7.1
	github.com/go-ini/ini v1.62.0
	github.com/go-playground/validator/v10 v10.6.0 // indirect
	github.com/go-sql-driver/mysql v1.6.0 // indirect
	github.com/golang/protobuf v1.5.2 // indirect
	github.com/gopherjs/gopherjs v0.0.0-20181103185306-d547d1d9531e // indirect
	github.com/hashicorp/consul/api v1.8.1
	github.com/hashicorp/golang-lru v0.5.4 // indirect
	github.com/jinzhu/gorm v1.9.16
	github.com/json-iterator/go v1.1.11 // indirect
	github.com/kr/text v0.2.0 // indirect
	github.com/leodido/go-urn v1.2.1 // indirect
	github.com/lib/pq v1.2.0 // indirect
	github.com/mattn/go-sqlite3 v2.0.3+incompatible // indirect
	github.com/modern-go/concurrent v0.0.0-20180306012644-bacd9c7ef1dd // indirect
	github.com/modern-go/reflect2 v1.0.1 // indirect
	github.com/niemeyer/pretty v0.0.0-20200227124842-a10e7caefd8e // indirect
	github.com/pkg/errors v0.9.1 // indirect
	github.com/smartystreets/assertions v0.0.0-20190116191733-b6c0e53d7304 // indirect
	github.com/smartystreets/goconvey v0.0.0-20190731233626-505e41936337 // indirect
	github.com/ugorji/go v1.2.5 // indirect
	golang.org/x/crypto v0.0.0-20210506145944-38f3c27a63bf // indirect
	golang.org/x/net v0.0.0-20210508051633-16afe75a6701 // indirect
	golang.org/x/sync v0.0.0-20201020160332-67f06af15bc9 // indirect
	golang.org/x/sys v0.0.0-20210507161434-a76c4d0a0096 // indirect
	golang.org/x/xerrors v0.0.0-20200804184101-5ec99f83aff1 // indirect
	gopkg.in/check.v1 v1.0.0-20200227125254-8fa46927fb4f // indirect
	gopkg.in/ini.v1 v1.47.0 // indirect
	gopkg.in/yaml.v2 v2.4.0 // indirect
	gopkg.in/yaml.v3 v3.0.0-20200615113413-eeeca48fe776 // indirect
)

replace (
	github.com/gaozhen1996/pig-cloud/conf => ~/userapp/go/src/pig-cloud/pkg/conf v1.0.0
	github.com/gaozhen1996/pig-cloud/service => ~/userapp/go/src/pig-cloud/service v1.0.0
	github.com/gaozhen1996/pig-cloud/middleware => ~/userapp/go/src/pig-cloud/middleware v1.0.0
	github.com/gaozhen1996/pig-cloud/models => ~/userapp/go/src/pig-cloud/models v1.0.0
	github.com/gaozhen1996/pig-cloud/pkg/setting => ~/userapp/go/src/pig-cloud/pkg/setting v1.0.0
	github.com/gaozhen1996/pig-cloud/routers => ~/userapp/go/src/pig-cloud/routers v1.0.0
	github.com/gaozhen1996/pig-cloud/routers/api => ~/userapp/go/src/pig-cloud/routers/api v1.0.0
)
