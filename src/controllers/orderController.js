const orderController = require('express').Router();
const {firestore} = require('services/firebaseService');
const dbRef = firebase.database().ref();
const ordersRef = dbRef.child('orders');

orderController.get('/', (req, res) => {
});



function createOrder(order){
    ordersRef.push(order);
    console.log("data inserted")
}

function deleteOrder(order){
    
        
        const orderID = order.target.getAttribute("orderid");
        const orderRef = dbRef.child('orders/' + orderID);
        orderRef.remove()
        console.log("data removed")
    
}
function getOrderList(){

const orderList = document.getElementById("orderList");
usersRef.on("child_added", snap => {
    let order = snap.val();
    let $li = document.createElement("li");
    $li.innerHTML = user.name;
    $li.setAttribute("child-key", snap.key);
    orderList.append($li);
    });
return userList
}

