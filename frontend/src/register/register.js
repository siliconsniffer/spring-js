import 'bootstrap/dist/css/bootstrap.min.css';
import '../style.css'
import "bootstrap";

window.register = function () {
    let password = document.getElementById('password').value
    let userName = document.getElementById("userName").value
    let email = document.getElementById('email').value

    let userData = {
        userName : userName,
        email : email,
        password : password
    }
    fetch('/api/user/register',{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            console.log(response)
            if (response.status===200){
                window.alert("Register successful")
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
window.logout = function (){
    localStorage.removeItem("user")
    document.getElementById("Login").innerHTML = "Login"
    document.getElementById("Login").setAttribute("onclick","window.location.href='http://localhost:9000/login.html'")

}