document.getElementById('sacar').addEventListener('click', async () => {
    const nome = document.getElementById('cliente-nome').value;
    const valor = document.getElementById('valor-saque').value;
    const url = `http://localhost:8080/api/clientes/${nome}/sacar?valor=${valor}`;

    try {
        const response = await fetch(url, { method: 'POST' });
        if (!response.ok) throw new Error('Erro ao realizar saque.');
        alert('Saque realizado com sucesso!');
    } catch (error) {
        alert(error.message);
    }
});