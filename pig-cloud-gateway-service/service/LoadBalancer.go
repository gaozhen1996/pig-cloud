package service

import "math/rand"

type LoadBalancer interface {
	Choose(servers []Server) Server
}

type RandomLoadBalancer struct {
}

func (rlb *RandomLoadBalancer) Choose(servers []Server) Server {
	var index = rand.Intn(len(servers))
	return servers[index]
}
