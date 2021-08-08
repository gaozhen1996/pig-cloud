package api

import (
	"log"
	"net/http"
	"runtime"
	"strings"

	sentinel "github.com/alibaba/sentinel-golang/api"
	"github.com/alibaba/sentinel-golang/core/base"
	"github.com/alibaba/sentinel-golang/core/config"
	"github.com/alibaba/sentinel-golang/core/flow"
	"github.com/alibaba/sentinel-golang/logging"
	"github.com/gin-gonic/gin"
)

const testFlowRuleUrl = "/flow"

// 初始化Sentinel
func SentinelInit() {
	// We should initialize Sentinel first.
	conf := config.NewDefaultConfig()
	conf.Sentinel.Log.Logger = logging.NewConsoleLogger()
	err := sentinel.InitWithConfig(conf)
	if err != nil {
		log.Fatal(err)
	}
}

func FlowLimit(c *gin.Context) {
	resourceName := runFuncName()
	// 埋点（流控规则方式）
	e, b := sentinel.Entry(resourceName, sentinel.WithTrafficType(base.Inbound))
	if b != nil {
		c.JSON(http.StatusOK, gin.H{
			"code": 501,
			"msg":  "流量过大",
			"data": nil,
		})
	} else {
		Router(c)
		e.Exit()
	}
}

// 创建流控规则（默认基于QPS）
// threshold 阈值
// interval 统计间隔（毫秒）
func CreateFlowRule(resourceName string, threshold float64, interval uint32) {
	_, err := flow.LoadRules([]*flow.Rule{
		{
			Resource:               resourceName,
			TokenCalculateStrategy: flow.Direct,
			ControlBehavior:        flow.Reject,
			Threshold:              threshold,
			StatIntervalInMs:       interval,
		},
	})
	if err != nil {
		log.Fatalf("Unexpected error: %+v", err)
		return
	}
}

// 获取正在运行的函数名
func runFuncName() string {
	pc := make([]uintptr, 1)
	runtime.Callers(2, pc)
	totalFuncName := runtime.FuncForPC(pc[0]).Name()
	names := strings.Split(totalFuncName, ".")
	return names[len(names)-1]
}
