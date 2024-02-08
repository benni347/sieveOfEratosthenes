pub fn sieve(limit: usize) -> Vec<usize> {
    if limit == 0 || limit == 1 {
        return vec![];
    }

    let mut is_prime = vec![true; limit + 1];
    is_prime[0] = false;
    is_prime[1] = false;

    for i in 2..=(f64::sqrt(limit as f64) as usize) {
        if is_prime[i] {
            for j in (i * i..limit + 1).step_by(i) {
                is_prime[j] = false;
            }
        }
    }

    is_prime
        .into_iter()
        .enumerate()
        .filter_map(|(i, prime)| if prime { Some(i) } else { None })
        .collect()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_zero_and_one() {
        assert_eq!(sieve(0), vec![]);
        assert_eq!(sieve(1), vec![]);
    }

    #[test]
    fn test_small_limit() {
        assert_eq!(sieve(10), vec![2, 3, 5, 7]);
    }

    #[test]
    fn test_larger_limit() {
        assert_eq!(sieve(30), vec![2, 3, 5, 7, 11, 13, 17, 19, 23, 29]);
    }

    #[test]
    fn test_edge_cases() {
        assert_eq!(sieve(2), vec![2]);
        assert_eq!(sieve(3), vec![2, 3]);
        assert_eq!(sieve(4), vec![2, 3]);
        assert_eq!(sieve(5), vec![2, 3, 5]);
    }
}
