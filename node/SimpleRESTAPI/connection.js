const mongoose = require('mongoose');

async function connectMongoDb(url) {
    mongoose.connect(url)
        .then(()=> {console.log("Connection success")})
        .catch((err) => {console.log(`Connection failed!!! ${err}`)})
}
module.exports = {connectMongoDb};