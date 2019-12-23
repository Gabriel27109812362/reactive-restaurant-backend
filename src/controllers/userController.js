const userController = require('express').Router();
const {firestore} = require('services/firebaseService');

userController.get('/', (req, res) => {

});

module.exports = userController;
