import "./style.css";
import "bootstrap/js/src/button";

window.onload = function () {
  //console.log(Response())
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

        document.getElementById("RefreshBtn").onclick = function imageRefresh() {
          let getImageListe = document.getElementById("ImageListe")
          removeAllChildNodes(getImageListe)
        obj.images.forEach((item)=>{
          let node = document.createElement('li');
          let img = node.appendChild(document.createElement('img'))
          img.src = 'http://localhost:9000/api/images'
              getImageListe.appendChild(img);
              node.innerHTML = item;
            }
          )
        }}
    )
  })
}
