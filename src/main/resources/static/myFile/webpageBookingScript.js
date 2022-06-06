
// Hotel Booking page

function setValueForCateDetail(id, categories) {
    var category = categories[id];
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
    document.getElementById("numOfBed").value = "Number Of Bed: " + category.numOfBed;
    document.getElementById("numOfPool").value = "Pool: " + pool;
    document.getElementById("viewToBeach").value = "View To Beach: " + viewToBeach;
    document.getElementById("pricePerDay").value = "Price Per Day: $" + category.pricePerDay;
}

function removeCategoryDetail() {
    document.getElementById("numOfBed").value = "";
    document.getElementById("numOfPool").value = "";
    document.getElementById("viewToBeach").value = "";
    document.getElementById("pricePerDay").value = "";
}

function categoryChangeValue(){
    removeCategoryDetail();
    removeSelectRoom();
    document.getElementById("total").value = "Total Price: ";
}


// Select Room
function insertSelectRoom(rooms) {
    var roomNumber = $('#selectRoomNumber');
    roomNumber.empty();
    var textHTML = '<select class="form-control" id="roomId" name="roomId">';
    textHTML += '<option value="">Choose The Room</option>';
    for (var i = 0; i < rooms.length; i++) {
        textHTML += '<option value=' +rooms[i].id+'>' + rooms[i].roomNumber + '</option>';
    }
    textHTML += '</select>';
    roomNumber.append(textHTML);
}

function removeSelectRoom() {
    var roomNumber = $('#selectRoomNumber');
    roomNumber.empty();
    roomNumber.append('<input type="text" class="form-control" disabled placeholder="Choose the room">');
}

function getRoom(data) {
    return new Promise(function (resolve, reject) {
        var urlApi = "/api/webpage/room";
        $.ajax({
            url: urlApi,
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                resolve(result);
            },
            error: function (error) {
                reject();
            }
        });
    })
}



// Booking function

function getCustomerData() {
    var data = {};
    data["fullName"] = $("#fullName").val();
    data["identity"] = $("#identity").val();
    data["phoneNumber"] = $("#phoneNumber").val();
    data["email"] =  $("#email").val();
    return data;
}

function getBookingData() {
    var data = {};
    data["lastStayDay"] = $("#lastStayDay").val();
    data["startStayDay"] = $("#startStayDay").val();
    data["numOfStay"] =  $("#numOfStay").val();
    data["roomId"] = $("#roomId").val();
    data["categoryId"] = $("#categoryId").val();
    data["total"] = total;
    return data;
}

function sendMail(data) {
    $.ajax({
        url: '/api/webpage/mail',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {

        }
    });
}

function createBooking(data) {
    $.ajax({
        url: '/api/webpage/booking',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (result) {
            sendMail(result);
            Swal.fire(
                'Booking Hotel Successfully!',
                'You has been booked a hotel.',
                'success'
            ).then(function (e) {
                window.location.href = "/webpage/bookingDetail?bookingId=" + result.id;
            })
        },
        error: function (error) {
            Swal.fire({
                title: 'Error System',
                text: "We are fixing it right now",
                icon: 'warning',
                confirmButtonColor: '#2F8B85',
                confirmButtonText: "OK",
            })
        }
    });
}

function createCustomer(data) {
    return new Promise(function (resolve,reject) {
        $.ajax({
            url: '/api/webpage/customer',
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

function addBooking() {
    let promise1 = checkAllFieldFilled();

    // promise1
    promise1.then(function () {
        let promise2 = checkEmail();

        // promise2
        promise2.then(function () {
            var customer = getCustomerData();
               let promise3 = createCustomer(customer);

               // promise3
               promise3.then(function (result) {
                   var bookingData = getBookingData();
                   bookingData["customerBooking"] = result;
                   createBooking(bookingData);

               }).catch(function () {
                   showApiError();
               })
        }).catch(function () {
            showCheckEmailAlert();
        })
    }).catch(function () {
        showCheckAllFieldFillAlert();
    })
}

// -- time function

function checkTwoTime(firstTime, lastTime) {
    if (firstTime && lastTime) {
        if (lastTime < firstTime) {
            removeSelectRoom();
            Swal.fire({
                title: 'Error Time Input',
                text: "Last time have to higher or equal than start time",
                icon: 'warning',
                confirmButtonColor: '#2F8B85',
                confirmButtonText: "Yes",
            })
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}

function checkFirstTime(firstTime, currentTime) {
    if (firstTime && lastTime) {
        if (firstTime < currentTime) {
            $("#startStayDay").val("");
            removeSelectRoom();
            Swal.fire({
                title: 'Error Time Input',
                text: "First time have to higher or equal than current time",
                icon: 'warning',
                confirmButtonColor: '#2F8B85',
                confirmButtonText: "Yes",
            })
            return false;
        } else {
            return true;
        }
    }else {
        return false;
    }
}

function checkLastTime(lastTime, currentTime) {
    if (firstTime && lastTime) {
        if (lastTime < currentTime) {
            $("#lastStayDay").val("");
            removeSelectRoom();
            Swal.fire({
                title: 'Error Time Input',
                text: "Last time have to higher or equal than current time",
                icon: 'warning',
                confirmButtonColor: '#2F8B85',
                confirmButtonText: "Yes",
            })
            return false;
        } else {
            return true;
        }
    } else {
        return false;
    }
}

function setTimeDate(firstTime, lastTime) {
    firstTime = new Date(firstTime).toJSON().substring(0,10);
    lastTime = new Date(lastTime).toJSON().substring(0,10);
    var data = {};
    data["startStayDay"] = firstTime;
    data["lastStayDay"] = lastTime;
    return data;
}



