const nev = document.getElementById('nev');
const email = document.getElementById('email');
const jelszo = document.getElementById('password');
const jelszoEllen = document.getElementById('jelszoEllen');
const registerBtn = document.getElementById('register');

const Ellenorzes = () => {
    if (jelszo.value !== '' && jelszoEllen.value !== '' && nev.value !== '' && email.value !== '' && jelszo.value === jelszoEllen.value) {
        registerBtn.className = 'btn btn-success';
    } else if (jelszo.value == '' && jelszoEllen.value == '' && nev.value == '' && email.value == '') {
        registerBtn.className = 'btn disabled btn-danger';
    } else {
        registerBtn.className = 'btn disabled btn-danger';
    }
};

nev.addEventListener('input', Ellenorzes);
email.addEventListener('input', Ellenorzes);
jelszo.addEventListener('input', Ellenorzes);
jelszoEllen.addEventListener('input', Ellenorzes);
