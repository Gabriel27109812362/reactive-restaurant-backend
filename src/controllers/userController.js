const userController = require('express').Router();
const {firestore} = require('services/firebaseService');
const bcrypt=require('bcryptjs')
var salt = bcrypt.genSaltSync(10);
var hash = bcrypt.hashSync("B4c0/\/", salt);

userController.get('/', (req, res) => {
});


userController.post('/', (req,res)=>{
    const name= req.body.name;
    const surname= req.body.surname;
    const email= req.body.email;
    const password= req.body.password;
    
    bcrypt.hash(password, salt, function(err, hash) {
        firestore
        .collection('user')
        .add({name,surname,email,hash});
    });

res.send(hash);
        
});



module.exports = userController;
