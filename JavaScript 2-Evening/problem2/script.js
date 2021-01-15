const fname = document.getElementById('fname');
const lname = document.getElementById('lname');
const email = document.getElementById('email');
const age = document.getElementById('age');
const rollno = document.getElementById('roll');
const occupation = document.getElementById('occ');
const dob = document.getElementById('dob');
const gender = document.getElementsByName('gender');


myform.addEventListener("submit", (e)=> {
    let messages = [];

    if(fname.value === "") {
        messages.push("First Name is required");
    }
    else if(lname.value === "") {
        messages.push("Last Name is required");
    }
    else if(email.value === "") {
        messages.push("Email is required");
    }
    else if(!(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(email.value))) {
        messages.push("Invalid Email Address");
    }
    else if(age.value === "") {
        messages.push("Age is required");
    }
    else if(dob.value === "") {
        messages.push("Date of birth is required");
    }
    else if(rollno.value === "") {
        messages.push("Roll number is required");
    }
    else if(occupation.value === "null") {
        messages.push("Occupation is required");
    }
    else if(!gender[0].checked && !gender[1].checked && !gender[2].checked) {
        messages.push("Gender is required");
    }
    else {  
        // console.log("First Name: " + fname.value);
        // console.log("Last Name: " + lname.value);
        // console.log("Email: " + email.value);
        // console.log("Age: " + age.value);
        // console.log("DOB: " + dob.value);
        // console.log("Occupation: " + occupation.value);
        // console.log("Gender: " + getGender(gender));
        let object = new student(fname, lname, email, age, dob, rollno, occupation, getGender(gender));
        object.saveDetails();
        alert("Details saved successfully");   
    }

    if(messages.length > 0) {
        e.preventDefault();
        error.innerText = messages.join(", ")
    }

    function getGender(gender) {
        for(var i = 0; i < gender.length; i++) {
            if(gender[i].checked) {
                return gender[i].value;
            }
        }
    }

});

class student {
    constructor(fname, lname, email, age, dob, rollno, occupation, gender) {
        this.fname = fname.value;
        this.lname = lname.value;
        this.email = email.value;
        this.age = age.value;
        this.dob = dob.value;
        this.rollno = rollno.value;
        this.occupation = occupation.value;
        this.gender = gender;

        this.data = {
            "firstname": this.fname,
            "lastname": this.lname,
            "email": this.email,
            "age": this.age,
            "dob": this.dob,
            "rollno": this.rollno,
            "occupation": this.occupation,
            "gender": this.gender,
        }; 
    };
    saveDetails() {
        localStorage.setItem(this.rollno, JSON.stringify(this.data));
    };
}

function getDetails(roll) {
    output.innerText = (localStorage.getItem(roll));
};