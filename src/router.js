const router = require('express').Router();

router.get('/', ((req, res) => {
   res.json({message: 'welcome in reactive-restaurant REST API'});
}));

// TODO: there import controllers

module.exports = router;
