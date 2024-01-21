// Package prime is the package implementing the sieve
package prime

import (
	"fmt"
	"math"
)

// Sieve uses the sieve of eratosthenes algorithm to find any primes below or exactly on the limit.
func Sieve(limit int) ([]int, error) {
	if limit < 0 {
		return nil, fmt.Errorf("The prime limit must be greater than 0, given: %d", limit)
	}
	if limit == 0 || limit == 1 {
		return []int{}, nil
	}
	isPrime := make([]bool, limit+1)
	for i := range isPrime {
		isPrime[i] = true
	}

	isPrime[0], isPrime[1] = false, false

	for i := 2; float64(i) <= math.Sqrt(float64(limit)); i++ {
		if isPrime[int(i)] {
			for j := i * i; j <= limit; j += i {
				isPrime[j] = false
			}
		}
	}
	var primes []int
	for i, prime := range isPrime {
		if prime {
			primes = append(primes, i)
		}
	}

	return primes, nil
}
