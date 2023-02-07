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
          var img = node.appendChild(document.createElement('img'))
          img.src = 'http://localhost:9000/api/images'
          getImageListe.appendChild(img);
          node.innerHTML = item;
        })
      }
    )
  })
}
