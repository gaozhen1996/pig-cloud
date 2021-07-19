package service

import (
	"math/rand"
)

type Server struct {
	Address     string
	ServicePort int
}

type LoadBalancer interface {
	Choose(servers []Server) Server
}

/**
 *随机规则
 */
type RandomRule struct {
}

func (rlb *RandomRule) Choose(servers []Server) Server {
	var index = rand.Intn(len(servers))
	return servers[index]
}

/**
 *轮询规则
 */
type RoundRule struct {
	currentIndex int
	apiName      string
}

var roundRuleMap map[string]RoundRule

func (rr *RoundRule) Choose(servers []Server) Server {
	//如果map中为空，则初始化
	if len(roundRuleMap) == 0 {
		roundRuleMap = make(map[string]RoundRule)
	}
	//取路由下标索引，计算下一次路由索引
	var roundRule = roundRuleMap[rr.apiName]
	index := roundRule.currentIndex
	roundRule.currentIndex++
	roundRule.currentIndex = roundRule.currentIndex % len(servers)
	//如果map中的对象与传过来不一样，则说明map中不存在，需要新增
	if roundRule.apiName != rr.apiName {
		roundRuleMap[rr.apiName] = RoundRule{
			currentIndex: roundRule.currentIndex,
		}
	}
	return servers[index]
}
