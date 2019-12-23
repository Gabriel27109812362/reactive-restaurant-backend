require('dotenv').config();
const firebase = require('firebase');

const firebaseConfig = {
   apiKey: process.env.API_KEY,
   authDomain: process.env.AUTH_DOMAIN,
   databaseURL: process.env.DB_URL,
   projectId: process.env.PROJECT_ID,
   storageBucket: process.env.STORE_BUCKET,
   messagingSenderId: process.env.MESS_SEND_ID,
   appId: process.env.APP_ID,
   measurementId: process.env.MEASURMENT_ID,
};

const project = firebase.initializeApp(firebaseConfig);

const firestore = project.firestore();
// there can add new firebase services for example auth
module.exports = {firestore}; // there add new service to export
