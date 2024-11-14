function atualizarConsumo() {
    fetch('/consumo')
        .then(response => response.json())
        .then(data => {
                document.getElementById('potencia').textContent = data.potencia + ' W';
                document.getElementById('tensao').textContent = data.tensao + ' V';
                document.getElementById('corrente').textContent = data.corrente + ' A';
                document.getElementById('consumoAtual').textContent = data.consumoAtual + ' kWh';
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

setInterval(atualizarConsumo, 2000);

  function gerarNumeroAleatorio(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;

  }

  function atualizarValores() {
    const consumoTotalMes = document.getElementById('consumoTotalMes');
    const comparacaoMesAnterior = document.getElementById('comparacaoMesAnterior');

    const novoConsumo = gerarNumeroAleatorio(100, 500);
    const novaComparacao = gerarNumeroAleatorio(-20, 20);

    consumoTotalMes.textContent = novoConsumo + ' kWh';
    comparacaoMesAnterior.textContent = novaComparacao + '%';
  }

  window.onload = atualizarValores;

const form = document.querySelector('form');

form.addEventListener('submit', (event) => {
 event.preventDefault(); // Prevent default form submission

  const
 nome = document.getElementById('nome').value;
  const email = document.getElementById('email').value;
  const senha = document.getElementById('senha').value;


  const data = {
    nome,
    email,
    senha

  };

  fetch('/usuarios', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    console.log('Success:',
 data);
    // Handle success, e.g., show a success message
  })
  .catch(error => {
    console.error('Error:', error);
    // Handle errors, e.g., show an error message  

  });
});