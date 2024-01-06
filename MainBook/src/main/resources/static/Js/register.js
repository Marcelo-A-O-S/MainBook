class Input{
	input;
	erro;
	sucess;
	constructor(inputId, erroId, sucessId){
		this.input = document.getElementById(inputId);
		this.erro = document.getElementById(erroId);
		this.sucess = document.getElementById(sucessId);
	}
}
class InputEmail extends Input{
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
	}
	get Valid(){
		return this.valid;
	}
	set Valid(_valid){
		this.valid = _valid
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.erro.innerHTML = "";
			if(e.target.validity.valueMissing === true){
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				elementErro.className = "text-danger";
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}else if(e.target.validity.valid === false){
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				elementErro.className = "text-danger";
				messageErro = document.createTextNode( "Email inválido");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}
			this.Valid = e.target.validity.valid;
			VerifyInputs();
		})
	}
	
}
class InputUserName extends Input{
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
	}
	get ObterValid(){
		return this.valid;
	}
	set DefinirValid(_valid){
		this.valid = _valid
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.erro.innerHTML = "";
			if(e.target.validity.valueMissing === true){
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				console.log(e.target.value);
				elementErro.className = "text-danger";
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}
			this.DefinirValid = e.target.validity.valid;
			VerifyInputs();
		})
	}
}
class InputPassword extends Input{
	validPassword;
	validConfirm;
	inputConfirm;
	erroConfirm;
	sucessConfirm;
	constructor(inputId, erroId, sucessId, _inputConfirmId, _erroConfirmId, _sucessConfirmId){
		super(inputId, erroId, sucessId)
		this.inputConfirm = document.getElementById(_inputConfirmId);
		this.erroConfirm = document.getElementById(_erroConfirmId);
		this.sucessConfirm = document.getElementById(_sucessConfirmId);
	}
	EventInputPassword(){
		this.input.addEventListener("input",(e)=>{
			this.validPassword = e.target.validity.valid
		})
	}
	EventInputPasswordConfirm(){
		this.inputConfirm.addEventListener("input",(e)=>{
			this.validConfirm = false;
			this.erroConfirm.innerHTML = "";
			const elementErro = document.createElement("span");
			var messageErro = document.createTextNode("");
			var passwordValue = this.input.value;
			if(e.target.validity.valueMissing === true && e.target.value === "" && e.target.value.length === 0){
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				elementErro.className = "text-danger";
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erroConfirm.appendChild(elementErro);
			}
			else if(passwordValue !== e.target.value){
				elementErro.className = "text-danger"
				messageErro = document.createTextNode( "Senha não confere");
				elementErro.appendChild(messageErro);
				this.erroConfirm.appendChild(elementErro);
			}
			if(this.ConfirmPassword()){
				this.validConfirm = true;
			}else{
				this.validConfirm =false;
			}
			VerifyInputs();
			
		})
	}
	ConfirmPassword(){
		if(this.input.value === this.inputConfirm.value){
			return true;
		}else{
			return false;
		}
	}
	
}
var elementEmail = new InputEmail("email","erroEmail","sucessEmail" );
var elementUsername = new InputUserName("username","erroUsername","sucessUsername");
var elementPassword = new InputPassword("password","erropassword","sucesspassword","passwordConfirm","erroPasswordConfirm","sucessPasswordConfirm")
elementEmail.EventInput();
elementUsername.EventInput();
elementPassword.EventInputPassword();
elementPassword.EventInputPasswordConfirm();
var btnRegistrar = document.getElementById("btn-register");
function VerifyInputs(){
	if(elementEmail.valid === true && elementPassword.validPassword == true && elementUsername.valid === true && elementPassword.validConfirm === true){
		if(elementPassword.ConfirmPassword()){
			btnRegistrar.disabled = false;
		}else{
			btnRegistrar.disabled = true;
		}
	}else{
		btnRegistrar.disabled = true;
	}
}
