const express = require('express');
const app = express();
const PORT = 8080;
const router = require('./routes/url');
const connectToMongoDB = require('./connection');

connectToMongoDB("mongodb://127.0.0.1:27017/url-shortener")
.then(()=> {
    console.log("connected to mongoDB")
})
.catch((err)=> console.log(`connection failed!!! ${err}`));


app.use(express.urlencoded({extended: false}));

app.use("/", router);

app.listen(PORT, ()=> {
    console.log("Server started");
})