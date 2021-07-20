package util

import (
	"net"
	"time"
)

func Telnet(ip string, port string) bool {
	result := false
	address := net.JoinHostPort(ip, port)
	// 3 秒超时
	conn, err := net.DialTimeout("tcp", address, 3*time.Second)
	if err == nil {
		if conn != nil {
			result = true
			_ = conn.Close()
		}
	}
	return result
}
