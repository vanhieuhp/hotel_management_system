function findBooking() {
    var identity = $('#identitySearch').val();

    if (identity != '') {
        var data = {};
        data["identity"] = identity;
        // promise1
       let promise1 =  findCustomerByIdentity(data);
       promise1.then(function (result) {
           if (result != '') {
               data["customerId"] = result.id;

               // promise2
               let promise2 = findBookingByCustomerId(data);
               promise2.then(function (result) {
                   setDetailBookingInfo(result);

               }).catch(function () {
                   showApiError();
               })
           } else {
               showDontFindCustomerAlert();
           }


       }).catch(function () {
           showApiError();
       })
    }
}

function showDontFindCustomerAlert() {
    Swal.fire({
        title: 'Your Booking does not exist!',
        text: "Please try again",
        icon: 'success',
        confirmButtonColor: '#2F8B85',
        confirmButtonText: "OK",
    })
}

function findCustomerByIdentity(data) {
    return new Promise(function (resolve, reject) {
        $.ajax({
            url: '/api/webpage/findCustomer',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            // dataType: 'json'
        }).done(function(result) {
            resolve(result);
        }).fail(function(result) {
            reject();
        });
    })
}

function findBookingByCustomerId(data) {
    return new Promise(function (resolve, reject) {
        $.ajax({
            url: '/api/webpage/findBooking',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            dataType: 'json'
        }).done(function(result) {
            resolve(result);
        }).fail(function(result) {
            reject();
        });
    })
}

function setDetailBookingInfo(booking) {
    var category = booking.bookingRoom.category;
    var customer = booking.customerBooking;
    var pool, viewToBeach;
    if(category.numOfPool == 1){
        pool = "Yes";
    } else {
        pool = "No";
    }
    if (category.viewToBeach == 1){
        viewToBeach = "Yes";
    } else {
        viewToBeach = "No";
    }

    document.getElementById("category").value = "Category: " + category.name;
    document.getElementById("numOfPool").value = "Pool: " + pool;
    document.getElementById("viewToBeach").value = "View To Beach: " + viewToBeach;
    document.getElementById("pricePerDay").value = "Price Per Day: $" + category.pricePerDay;
    document.getElementById("startStayDay").value = "Start Stay Day: " + booking.startStayDay;
    document.getElementById("lastStayDay").value = "Last Stay Day: " + booking.lastStayDay;
    document.getElementById("numOfStay").value = "Number of days of stay: " + booking.numOfStay;
    document.getElementById("roomNumber").value = "Choose The Room: " + booking.bookingRoom.roomNumber;
    document.getElementById("total").value = "Total: $" + booking.total;
    document.getElementById("fullName").value = "Your Name: " + customer.fullName;
    document.getElementById("email").value = "Your Email: " + customer.email;
    document.getElementById("identity").value = "Your Identity: " + customer.identity;
    document.getElementById("phoneNumber").value = "Your Phone: " + customer.phoneNumber;

}