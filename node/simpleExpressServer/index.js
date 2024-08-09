const express = require("express");
const url = require("url");
const http = require("http");
const app = express();

app.get("/", (req, res)=> {
    return res.send("Hello from Home page");
})

app.get("/about", (req,res)=>{
    res.send("Hello from about page")
})

app.post("/about", (req, res) => {
    res.send("Hello from " + req.query.name + " with " + req.query.age);
})

app.listen(8080, ()=> {console.log("Server started")});