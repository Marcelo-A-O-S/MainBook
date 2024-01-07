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
class InpuIsbn extends Input{
	validValue
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
		if(this.input.length > 0){
			this.valid = true;
			verifyInputs()
		}
		
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.input.classList.remove("is-valid")
			this.input.classList.remove("is-invalid")
			this.valid = false;
			this.validValue = false;
			this.erro.innerHTML ="";
			this.sucess.innerHTML ="";
			var objTarget = e.target;
			let value = e.target.value;

			
			if(objTarget.validity.valueMissing === true && value.length === 0 && value === ""){
				this.input.classList.toggle("is-invalid")
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}
			if(value.length > 0){
				var valueAtual = value.replace(/-/g,"");
				if(isNaN(valueAtual) != false){
					this.input.classList.toggle("is-invalid")
					const elementErro = document.createElement("span");
					var messageErro = document.createTextNode("");
					messageErro = document.createTextNode("Preencha apenas com valores numericos!");
					elementErro.appendChild(messageErro);
					this.erro.appendChild(elementErro);
					
				}else{
					this.validValue = true;
				}
			}
			if(objTarget.selectionEnd === 3 || objTarget.selectionEnd === 6 || objTarget.selectionEnd === 12 || objTarget.selectionEnd === 15){
				objTarget.value += `-`;
			}
			
			if(objTarget.value.length === 17 && objTarget.validity.valueMissing === false && this.validValue == true){
				this.input.classList.toggle("is-valid")
				const elementSucess = document.createElement("span");
				var messageSucess = document.createTextNode("");
				messageSucess = document.createTextNode("Pode prosseguir!")
				elementSucess.appendChild(messageSucess);
				this.sucess.appendChild(elementSucess);
				this.valid = true;
			}else{
				this.valid = false;
			}
			verifyInputs()
		})
	}
}
class InputTituloLivro extends Input{
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
		if(this.input.length > 0){
			this.valid = true;
			verifyInputs()
		}
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.valid = false;
			this.input.classList.remove("is-valid")
			this.input.classList.remove("is-invalid")
			this.erro.innerHTML = "";
			this.sucess.innerHTML = "";
			var value = e.target.value;
			var objTarget = e.target;
			if(objTarget.validity.valueMissing === true && value.length === 0 && value === ""){
				this.input.classList.toggle("is-invalid")
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}else{
				this.input.classList.toggle("is-valid")
				const elementSucess = document.createElement("span");
				var messageSucess = document.createTextNode("");
				elementSucess.classList.toggle("primary")
				messageSucess = document.createTextNode("Pode prosseguir!")
				elementSucess.appendChild(messageSucess);
				this.sucess.appendChild(elementSucess);
				this.valid = true;
			}
			verifyInputs()
		})
	}
}
class InputEditora extends Input{
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
		if(this.input.length > 0){
			this.valid = true;
			verifyInputs()
		}
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.valid = false;
			this.input.classList.remove("is-valid")
			this.input.classList.remove("is-invalid")
			this.erro.innerHTML = "";
			this.sucess.innerHTML = "";
			var value = e.target.value;
			var objTarget = e.target;
			if(objTarget.validity.valueMissing === true && value.length === 0 && value === ""){
				this.input.classList.toggle("is-invalid")
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}else{
				this.input.classList.toggle("is-valid")
				const elementSucess = document.createElement("span");
				var messageSucess = document.createTextNode("");
				messageSucess = document.createTextNode("Pode prosseguir!")
				elementSucess.appendChild(messageSucess);
				this.sucess.appendChild(elementSucess);
				this.valid = true;
			}
			verifyInputs()
		})
	}
}
class InputNomeAutor extends Input{
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
		if(this.input.length > 0){
			this.valid = true;
			verifyInputs()
		}
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.valid = false;
			this.input.classList.remove("is-valid")
			this.input.classList.remove("is-invalid")
			this.erro.innerHTML = "";
			this.sucess.innerHTML = "";
			var value = e.target.value;
			var objTarget = e.target;
			if(objTarget.validity.valueMissing === true && value.length === 0 && value === ""){
				this.input.classList.toggle("is-invalid")
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				messageErro = document.createTextNode("Preencha o campo acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}else{
				this.input.classList.toggle("is-valid")
				const elementSucess = document.createElement("span");
				var messageSucess = document.createTextNode("");
				messageSucess = document.createTextNode("Pode prosseguir!")
				elementSucess.appendChild(messageSucess);
				this.sucess.appendChild(elementSucess);
				this.valid = true;
			}
			verifyInputs()
		})
	}
}
class InputCategorias extends Input{
	valid;
	constructor(inputId, erroId, sucessId){
		super(inputId, erroId, sucessId)
		if(this.input.length > 0){
			this.valid = true;
			verifyInputs()
		}
	}
	EventInput(){
		this.input.addEventListener("input",(e)=>{
			this.input.classList.remove("is-valid")
			this.input.classList.remove("is-invalid")
			this.erro.innerHTML = "";
			this.sucess.innerHTML = "";
			this.valid = false;
			for (var i = 0; i < this.input.options.length; i++) {
	            var option = this.input.options[i];
	            if (option.selected) {
	                this.valid = true;
	            }
	        }
	        if(this.valid === false){
				this.input.classList.toggle("is-invalid")
				const elementErro = document.createElement("span");
				var messageErro = document.createTextNode("");
				messageErro = document.createTextNode("Selecione alguma categoria acima");
				elementErro.appendChild(messageErro);
				this.erro.appendChild(elementErro);
			}else{
				this.input.classList.toggle("is-valid")
				const elementSucess = document.createElement("span");
				var messageSucess = document.createTextNode("");
				messageSucess = document.createTextNode("Pode prosseguir!")
				elementSucess.appendChild(messageSucess);
				this.sucess.appendChild(elementSucess);
			}
			verifyInputs()
		})
	}
	EventChange(){
		this.input.addEventListener("change",(e)=>{
		})
	}
}
var elementTituloLivro = new InputTituloLivro("tituloLivro","tituloLivroErro","tituloLivroSucess")
var elementEditora = new InputEditora("editora","editoraErro","editoraSucess")
var elementIsbn = new InpuIsbn("isbn","isbnErro","isbnSucess");
var elementNomeAutor = new InputNomeAutor("nomeAutor","nomeAutorErro","nomeAutorSucess")
var elementCategorias = new InputCategorias("categorias","categoriasErro","categoriasSucess")
elementCategorias.EventInput();
elementIsbn.EventInput();
elementEditora.EventInput();
elementTituloLivro.EventInput();
elementNomeAutor.EventInput();
var btnSalvarBook = document.getElementById("salvarBook");
function verifyInputs(){
	if(elementCategorias.valid === true && elementEditora.valid === true && elementIsbn.valid === true && elementNomeAutor.valid === true && elementTituloLivro.valid === true){
		btnSalvarBook.disabled = false
	}else{
		btnSalvarBook.disabled = true
	}
}
