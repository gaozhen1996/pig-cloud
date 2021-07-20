package service

import (
	"math/rand"
	"sync"
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

var lock sync.Mutex

func (rr *RoundRule) Choose(servers []Server) Server {
	//获取轮询规则缓存,取路由下标索引，计算下一次路由索引
	var roundRule = cachePool.GetRoundRule(rr.apiName)
	index := roundRule.currentIndex
	roundRule.currentIndex++
	roundRule.currentIndex = roundRule.currentIndex % len(servers)
	//如果map中的对象与传过来不一样，则说明map中不存在，需要新增
	if roundRule.apiName != rr.apiName {
		cachePool.roundRuleMap.Store(rr.apiName, RoundRule{
			currentIndex: roundRule.currentIndex,
		})
	}
	return servers[index]
}
