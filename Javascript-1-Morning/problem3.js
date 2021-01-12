function sameDigits(n) {
    let digit = n % 10;

    while(n != 0) {
        let temp = n % 10;
        n = Math.floor(n / 10);

        if(digit !== temp) {
            return false;
        }
    }
    return true;
}

console.log(sameDigits(7));
console.log(sameDigits(39));
console.log(sameDigits(8888));
console.log(sameDigits(2222222));