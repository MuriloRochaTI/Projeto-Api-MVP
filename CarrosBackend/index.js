const app = require("express")()
const http = require("http").createServer(app)
const bodyParser = require("body-parser")

app.use(bodyParser.urlencoded({
    extended:true
}));

app.use(bodyParser.json());

let carros = [{ 
        "id": 1,
        "nome": "Fusca",
        "data_lancamento": 20190625,
        "placa" : 742887424,
        "fabricante" : "Volkswagen"
    },
    { 
        "id": 2,
        "nome": "Fusca2",
        "data_lancamento": 20100625,
        "placa" : 742887424,
        "fabricante" : "Volkswagen"
    },]

let idCarro = 2

app.get("/carros/:id", (req,res)=>{
	
	carroArr = carros.filter(a => a.id == req.params.id)
	
	carro = {
		"id": carroArr[0].id,
        "nome": carroArr[0].nome,
        "data_lancamento": carroArr[0].data_lancamento,
        "placa" : carroArr[0].placa,
        "fabricante" : carroArr[0].fabricante
	};
	
	//*** PROGRESSBAR ***
	setTimeout(()=>{
		
		res.send(carro)
	}, 2000)
})

app.get("/carros", (req,res)=>{
	
		res.send(carros)
	
})

app.post("/carro/novo", (req, res)=> {
  
    idCarro ++
	console.log(req.body)
   
	const id = idCarro
    const nome = req.body.nome
    const data_lancamento = req.body.data_lancamento
    const placa = req.body.placa
    const fabricante = req.body.fabricante
    
    
    const novoCarro = { 
                       id, 
                       nome,
                       data_lancamento,
                       placa,
                       fabricante
                      }
    
    carros.push(novoCarro)
    res.send({ "sucesso" :true, "msg": "Add com sucesso" })    
})


app.get("/",(req, res)=> {    
    res.send("Bem vindo a API de Carros")
})


http.listen(5002, ()=> {
    console.log("Server running on http://localhost:5002")
})