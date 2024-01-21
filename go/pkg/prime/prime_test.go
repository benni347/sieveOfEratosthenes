package prime

import "testing"

func slicesEqual(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i, v := range a {
		if v != b[i] {
			return false
		}
	}
	return true
}

func TestPrimes1(t *testing.T) {
	got, err := PrimeSieve(1)
	if err != nil {
		t.Errorf("Got an error even though none should be thrown, err = %e", err)
	}

	if !slicesEqual(got, []int{}) {
		t.Errorf("There are primes below 1, primes = %v", got)
	}
}

func TestPrimesSmallLimit(t *testing.T) {
	got, err := PrimeSieve(10)
	if err != nil {
		t.Errorf("Error thrown for valid input, err = %e", err)
	}

	expected := []int{2, 3, 5, 7}
	if !slicesEqual(got, expected) {
		t.Errorf("Incorrect primes for limit 10, got = %v, want = %v", got, expected)
	}
}

func TestPrimesLargeLimit(t *testing.T) {
	got, err := PrimeSieve(30)
	if err != nil {
		t.Errorf("Error thrown for valid input, err = %e", err)
	}

	expected := []int{2, 3, 5, 7, 11, 13, 17, 19, 23, 29}
	if !slicesEqual(got, expected) {
		t.Errorf("Incorrect primes for limit 30, got = %v, want = %v", got, expected)
	}
}

func TestPrimesNegativeInput(t *testing.T) {
	_, err := PrimeSieve(-5)
	if err == nil {
		t.Errorf("Expected an error for negative input, but got none")
	}
}

func TestPrimesZero(t *testing.T) {
	got, err := PrimeSieve(0)
	if err != nil {
		t.Errorf("Error thrown for valid input, err = %e", err)
	}

	if !slicesEqual(got, []int{}) {
		t.Errorf("There are primes below 0, primes = %v", got)
	}
}

func TestPrimesTwo(t *testing.T) {
	got, err := PrimeSieve(2)
	if err != nil {
		t.Errorf("Error thrown for valid input, err = %e", err)
	}

	expected := []int{2}
	if !slicesEqual(got, expected) {
		t.Errorf("Incorrect primes for limit 2, got = %v, want = %v", got, expected)
	}
}
