
function myFunction(link) {
  location.replace(link+".html")
}


function list(){
    var nomeMotorista = $.getJSON("http://localhost:8080/getMotoristas")
    var obj = JSON.parse(JSON.stringify(nomeMotorista))
    var list = [];
    for(var k in obj){
        list[k] = obj[k].nome;
    }
    document.getElementById("opcoes").innerHTML = list[0];
    document.getElementById("nome2").innerHTML = list[1];
    document.getElementById("nome3").innerHTML = list[2];
}
