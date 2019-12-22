const express = require('express');
const bodyParser = require('body-parser');
require('dotenv').config();
const user = require('controllers/userController');

const app = express();

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

app.use(require('./router'));

app.listen(process.env.APP_PORT, () => {
   console.log(`Server is listening on port ${process.env.APP_PORT}`);
});









