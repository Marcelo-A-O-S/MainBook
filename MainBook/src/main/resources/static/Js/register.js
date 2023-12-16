var inputEmail =  document.getElementById("email");
var inputUsername = document.getElementById("username");
var inputPassword = document.getElementById("password");
var passwordConfirm = document.getElementById("passwordConfirm");

var erroUsername = document.getElementById("erroUsername");
var erroPasswordConfirm = document.getElementById("erroPasswordConfirm");
var erroEmail = document.getElementById("erroEmail");


var btnRegistrar = document.getElementById("btn-register");

var passwordValue = inputPassword.innerText;

function VerifyInputs(){
	if(inputEmail.validity.valid === true && inputPassword.validity.valid == true && inputUsername.validity.valid === true && passwordConfirm.validity.valid === true){
		if(inputPassword.value === passwordConfirm.value){
			btnRegistrar.disabled = false;
		}else{
			btnRegistrar.disabled = true;
		}
	}else{
		btnRegistrar.disabled = true;
	}

}

inputUsername.addEventListener("input",(e)=>{
	erroUsername.innerHTML= "";
	if(e.target.validity.valueMissing === true){
		const elementErro = document.createElement("span");
		var messageErro = document.createTextNode("");
		console.log(e.target.value);
		elementErro.className = "text-danger";
		messageErro = document.createTextNode("Preencha o campo acima");
		elementErro.appendChild(messageErro);
		erroUsername.appendChild(elementErro);
	}
	VerifyInputs();
})

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
	
	VerifyInputs();
})
passwordConfirm.addEventListener("input",(e)=>{
	const elementErro = document.createElement("span");
	var messageErro = document.createTextNode("");
	var passwordValue = inputPassword.value;
	erroPasswordConfirm.innerHTML = "";
	if(e.target.validity.valueMissing === true){
		const elementErro = document.createElement("span");
		var messageErro = document.createTextNode("");
		elementErro.className = "text-danger";
		messageErro = document.createTextNode("Preencha o campo acima");
		elementErro.appendChild(messageErro);
		erroPasswordConfirm.appendChild(elementErro);
	}
	else if(passwordValue !== e.target.value){
		elementErro.className = "text-danger"
		messageErro = document.createTextNode( "Senha não confere");
		elementErro.appendChild(messageErro);
		erroPasswordConfirm.appendChild(elementErro);
	}
	VerifyInputs();
})
