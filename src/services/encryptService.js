const bcrypt = require('bcryptjs');
require('dotenv').config();
const salt = bcrypt.genSaltSync(Number(process.env.SALT_ROUNDS));

const encrypt = (plainPassword) => {
   return bcrypt.hashSync(plainPassword, salt);
};

const compare = (plainPassword, hash) => {
   return bcrypt.compareSync(plainPassword, hash);
};

module.exports = {
   encrypt,
   compare,
};



