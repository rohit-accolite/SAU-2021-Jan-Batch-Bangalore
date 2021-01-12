function changeCase(input) {
    result = "";

    for(let i = 0; i < input.length; i++) {
        if (/[a-z]/.test(input[i])) result += input[i].toUpperCase();
        else result += input[i].toLowerCase();
    }
    return result;
}

console.log(changeCase("Hello"));
console.log(changeCase("World"));
console.log(changeCase("RaNDoM StRiNG"));