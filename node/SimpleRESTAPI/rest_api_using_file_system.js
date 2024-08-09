const express = require("express");
const users = require("./MOCK_DATA.json");
const app = express();
const PORT = 8080;
const fs = require("fs");
app.use(express.urlencoded({extended: false}));


//midddleware to log entries of request 
app.use((req, res, next) => {
    fs.appendFile("./Log.txt", `${Date.now()}: ${req.method} ${req.path}\n`, (err, data) => {
        next();
        }
    )
})
// Routes
app.get("/users", (req, res) => {
    const html = `
    <ul>${users.map((user)=>`<li>${user.full_name}</li>`)}</ul>`;
    res.send(html);
})

app.route("/api/users").
    get((req, res) => {
        return res.json(users);
    }).
    post((req, res) => {
        const body = req.body;
        const last_id = users.at(-1).user_id;
        const new_id = Number(last_id) + 1;
        users.push({user_id: new_id, ...body});
        fs.writeFile("./MOCK_DATA.json", JSON.stringify(users), (err, data) => {
            return res.json({status: "success", user_id: new_id });
        })
        
    })
    // post((req, res) => {
    //     const full_name = req.query.full_name;
    //     const email = req.query.email;
    //     const gender = req.query.gender;
    //     const age = req.query.age;
    //     const job_title = req.query.job_title;
    //     const phone_number = req.query.phone_number;
        // const last_id = users.at(-1).user_id;
        // const new_id = Number(last_id) + 1;
        // const newUser = {
        //     "user_id": new_id, 
        //     "full_name": full_name,
        //     "email": email,
        //     "gender": gender,
        //     "age": age, 
        //     "job_title": job_title,
        //     "phone_number": phone_number
        // };
    //     users.push(newUser);
    //     res.json(newUser);
    // });

app.route("/api/users/:id").
    get((req, res) => {
        const id = Number(req.params.id);
        const user = users.find((user) => user.user_id === id);
        return res.json(user);
    }).
    patch((req, res) => {
        const full_name = req.query.full_name;
        const email = req.query.email;
        const gender = req.query.gender;
        const age = req.query.age;
        const job_title = req.query.job_title;
        const phone_number = req.query.phone_number;
        const id = Number(req.params.id);
        let user = users.find((user)=> user.user_id === id);
        if (user === undefined) {
            return res.send("Invalid user!!!");
        }
        user.age = age;
        user.job_title = job_title;
        user.full_name = full_name;
        user.email = email;
        user.gender = gender;
        user.phone_number = phone_number;
        res.json(user);
    }).
    delete((req, res)=> {
        const id = Number(req.params.id);
        let user = users.find((user)=> user.user_id === id);
        if (user===undefined) {
            return res.send("Invalid user");
        }
        users.splice(users.indexOf(user), 1);
        res.json(user);
    })
//Server started
app.listen(PORT, () => {
    console.log("Server started!!!");
})