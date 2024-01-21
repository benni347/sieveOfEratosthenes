import math


def sieve(limit: int):
    if not isinstance(limit, int):
        return "Prime limit must be an integer"
    if limit < 0:
        return "Prime limit must be greater than 0"
    if limit == 0 or limit == 1:
        return []

    isPrime = [True] * (limit + 1)
    isPrime[0] = isPrime[1] = False

    for i in range(2, int(math.sqrt(limit)) + 1):
        if isPrime[i]:
            for j in range(i * i, limit + 1, i):
                isPrime[j] = False

    primes = []
    for i in range(limit + 1):
        if isPrime[i]:
            primes.append(i)
    return primes
