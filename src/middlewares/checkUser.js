const { firestore } = require('services/firebaseService');

const checkUser = async(req, res, next) => {
   try {
      const { email } = req.body;
      const existedUser = await firestore
         .collection('user')
         .where('email', '==', email.toString())
         .get();

      existedUser.empty ?
         next() :
         res.status(400)
            .send('user has already exists');

   } catch(e) {
      res.status(500).send(e.message);
   }
};

module.exports = {
   checkUser,
};
