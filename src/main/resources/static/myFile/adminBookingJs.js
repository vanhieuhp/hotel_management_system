
function pagination(currentPage, totalPage, status) {
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 5,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    currentPage = page;
                    getItem(page, 5, status);
                }
            }
        });
    });
}

function getItem(page, limit, status) {
    var strURL = "/api/admin/booking/list?page="+page+"&limit="+limit+"&status="+status;
    $.ajax({url: strURL, type: 'GET'
    }).done(function(response) {
        var tableBody = $("#table_body");
        tableBody.replaceWith(response);
    }).fail(function(response) {
        console.log("error");
    });
}

function checkin(id) {
    Swal.fire({
        title: 'Check In',
        text: 'Do you want to check in!',
        icon: 'question',
        showCancelButton: true,
        showConfirmButton: true,
        cancelButtonColor: '#dd2222',
        confirmButtonColor: 'rgb(18,150,3)',
        cancelButtonText: 'Cancel',
        confirmButtonText: 'OK'
    }).then(function(result) {
        if (result.isConfirmed) {
            updateBooking(id, "checkin");
        }
    })
}

function checkout(id) {
    Swal.fire({
        title: 'Check Out',
        text: 'Do you want to check out!',
        icon: 'question',
        showCancelButton: true,
        showConfirmButton: true,
        cancelButtonColor: '#dd2222',
        confirmButtonColor: 'rgb(18,150,3)',
        cancelButtonText: 'Cancel',
        confirmButtonText: 'OK'
    }).then(function(result) {
        if (result.isConfirmed) {
            updateBooking(id, "checkout");
        }
    })
}

function updateBooking(id, stringUrl) {
    var apiURl = "/api/admin/booking/"+stringUrl;
    $.ajax({
        url: apiURl,
        type: 'PUT',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(id),
        success: function (result) {
            Swal.fire(
                'Check In!',
                'Your hotel has been checked in successfully!.',
                'success'
            ).then(function (e) {
                window.location.href = "/admin/booking/"+stringUrl+"?limit=5&page=" + currentPage;
            })
        },
        error: function (error) {
            Swal.fire(
                'Error system!'
            ).then(function (e) {
                window.location.href = "/admin/booking/"+stringUrl+"?limit=5&page=" + currentPage;
            })
        }
    });
}

function printButton(id) {
    let promise = alertPrintQuestion();
    promise.then(function () {
        printPDf(id);
    }).catch(function () {

    })
}

function alertPrintQuestion() {
    return new Promise(function (resolve, reject) {
        Swal.fire({
            title: 'Print PDF',
            text: 'Do you want to print PDF file',
            icon: 'question',
            showCancelButton: true,
            showConfirmButton: true,
            cancelButtonColor: '#dd2222',
            confirmButtonColor: 'rgb(18,150,3)',
            cancelButtonText: 'Cancel',
            confirmButtonText: 'Ok'
        }).then(function(result) {
            if (result.isConfirmed) {
                resolve();
            }else {
                reject();
            }
        })
    })
}

function printPDf(id) {
    window.location.href = "http://localhost:8090/admin/booking/pdf?id=" +id;
}