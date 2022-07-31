document.querySelector('.img-btn').addEventListener('click', function()
	{
		document.querySelector('.cont').classList.toggle('s-signup')
	
	
      function OnCheck(){
      let x = document.getElementById("pass");
      if(x.type == "password"){
        x.type = "text";
      }
      else{
        x.type = "password";
      }
    }
    function loginCheck() {
          let userName = document.getElementById("Username");
          let password = document.getElementById("pass");
          document.getElementById("passwordCheck").innerHTML = "Inside login check";

          const request = new XMLHttpRequest();
          request.open("GET", "url/userName");// send username as parameter to retrieve password
          request.send();
          request.onload = () => {
              if(request.status === 200) {
                  console.log("Successfully retrieved data from api");
                  let res = JSON.parse(request.response);
                  console.log(res);
                  if (res.password === password) {
                      console.log("Password matched");
                      location.replace("dashbrd.html");
                  }
                  else {
                      console.log("Wrong password");
                      document.getElementById("passwordCheck").innerHTML = "Incorrect Password";
                  }
              }
              else {
                  console.log("Error in getting data from api");
              }
          }
      }
	}
);
