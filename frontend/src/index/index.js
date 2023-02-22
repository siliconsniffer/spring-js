import 'bootstrap/dist/css/bootstrap.min.css';
import '../style.css';
import "bootstrap/js/src/button";
import "../login/login.js"

window.onload = function () {
  //console.log(Response())
    fetchImages()
    localStorage.removeItem("user")

  let user = localStorage.getItem("user")
    if (user != null){
        document.getElementById("Login").innerHTML = "Logout"
    }
    else if (user != null && document.getElementById("Login").onclick){
        Logout()
    }
  //Button umbennen wenn user eingeloggt
}

window.refresh = function () {
  fetchImages()
}

window.fetchImages = function (){
  let responsePromise = fetch("http://localhost:9000/api/images")
  console.log(responsePromise)
  responsePromise.then(res=>{
    let jsonresponse = res.json()
    jsonresponse.then(obj=>{
          console.log(obj)

          function removeAllChildNodes(parent) {
            while (parent.firstChild) {
              parent.removeChild(parent.firstChild);
            }
          }

          let container = document.getElementById("container")
          removeAllChildNodes(container)

          for(let i=0;i<obj.images.length;i++){
            let item = obj.images[i]
            let node = document.createElement('div');
            node.className="flex-box"
            let img = node.appendChild(document.createElement('img'))
            img.className="image"
            img.src = 'http://localhost:9000/api/data/images?image=' + item
            container.appendChild(node);
          }
        }
    )
  })
}