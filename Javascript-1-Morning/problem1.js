function isPrime(n) {
    for(let i = 2; i < n/2; i++) {
        if(n % i === 0) return false;
    }
    return true;
}

function primeFactors(n) {
    let set = new Set();

    for(let i = 2; i <= n; i++) {
        if(isPrime(i) && n % i === 0) {
            set.add(i);
            n = n / i;
        }
    }
    return set;
}

console.log(primeFactors(5));
console.log(primeFactors(16));
console.log(primeFactors(48));
console.log(primeFactors(74));
console.log(primeFactors(101));