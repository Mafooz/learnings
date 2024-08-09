const User = require('../models/user')

async function handleGetAllUsers(req, res) {
    let dbAllUsers = await User.find({});
    res.json(dbAllUsers);
}

async function handleGetUserById (req, res) {
    const id = req.params.id;
    const user = await User.findById(id);
    if (!user) return res.status(404).json({error: "User not found"});
    return res.json(user);
}

async function handlePatchUserById (req, res) {
    console.log(req.body);
    await User.findByIdAndUpdate(req.params.id, req.body);
    return res.json({status: "Success"});
}
async function handleDeleteUserById (req, res) {
    await User.findByIdAndDelete(req.params.id);
    return res.json({status: "Success"});
}

async function handleCreateUser (req, res) {
    const body = req.body;
    let err = {errorMessage: ""};
    if (!validate(body, err)) {
        return res.status(400).json({"errorMessage": err.errorMessage});
    }
    const user = await User.create({
        full_name: body.full_name,
        email: body.email,
        gender: body.gender,
        job_title: body.job_title,
        phone_number: body.phone_number,
        age: body.age,
        department: body.department,
        location: body.location,
        join_date: body.join_date
    });
    return res.status(201).json({'status': 'success'});
}

const validate = (body, err) => {
    let requiredList = ["full_name", "email", "gender", "job_title", "phone_number"];
    for (let requiredEntity of requiredList) {
        if (body[requiredEntity]==null) {
            err.errorMessage = requiredEntity + " can not be null";
            console.log(err.errorMessage);
            return false;
        }
    } 
    return true;
}

module.exports = {
    handleGetAllUsers,
    handleGetUserById,
    handlePatchUserById,
    handleDeleteUserById,
    handleCreateUser
}