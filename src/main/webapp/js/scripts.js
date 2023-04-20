// BUSCA CEP
function limpa_formulário_cep() {
    //Limpa valores do formulário de cep.
    document.getElementById('inputEndereco').value=("");
    document.getElementById('inputCity').value=("");
    document.getElementById('inputState').value=("");
}

function meu_callback(conteudo) {
    if (!("erro" in conteudo)) {
        //Atualiza os campos com os valores.
        document.getElementById('inputEndereco').value=(conteudo.logradouro);
        document.getElementById('inputCity').value=(conteudo.localidade);
        document.getElementById('inputState').value=(conteudo.uf);
    } //end if.
    else {
        //CEP não Encontrado.
        limpa_formulário_cep();
        alert("CEP não encontrado.");
    }
}

function pesquisacep(valor) {

    //Nova variável "cep" somente com dígitos.
    var cep = valor.replace(/\D/g, '');

    //Verifica se campo cep possui valor informado.
    if (cep != "") {

        //Expressão regular para validar o CEP.
        var validacep = /^[0-9]{8}$/;

        //Valida o formato do CEP.
        if(validacep.test(cep)) {

            //Preenche os campos com "..." enquanto consulta webservice.
            document.getElementById('inputEndereco').value="...";
            document.getElementById('inputCity').value="...";
            document.getElementById('inputState').value="...";

            //Cria um elemento javascript.
            var script = document.createElement('script');

            //Sincroniza com o callback.
            script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

            //Insere script no documento e carrega o conteúdo.
            document.body.appendChild(script);

        } //end if.
        else {
            //cep é inválido.
            limpa_formulário_cep();
            alert("Formato de CEP inválido.");
        }
    } //end if.
    else {
        //cep sem valor, limpa formulário.
        limpa_formulário_cep();
    }
};

//MÁSCARA TELEFONE
function mascaraTelefone(event) {
    let tecla = event.key;
    let telefone = event.target.value.replace(/\D+/g, "");

    if (/^[0-9]$/i.test(tecla)) {
        telefone = telefone + tecla;
        let tamanho = telefone.length;

        if (tamanho >= 12) {
            return false;
        }

        if (tamanho > 10) {
            telefone = telefone.replace(/^(\d\d)(\d{5})(\d{4}).*/, "($1) $2-$3");
        } else if (tamanho > 5) {
            telefone = telefone.replace(/^(\d\d)(\d{4})(\d{0,4}).*/, "($1) $2-$3");
        } else if (tamanho > 2) {
            telefone = telefone.replace(/^(\d\d)(\d{0,5})/, "($1) $2");
        } else {
            telefone = telefone.replace(/^(\d*)/, "($1");
        }

        event.target.value = telefone;
    }

    if (!["Backspace", "Delete", "Tab"].includes(tecla)) {
        return false;
    }
}

//MASCARA CPF
function mascara(i){

    var v = i.value;

    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que não seja número
        i.value = v.substring(0, v.length-1);
        return;
    }

    i.setAttribute("maxlength", "14");
    if (v.length == 3 || v.length == 7) i.value += ".";
    if (v.length == 11) i.value += "-";

}