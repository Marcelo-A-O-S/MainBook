/**
 * 
 */

 var inputEmail =  document.getElementById("email");
 var inputPassword = document.getElementById("password");
 
 var erroEmail = document.getElementById("erroEmail");
 
 var btnLogin = document.getElementById("btn-login");
 
 function verifyInputs(){
	 if(inputEmail.validity.valid === true && inputPassword.validity.valid === true){
		 btnLogin.disabled = false;
	 }else{
		 btnLogin.disabled = true;
	 }
	 
 }
 inputEmail.addEventListener("input", (e)=>{
	erroEmail.innerHTML = "";
	if(e.target.validity.valueMissing === true){
		const elementErro = document.createElement("span");
		var messageErro = document.createTextNode("");
		elementErro.className = "text-danger";
		messageErro = document.createTextNode("Preencha o campo acima");
		elementErro.appendChild(messageErro);
		erroEmail.appendChild(elementErro);
	}else if(e.target.validity.valid === false){
		const elementErro = document.createElement("span");
		var messageErro = document.createTextNode("");
		elementErro.className = "text-danger";
		messageErro = document.createTextNode( "Email inválido");
		elementErro.appendChild(messageErro);
		erroEmail.appendChild(elementErro);
	}
	verifyInputs();
})
inputPassword.addEventListener("input", (e)=>{
	verifyInputs();
})