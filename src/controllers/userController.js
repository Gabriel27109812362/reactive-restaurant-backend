require('dotenv').config();
const userController = require('express').Router();
const { firestore } = require('services/firebaseService');
const { encrypt, compare } = require('services/encryptService');
const { checkUser } = require('middlewares/checkUser');
const jwt = require('jsonwebtoken');

userController.get('/', (req, res) => {});

userController.post('/register', checkUser, (req, res) => {
  try {
    const { name, surname, email, password } = req.body;
    const hash = encrypt(password);
    const user = { name, surname, email, hash };

    firestore.collection('user').add(user);

    res.sendStatus(201);
  } catch (e) {
    res.status(500).send(e.message);
  }
});

userController.post('/auth', async (req, res) => {
  try {
    const { email, password } = req.body;
    const user = await firestore
      .collection('user')
      .where('email', '==', email.toString())
      .get();

    if (user.size === 0) {
      res.sendStatus(404);
    }
    if (user.size > 1) {
      res.sendStatus(500);
    }

    let foundedUser;
    user.forEach((doc) => (foundedUser = doc.data()));

    if (!compare(password, foundedUser.hash)) {
      res.status(403).send({ message: 'access denied' });
    }

    const token = jwt.sign(
      { email, password },
      process.env.ACCESS_TOKEN_SECRET,
      { algorithm: 'HS256', expiresIn: '1d' }
    );

    res.status(200).send({ accessToken: token });
  } catch (e) {
    res.status(500).send(e.message);
  }
});

module.exports = userController;
