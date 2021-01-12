function stringSum(str) {
    let result = 0;

    for(let i = 0; i < str.length; i++) {
        if(!isNaN(str[i]))
            result += parseInt(str[i]);
    }
    console.log(result);
}

stringSum("dfnd54hs5");
stringSum("43fbdf45bfdbdf");
stringSum("789215");
stringSum("dsjkbvdlsnlsdknvsdklvn");