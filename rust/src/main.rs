use rust::sieve;

fn main() {
    let limit = 1000;
    let primes = sieve(limit);
    println!("Primes up to {}: {:?}", limit, primes)
}
