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
class InputEmailLogin extends Input{
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
			verifyInputs();
		})
	}	
}
class InputPasswordLogin extends Input{
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
			this.Valid = e.target.validity.valid;
			verifyInputs();
		})
	}
}

var elementEmailLogin = new InputEmailLogin("email","erroEmail","sucessEmail");
var elementPasswordLogin = new InputPasswordLogin("password", "erroPasword","sucessPassword");
elementEmailLogin.EventInput();
elementPasswordLogin.EventInput();
var btnLogin = document.getElementById("btn-login");
function verifyInputs(){
	 if(elementEmailLogin.valid === true && elementPasswordLogin.valid === true){
		 btnLogin.disabled = false;
	 }else{
		 btnLogin.disabled = true;
	 }
	 
 }

