import unittest

from sieve import sieve


class TestSieve(unittest.TestCase):
    def test_prime1(self):
        got = sieve(1)
        expected = []
        self.assertEqual(
            got,
            expected,
            "There is no primenumber below 1, got = [" + " ".join(got) + "]",
        )

    def test_small_prime_limit(self):
        got = sieve(10)
        expected = [2, 3, 5, 7]
        self.assertEqual(
            got,
            expected,
            "Incorrect primes for limit 10, got = [" + " ".join(map(str, got)) + "]",
        )

    def test_large_prime_limit(self):
        got = sieve(100)
        expected = [
            2,
            3,
            5,
            7,
            11,
            13,
            17,
            19,
            23,
            29,
            31,
            37,
            41,
            43,
            47,
            53,
            59,
            61,
            67,
            71,
            73,
            79,
            83,
            89,
            97,
        ]
        self.assertEqual(
            got,
            expected,
            "Incorrect primes for limit 100, got = [" + " ".join(map(str, got)) + "]",
        )

    def test_negative_input(self):
        got = sieve(-10)
        expected = "Prime limit must be greater than 0"
        self.assertEqual(
            got, expected, "Function should return error message for negative input"
        )

    def test_zero_input(self):
        got = sieve(0)
        expected = []
        self.assertEqual(
            got,
            expected,
            "There should be no prime number for limit 0, got = ["
            + " ".join(map(str, got))
            + "]",
        )

    # Test for non-integer input is optional based on your requirements
    def test_non_integer_input(self):
        got = sieve(10.5)
        expected = "Prime limit must be an integer"
        self.assertEqual(
            got, expected, "Function should return error message for non-integer input"
        )
