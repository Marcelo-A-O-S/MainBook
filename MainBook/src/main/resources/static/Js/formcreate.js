var inputIsbn = document.getElementById("isbn")
inputIsbn.addEventListener("input",(e)=>{
	
	var input = e.target;
	if(input.selectionEnd === 3 || input.selectionEnd === 6 || input.selectionEnd === 12 || input.selectionEnd === 15){
		input.value += "-"
	}
})