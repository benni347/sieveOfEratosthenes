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
