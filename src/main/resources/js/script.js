//let url = "http://localhost:36000/clients";
let url = "https://spark-implementation-alejandro.herokuapp.com/clients";
getClients();
let btn = document.getElementById('add-client');
btn.addEventListener('click',() =>{

  let name = document.getElementById("item-input").value;
  let age = document.getElementById("item-price").value;
  let company = document.getElementById("item-company").value;
  let formData = {"nombre":name,"edad":age,"empresa":company};
  axios.post(url, JSON.stringify(formData))
      .then(res => {
        getClients();
      })
      .catch( error =>{
        console.log(error);
      })

});
function getClients(){
  $("#clientTable > tbody").empty();
  axios.get(url).then(res=>{
    res.data.map(row=>{
      $("#clientTable > tbody").append(
          "<tr>" +
          " <td>" + row.nombre + "</td>" +
          " <td>" + row.edad + "</td>" +
          "<td>" + row.empresa + "</td> " +
          "</tr>"
      );
    })
  })
};