import "./style.css";

window.onload = function () {
  //console.log(Response())
  let responsePromise = fetch("http://localhost:9000/api/images")
  console.log(responsePromise)
    responsePromise.then(res=>{
      let jsonresponse = res.json()
      jsonresponse.then(obj=>{
        console.log(obj)

        let getImageListe = document.getElementById("ImageListe")
        obj.images.forEach((item)=>{
          var node = document.createElement('li');
          node.appendChild(document.createTextNode('Test'))
          getImageListe.appendChild(node)
          node.innerText = item;
        })
      }
    )
  })
}
