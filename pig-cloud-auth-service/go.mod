module github.com/gaozhen1996/pig-cloud

go 1.14

require (
	github.com/alecthomas/template v0.0.0-20190718012654-fb15b899a751
	github.com/astaxie/beego v1.12.3
	github.com/dgrijalva/jwt-go v3.2.0+incompatible
	github.com/gin-gonic/gin v1.7.1
	github.com/go-ini/ini v1.62.0
	github.com/go-openapi/spec v0.20.3 // indirect
	github.com/go-openapi/swag v0.19.15 // indirect
	github.com/go-playground/validator/v10 v10.6.0 // indirect
	github.com/go-sql-driver/mysql v1.6.0 // indirect
	github.com/golang/protobuf v1.5.2 // indirect
	github.com/hashicorp/consul/api v1.8.1
	github.com/jinzhu/gorm v1.9.16
	github.com/json-iterator/go v1.1.11 // indirect
	github.com/leodido/go-urn v1.2.1 // indirect
	github.com/lib/pq v1.2.0 // indirect
	github.com/mailru/easyjson v0.7.7 // indirect
	github.com/smartystreets/goconvey v0.0.0-20190731233626-505e41936337 // indirect
	github.com/swaggo/gin-swagger v1.2.0
	github.com/swaggo/swag v1.7.0
	github.com/ugorji/go v1.2.5 // indirect
	github.com/unknwon/com v1.0.1
	golang.org/x/crypto v0.0.0-20210506145944-38f3c27a63bf // indirect
	golang.org/x/net v0.0.0-20210508051633-16afe75a6701 // indirect
	golang.org/x/sys v0.0.0-20210507161434-a76c4d0a0096 // indirect
	golang.org/x/tools v0.1.0 // indirect
	gopkg.in/ini.v1 v1.47.0 // indirect
)

replace (
	github.com/gaozhen1996/pig-cloud/conf => ~/userapp/go/src/pig-cloud/pkg/conf v1.0.0
	github.com/gaozhen1996/pig-cloud/middleware => ~/userapp/go/src/pig-cloud/middleware v1.0.0
	github.com/gaozhen1996/pig-cloud/models => ~/userapp/go/src/pig-cloud/models v1.0.0
	github.com/gaozhen1996/pig-cloud/pkg/setting => ~/userapp/go/src/pig-cloud/pkg/setting v1.0.0
	github.com/gaozhen1996/pig-cloud/routers => ~/userapp/go/src/pig-cloud/routers v1.0.0
	github.com/gaozhen1996/pig-cloud/routers/api => ~/userapp/go/src/pig-cloud/routers/api v1.0.0
)
