import 'bootstrap/dist/css/bootstrap.min.css';
import '../style.css'
import "bootstrap";

window.login = function () {
    let password = document.getElementById('password').value
    let email = document.getElementById('email').value

    let userData = {
        userNameOrEmail : email,
        password : password
    }

    fetch('/api/user/login',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            console.log(response)
            if (response.status===200){
                window.alert("Login successful")
                localStorage.setItem('user', email)
                window.location.href = 'http://localhost:9000/'
            }
            else {
                window.alert("Login failed.")
            }
        })
        .then(data => console.log(data))
        .catch(error => console.error(error));
}
