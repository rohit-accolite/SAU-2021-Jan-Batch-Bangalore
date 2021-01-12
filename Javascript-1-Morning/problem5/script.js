const fname = document.getElementById('fname');
const lname = document.getElementById('lname');
const email = document.getElementById('email');
const experience = document.getElementById('exp');
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
    else if(experience.value === "null") {
        messages.push("Experience is required");
    }
    else if(!gender[0].checked && !gender[1].checked && !gender[2].checked) {
        messages.push("Gender is required");
    }
    else {  
        console.log("First Name: " + fname.value);
        console.log("Last Name: " + lname.value);
        console.log("Email: " + email.value);
        console.log("Experience: " + experience.value);
        console.log("Gender: " + getGender(gender));
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