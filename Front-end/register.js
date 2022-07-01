let one = document.getElementById("choose");
let two = document.getElementById("confirm");
let three = document.getElementById("confirmation")
two.addEventListener('input',function(){
    if(one.value==two.value){
        three.textContent ="Your passwords matched!!!";
        three.style.color = "green";
    }
    else{
        three.textContent ="Your passwords don't match!!!"
        three.style.color = "red";
    }
})
let button = document.getElementsByClassName("reg");
let first = document.getElementById("First");
function validateFirstName(){
first.addEventListener('input',function(){
    for(let i=0;i<first.value.length();i++){
        if(first[i].charCodeat(0)<0 || first[i].charCodeat(0)>51){
         
            return false;
        }
    }
});
    return true;
}
let last = document.getElementById("Last");
function validateLastName(){
last.addEventListener('input',function(){
    for(let i=0;i<last.value.length();i++){
        if(last.value[i].charCodeat(0)<0 || last.value[i].charCodeat(0)>51){
            return false;
        }
    }
});
    return true;
}
let contact = document.getElementById("contact");
function validateContact(){
    if(contact.value.length!=10){
        return false;
    }
    return true;
}
button.onclick = function(){
    if(one.value!=two.value){
        alert("The passwords don't match!!");
    }
    if(validateFirstName()==false){
        alert("Invalid First Name");
        }
    if(validateLastName()==false){
        alert("Invalid Last Name");
    }
    if(validateContact()==false){
        alert("Invalid contact number");
    }
}

