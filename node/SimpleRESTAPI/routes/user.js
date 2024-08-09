const express = require("express");
const router = express.Router();
const { handleGetAllUsers, handleGetUserById, handlePatchUserById, handleDeleteUserById, handleCreateUser} = require('../controllers/user');
const userModel = require("../models/user");
// Routes
router.route("/").
    get(handleGetAllUsers).
    post(handleCreateUser);

router.route("/:id").
    get(handleGetUserById).
    patch(handlePatchUserById).
    delete(handleDeleteUserById);
module.exports = router;