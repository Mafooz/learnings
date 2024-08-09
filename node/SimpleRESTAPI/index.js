const express = require("express");
const app = express();
const PORT = 8080;
const {connectMongoDb} = require('./connection');
const User = require('./models/user');
const userRouter = require('./routes/user');
const {logReqRes} = require('./middlewares/logRequest');

connectMongoDb("mongodb://127.0.0.1:27017/youtube-app-1").then(()=> {
    console.log("Mongo db connected!");
}).catch(() => console.log("Mongo db connection failed!!!"));


//midddleware to log entries of request 
app.use(express.urlencoded({extended: false}));
app.use(logReqRes('Log.txt'));

app.use('/users', userRouter);

app.listen(PORT, () => {
    console.log("Server started!!!");
})