const router = require('express').Router();

router.get('/', ((req, res) => {
   res.json({message: 'welcome in reactive-restaurant REST API'});
}));

router.use('/user', require('controllers/userController'));

// TODO: there import controllers

module.exports = router;
