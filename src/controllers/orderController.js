const orderController = require('express').Router();
const { firestore } = require('services/firebaseService');
const dbRef = firebase.database().ref();
const ordersRef = dbRef.child('orders');

orderController.get('/', (req, res) => {});

