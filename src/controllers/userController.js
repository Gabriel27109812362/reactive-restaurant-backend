const userController = require('express').Router();
const { firestore } = require('services/firebaseService');
const { encrypt } = require('services/encryptService');

userController.get('/', (req, res) => {
});

userController.post('/register', (req, res) => {
   try {
      const { name, surname, email, password } = req.body;
      const hash = encrypt(password);
      const user = { name, surname, email, hash };

      firestore
         .collection('user')
         .add(user);

      res.sendStatus(201);
   } catch(e) {
      res.status(500).send(e.message);
   }

});









module.exports = userController;
