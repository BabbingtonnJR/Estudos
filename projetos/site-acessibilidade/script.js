function ajustarFonte(tamanho) {
    localStorage.setItem('fontSize', tamanho);
    document.body.style.fontSize = tamanho + "px";
}

function mudarContraste(tema) {
    localStorage.setItem('contraste', tema);
    if (tema === 'alto') {
        document.body.classList.add('alto-contraste');
    } else {
        document.body.classList.remove('alto-contraste');
    }
}

function carregarConfiguracoes() {
    const fontSize = localStorage.getItem('fontSize');
    if (fontSize) {
        document.body.style.fontSize = fontSize + "px";
    }

    const contraste = localStorage.getItem('contraste');
    if (contraste === 'alto') {
        document.body.classList.add('alto-contraste');
    }
}

function ativarLeituraVozAlta() {
    var texto = document.body.innerText;

    if (texto.length > 0) {
        var sintese = new SpeechSynthesisUtterance(texto);
        window.speechSynthesis.speak(sintese);
    } else {
        alert("Não há conteúdo para ler.");
    }
}

function pararLeituraVozAlta() {
    window.speechSynthesis.cancel();
}

window.onload = carregarConfiguracoes;
