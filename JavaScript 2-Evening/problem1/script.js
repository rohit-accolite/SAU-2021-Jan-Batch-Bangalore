const inp = document.getElementById('value');

myform.addEventListener("submit", (err)=> {
    let message;

    if(inp.value === "") {
        message = "String is required";
    }
    else if(!(/^[a-zA-Z]*$/.test(inp.value))) {
        message = "String should contain only alphabets.";
    }
    else {
        process(inp.value);
        err.preventDefault();
    }

    if(message) {
        console.log("Invalid String");
        err.preventDefault();
        error.innerText = message;
    }
});

class input {
    constructor(param) {
        this.input = param;
        console.log("Input String: " +this.input);
    }
    calculateLength() {
        console.log("Length Of the Input: "+this.input.length);
        return "Length Of the Input: "+this.input.length;
    };
    getUpperCase() {
        console.log("UpperCase Of the Input: "+this.input.toUpperCase());
        return "UpperCase Of the Input: "+this.input.toUpperCase();
    };
    getLowerCase() {
        console.log("LowerCase Of the Input: "+this.input.toLowerCase());
        return "LowerCase Of the Input: "+this.input.toLowerCase();
    };
    separate() {
        let vowels = "";
        let consonants = "";

        for (const myVariable of this.input) {
            if(!(/^[a/e/i/u/o/A/E/I/O/U]*$/.test(myVariable)))
                consonants+=myVariable;
            else vowels+=myVariable;
        }
        console.log("Separated Input: "+vowels+" - "+consonants);
        return "Separated Input: "+vowels+" - "+consonants;
    }
}

function process(inputValue) {
    let inputObject = new input(inputValue);
    document.getElementById("length").innerHTML = inputObject.calculateLength();
    document.getElementById("uc").innerHTML = inputObject.getUpperCase();
    document.getElementById("lc").innerHTML = inputObject.getLowerCase();
    document.getElementById("separate").innerHTML = inputObject.separate();
}